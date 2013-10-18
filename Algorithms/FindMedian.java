/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/find-median
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindMedian {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        line = br.readLine();
        int[] ar = new int[N];
        
        String temp[]=line.split(" ");
        for(int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(ar);
        System.out.println(ar[N/2]);
    }
}
