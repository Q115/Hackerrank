/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/flowers
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */

import java.util.*;

class Solution {
    public static void main(String args[]) {
        // helpers for input/output      

        Scanner in = new Scanner(System. in );

        int N, K;
        N = in .nextInt();
        K = in .nextInt();

        int C[] = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = in .nextInt();
        }
        int num = 0, sum = 0;
        Arrays.sort(C);
        for (int i = N - 1, j = 0; i >= 0; i--, j++) {
            if (j % K == 0)
                num++;
            sum += C[i] * num;
        }
        System.out.println(sum);
    }
}