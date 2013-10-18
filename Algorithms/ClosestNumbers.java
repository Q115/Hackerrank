/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/closest-numbers
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int N = in .nextInt();

        int[] ar = new int[N];

        for (int i = 0; i < N; i++)
            ar[i] = in .nextInt();

        Arrays.sort(ar);

        int count = Integer.MAX_VALUE;
        ArrayList < Integer > al = new ArrayList < Integer > ();

        for (int i = 1; i < N; i++) {
            if (Math.abs(ar[i] - ar[i - 1]) < count)
                count = Math.abs(ar[i] - ar[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            if (Math.abs(ar[i] - ar[i - 1]) == count)
                sb.append(ar[i - 1] + " " + ar[i] + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}