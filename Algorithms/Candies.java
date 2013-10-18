/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/candies
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Scanner;

public class Candies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        long sum = 0;
        int left = 0;
        int right = 0;
        int N = in .nextInt();;
        int[] ratings = new int[N];

        for (int i = 0; i < N; i++) {
            ratings[i] = in .nextInt();
        }

        int num = 1; //number of candy to give a kid
        for (int i = N - 1; i >= 0; i--) {
            if (i == 0 && ratings[i] < ratings[i + 1]) {
                sum += num;
                break;
            } else if (i == 0 && ratings[i] > ratings[i + 1]) {
                sum += 2;
                break;
            } else if (i == 0 && ratings[i] == ratings[i + 1]) {
                sum += 1;
                break;
            }

            /* if kid to the right is less than kid to the left, give
             * one more candy to the kid on the right
             */
            if (ratings[i] < ratings[i - 1]) {
                sum += num++;
            } else {
                left = num;
                num = 1;
                int j;
                for (j = i; j > 0; j--) {
                    if (ratings[j] <= ratings[j - 1]) {
                        for (int k = j; k < i; k++) {
                            sum += num++;
                        }
                        right = num;
                        if (right > left)
                            sum += right;
                        else
                            sum += left;
                        i = j;

                        break;
                    }
                }
                if (j <= 0) {
                    for (int k = 0; k <= j; k++) {
                        sum += num++;
                    }
                    right = num;
                    if (right > left)
                        sum += right;
                    else
                        sum += left;
                    i = j;
                    break;
                }
                if (ratings[i] == ratings[i - 1])
                    num = 1;
                else
                    num = 2;
            }
        }
        System.out.println(sum);
    }
}