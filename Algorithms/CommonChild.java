/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/common-child
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String B = br.readLine();
        String A = br.readLine();

        int[][] grid = new int[A.length()+1][B.length()+1];
        int max = 0;
        
        //extra padding
        for(int i = 1; i < B.length() + 1; i++) {
            for (int j = 1; j < A.length() +1; j++) {
                
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    grid[i][j] = grid[i-1][j-1] + 1;    
                    max = Math.max(max, grid[i][j]);
                } else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]);
                }
            }
        }

        System.out.println(max);
    }
}
