/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/anagram
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in ));
        String line = br.readLine();

        int T = Integer.parseInt(line);

        for (int i = 0; i < T; i++) {
            line = br.readLine();
            int size = line.length();
            int[] ar = new int[26];

            if (size % 2 == 1) {
                System.out.println("-1");
                continue;
            } else {
                for (int j = 0; j < size / 2; j++) {
                    ar[line.charAt(j) - 'a']++;
                }

                for (int j = size / 2; j < size; j++) {
                    ar[line.charAt(j) - 'a']--;
                }

                int count = 0;
                for (int j = 0; j < 26; j++) {
                    if (ar[j] > 0) count += ar[j];
                }

                System.out.println(count);
            }
        }
    }
}