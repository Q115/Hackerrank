/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/lego-blocks
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Scanner;

public class LegoBlocks {
    static long nonSolid[] = new long[1001];
    static long solid[][] = new long[1001][1001];

    static int temp[]; // = new int[1001];
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );

        int H, W, T;
        T = in .nextInt();
        nonSolid[0] = 1;
        nonSolid[1] = 1;

        for (int i = 0; i < T; i++) {
            temp = new int[1001];
            H = in .nextInt();
            W = in .nextInt();

            if (H == 1) {
                if (W > 4) {
                    System.out.println("0");
                    continue;
                } else {
                    System.out.println("1");
                    continue;
                }
            }

            getNonSolid(W);
            System.out.println(getSolid(H, W));
        }
    }

    public static long getSolid(int H, int W) {
        if (solid[H][W] != 0)
            return solid[H][W];
        if (W == 1)
            solid[H][W] = 1;
        else if (W == 2)
            solid[H][W] = getTotal(H, 2, 1) - 1; //could be wrong here if it's negative
        else {
            long nonSolidWall = getTotal(H, nonSolid[W], 1);

            long sum = 0;
            long nonSolidWall2 = 0;
            long tempSum = 0;
            for (int i = 1; i < W; i++) {
                if (temp[i] == 0)
                    temp[i] = (int) getTotal(H, nonSolid[i], 1);

                tempSum = (temp[i] * getSolid(H, W - i)) % 1000000007;
                sum += tempSum;
            }
            sum = sum % 1000000007;

            if (nonSolidWall - sum < 0)
                solid[H][W] = 1000000007 + nonSolidWall - sum;
            else
                solid[H][W] = (nonSolidWall - sum) % 1000000007;
        }

        return solid[H][W];
    }

    public static long getNonSolid(int W) {
        if (W < 0)
            return 0;
        if (nonSolid[W] != 0)
            return nonSolid[W];

        nonSolid[W] = (getNonSolid(W - 1) + getNonSolid(W - 2) +
            getNonSolid(W - 3) + getNonSolid(W - 4)) % 1000000007;
        return nonSolid[W];
    }

    public static long getTotal(int exponent, long base, long left) {
        while (exponent > 1) {
            if (exponent % 2 == 1) {
                left = (left * base) % 1000000007;
            }
            exponent = exponent / 2;
            base = (base * base) % 1000000007;
        }
        return (base * left) % 1000000007;
    }
}