/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/saveprincess
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class BotSavesPrincess {
    /* Head ends here */
    static void displayPathtoPrincess(int n, String[] grid) {
        int pX = 0;
        int pY = 0;
        int sX = 0;
        int sY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'm') {
                    sX = i;
                    sY = j;
                    break;
                }
            }
        }
        if (grid[0].charAt(0) == 'p') {
            pX = 0;
            pY = 0;
        } else if (grid[0].charAt(n - 1) == 'p') {
            pX = 0;
            pY = n - 1;
        } else if (grid[n - 1].charAt(0) == 'p') {
            pX = n - 1;
            pY = 0;
        } else {
            pX = n - 1;
            pY = n - 1;
        }

        while (true) {
            if (pX > sX) {
                System.out.println("DOWN");
                sX++;
            } else if (pX < sX) {
                System.out.println("UP");
                sX--;
            } else if (pY > sY) {
                System.out.println("RIGHT");
                sY++;
            } else if (pY < sY) {
                System.out.println("LEFT");
                sY--;
            } else
                break;
        }
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int m;
        m = in .nextInt();
        String grid[] = new String[m];
        for (int i = 0; i < m; i++) {
            grid[i] = in .next();
        }

        displayPathtoPrincess(m, grid);
    }
}