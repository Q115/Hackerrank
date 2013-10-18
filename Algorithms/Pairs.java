/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/pairs
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );

        int N, K;
        N = in .nextInt();
        K = in .nextInt();

        int[] nums = new int[N];
        int counter = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = in .nextInt();
        }

        Hashtable t = new Hashtable < Integer, Integer > ();
        for (int i = 0; i < N; i++) {
            t.put(nums[i], 1);
        }

        for (int i = 0; i < N; i++) {
            if (t.containsKey(nums[i] + K) && t.containsKey(nums[i] - K)) {
                counter += 2;
                t.remove(nums[i]);
            } else if (t.containsKey(nums[i] + K)) {
                counter++;
                t.remove(nums[i]);
            } else if (t.containsKey(nums[i] - K)) {
                counter++;
                t.remove(nums[i]);
            }
        }

        System.out.print(counter);
    }
}