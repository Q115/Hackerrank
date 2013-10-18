/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/stockmax
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Scanner;

public class StockMaximize {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );

        int T, N;
        T = in .nextInt();

        for (int i = 0; i < T; i++) {
            N = in .nextInt();
            int[] ar = new int[N];
            for (int j = 0; j < N; j++) {
                ar[j] = in .nextInt();
            }

            System.out.println(findMax(ar));
        }
    }

    public static long findMax(int[] ar) {
        int size = ar.length;
        int max = ar[size - 1];
        int index = 0;
        long profit = 0;
        for (int i = size - 1; i > 0; i--) {
            //check if exist
            if (ar[i] > ar[i - 1]) {
                index = i;
                max = ar[i];
                if (index - 1 < 0)
                    break;
                int j = index - 1;
                for (; j >= 0; j--) {
                    if (ar[j] <= max) {
                        profit += max - ar[j];
                    } else {
                        i = j + 1;
                        break;
                    }
                }
                if (j < 0)
                    return profit;
            }

        }

        return profit;
    }
}