/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/encryption
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class Encryption {

    public static void main(String[] args) {
        Scanner input = new Scanner(System. in );
        String line = input.nextLine();

        double size = line.length();
        double columns = Math.ceil(Math.sqrt(size));

        /* total of columns number of words */
        for (int i = 0; i < columns; i++) {
            /* print every columns character */
            for (int j = i; j < size; j += columns) {
                System.out.print(line.charAt(j));
            }
            System.out.print(" ");
        }
    }
}