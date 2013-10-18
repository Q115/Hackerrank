/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/saveprincess2
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class BotSavesPrincess2 {
    /* Head ends here */
    static void nextMove(int n, int x, int y, String[] board) {
        int pX = 0;
        int pY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == 'p') {
                    pX = i;
                    pY = j;
                    break;
                }
            }
        }
        if (pX > x) {
            System.out.println("DOWN");
            x++;
        } else if (pX < x) {
            System.out.println("UP");
            x--;
        } else if (pY > y) {
            System.out.println("RIGHT");
            y++;
        } else if (pY < y) {
            System.out.println("LEFT");
            y--;
        }
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int n, x, y;
        n = in .nextInt();
        x = in .nextInt();
        y = in .nextInt(); in .useDelimiter("\n");
        String board[] = new String[n];


        for (int i = 0; i < n; i++) {
            board[i] = in .next();
        }

        nextMove(n, x, y, board);

    }
}