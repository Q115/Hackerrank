/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/botcleanr
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class BotCleanStochastic {

    /* Head ends here */
    static void nextMove(int posx, int posy, String[] board) {
        int x = 0;
        int y = 0;

        if (board[posx].charAt(posy) == 'd') {
            System.out.println("CLEAN");
            return;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i].charAt(j) == 'd') {
                    x = i;
                    y = j;
                }
            }
        }

        if (x > posx) System.out.println("DOWN");
        else if (x < posx) System.out.println("UP");
        else if (y > posy) System.out.println("RIGHT");
        else if (y < posy) System.out.println("LEFT");
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int[] pos = new int[2];
        String board[] = new String[5];
        for (int i = 0; i < 2; i++) pos[i] = in .nextInt();
        for (int i = 0; i < 5; i++) board[i] = in .next();
        nextMove(pos[0], pos[1], board);
    }
}