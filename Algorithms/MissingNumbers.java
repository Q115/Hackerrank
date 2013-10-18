/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/missing-numbers
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in ));

        String line = br.readLine();

        int N = Integer.parseInt(line);
        int[] ar = new int[202];

        line = br.readLine();
        String[] ars = line.split(" ");

        int temp = Integer.parseInt(ars[0]);
        ar[101]++;

        for (int i = 1; i < N; i++) {
            ar[101 - temp + Integer.parseInt(ars[i])]++;
        }

        int M = Integer.parseInt(br.readLine());
        ars = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            ar[101 - temp + Integer.parseInt(ars[i])]--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 202; i++) {
            if (ar[i] < 0)
                sb.append(temp - 101 + i + " ");
        }

        //get rid of last space
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}