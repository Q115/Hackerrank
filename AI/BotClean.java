/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/botclean
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class BotClean {

    /* Head ends here */
    static void next_move(int posx, int posy, String[] board) {
        //add logic here
        int min = 99;
        int minx = 0;
        int miny = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i].charAt(j) == 'd') {
                    if (Math.abs(posx - i) + Math.abs(posy - j) < min) {
                        minx = i;
                        miny = j;
                        min = Math.abs(posx - i) + Math.abs(posy - j);
                    }
                }
            }
        }

        if (posy < miny)
            System.out.println("RIGHT");
        else if (posx < minx)
            System.out.println("DOWN");
        else if (posy > miny)
            System.out.println("LEFT");
        else if (posx > minx)
            System.out.println("UP");
        else
            System.out.println("CLEAN");
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int[] pos = new int[2];
        String board[] = new String[5];
        for (int i = 0; i < 2; i++) pos[i] = in .nextInt();
        for (int i = 0; i < 5; i++) board[i] = in .next();
        next_move(pos[0], pos[1], board);
    }
}