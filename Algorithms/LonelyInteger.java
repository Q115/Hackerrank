/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/lonely-integer
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Scanner;

public class LonelyInteger {
    static int array[] = new int[101];
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );

        int N, A;
        N = in .nextInt();

        for (int i = 0; i < N; i++) {
            A = in .nextInt();
            array[A]++;
        }

        for (int i = 0; i < 101; i++) {
            if (array[i] == 1) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}