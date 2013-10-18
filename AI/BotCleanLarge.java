/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/botcleanlarge
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

public class BotCleanLarge {
    /* Head ends here */
    static void next_move(int posx, int posy, int dimx, int dimy, String[] board) {
        int min = 99;
        int minx = 0;
        int miny = 0;

        if (board[posx].charAt(posy) == 'd') {

            System.out.println("CLEAN");
            return;
        }

        for (int i = 0; i < dimx; i++) {
            for (int j = 0; j < dimy; j++) {
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
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int[] pos = new int[2];
        int[] dim = new int[2];
        for (int i = 0; i < 2; i++) pos[i] = in .nextInt();
        for (int i = 0; i < 2; i++) dim[i] = in .nextInt();
        String board[] = new String[dim[0]];
        for (int i = 0; i < dim[0]; i++) board[i] = in .next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}