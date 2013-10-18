/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/substring-diff
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SubstringDiff {
    public static void main(String[] args) {
        Scanner s = new Scanner(System. in );
        int T = s.nextInt();
        s.nextLine();
        String[] line;
        int K;
        String P;
        String Q;

        for (int i = 0; i < T; i++) {
            line = s.nextLine().split(" ");
            K = Integer.parseInt(line[0]);
            P = line[1];
            Q = line[2];
            System.out.println(getNum(K, P, Q));
        }
    }

    public static int getNum(int K, String P, String Q) {
        int size = P.length();
        int[][] table = new int[size + 1][size + 1];
        int max = 0;

        //http://en.wikipedia.org/wiki/Longest_common_substring_problem
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (P.charAt(i) == Q.charAt(j)) {
                    table[i + 1][j + 1] = table[i][j] + 1;
                    /*
                    if(table[i+1][j+1]==4)
                    {
                        System.out.print("");
                    }
                     */
                    max = Math.max(max, table[i + 1][j + 1]);
                }
            }
        }

        //if k==0; then it's just the longest substring
        if (K != 0) {
            int max_k = Math.min(max + K, size);

            //nothing in common, just return max_k
            if (max == 0)
                return max_k;

            //get zeros and the number before it eg: 0 4 0 0 1 0 0 
            ArrayList < Integer > diagonal = new ArrayList < Integer > ();

            int count = 0;

            //get diagonal entries, main diagonal is duplicated
            for (int i = 0; i < size - max_k; i++) {
                //lower triangle
                for (int j = 1; j <= size - i; j++) {
                    if (table[i + j][j] == 0) {
                        if (table[i + j - 1][j - 1] != 0) {
                            diagonal.add(table[i + j - 1][j - 1]);
                            diagonal.add(0);
                        } else
                            diagonal.add(0);
                    }
                }
                //get last element
                if (table[size][size - i] != 0)
                    diagonal.add(table[size][size - i]);

                max_k = Math.max(getMax(diagonal, K, size), max_k);
                if (i == 674 || i == 469) {
                    System.out.print("");
                }
                diagonal.clear();

                if (i == 0)
                    continue;

                //upper triangle
                for (int j = 1; j <= size - i; j++) {
                    if (table[j][j + i] == 0) {
                        if (table[j - 1][j + i - 1] != 0) {
                            diagonal.add(table[j - 1][j + i - 1]);
                            diagonal.add(0);
                        } else
                            diagonal.add(0);
                    }
                }

                //get last element if applicable
                if (table[size - i][size] != 0)
                    diagonal.add(table[size - i][size]);

                max_k = Math.max(getMax(diagonal, K, size), max_k);
                diagonal.clear();

            }

            return max_k;
        } else
            return max;
    }

    public static int getMax(ArrayList < Integer > diagonal, int K, int length) {
        int size = diagonal.size();

        if (size < K) {
            return length;
        }
        int sum = 0;
        int max = 0;
        int temp = K;

        int i = 0;
        for (i = 0; i < size && temp > 0; i++) {
            if (diagonal.get(i) == 0) {
                temp--;
                continue;
            }
            sum += diagonal.get(i);
        }

        if (i < size && diagonal.get(i) != 0) {
            sum += diagonal.get(i);
            i++;
        }

        max = sum;

        int j = i;
        i = 0;
        for (; j < size; j++, i++) {
            if (j + 1 < size && diagonal.get(j) == 0 && diagonal.get(j + 1) != 0) {
                sum += diagonal.get(j + 1);
                j++;
            } else {
                sum += diagonal.get(j);
            }
            if (diagonal.get(i) != 0) {
                sum -= diagonal.get(i);
                i++;
            }

            max = Math.max(max, sum);
        }

        return Math.min(max + K, length);
    }

}