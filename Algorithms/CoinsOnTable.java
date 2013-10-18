/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/coin-on-the-table
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.Scanner;

public class CoinsOnTable {
    public static void main(String[] args) {
        //works, but too slow
        Scanner in = new Scanner(System. in );

        int N, M, K;
        N = in .nextInt();
        M = in .nextInt();
        K = in .nextInt();

        char[][] grid = new char[N][M]; in .nextLine();
        for (int i = 0; i < N; i++) {
            String temp = in .nextLine();
            grid[i] = temp.toCharArray();
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '*') {
                    x = i;
                    y = j;
                }
            }
        int[][] table = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                table[i][j] = -1;
        table[x][y] = 0;
        if (!isValid(K, x, y))
            System.out.println(-1);
        else {
            findSmallest(grid, x, y, K, table, 0);
            System.out.println(table[0][0]);
        }
    }

    public static void findSmallest(char[][] grid, int finalx, int finaly, int move, int table[][], int score) {
        if (table[0][0] == 0) {
            System.out.println(0);
            System.exit(0);
        }
        int valid = finalx + (finaly);
        if ((finalx == finaly) && finaly == 0)
            return;
        if (valid > move) {
            table[finalx][finaly] = -1;
            return;
        }
        if (table[0][0] != -1 && score >= table[0][0])
            return;
        if (move == 0)
            return;
        if (score > table[finalx][finaly] && table[finalx][finaly] != -1)
            return;

        if (finaly - 1 >= 0) {
            if (grid[finalx][finaly - 1] == 'R') {
                if (table[finalx][finaly - 1] > score || table[finalx][finaly - 1] == -1) {
                    table[finalx][finaly - 1] = score;
                    findSmallest(grid, finalx, finaly - 1, move - 1, table, score);
                }

            } else {
                if (table[finalx][finaly - 1] > score + 1 || table[finalx][finaly - 1] == -1) {
                    table[finalx][finaly - 1] = score + 1;
                    findSmallest(grid, finalx, finaly - 1, move - 1, table, score + 1);
                }
            }
        }

        if (finaly + 1 < grid[0].length) {
            if (grid[finalx][finaly + 1] == 'L') {
                if (table[finalx][finaly + 1] > score || table[finalx][finaly + 1] == -1) {
                    table[finalx][finaly + 1] = score;
                    findSmallest(grid, finalx, finaly + 1, move - 1, table, score);
                }
            } else {
                if (table[finalx][finaly + 1] > 1 + score || table[finalx][finaly + 1] == -1) {
                    table[finalx][finaly + 1] = score + 1;
                    findSmallest(grid, finalx, finaly + 1, move - 1, table, score + 1);
                }
            }
        }

        if (finalx - 1 >= 0) {
            if (grid[finalx - 1][finaly] == 'D') {
                if (table[finalx - 1][finaly] > score || table[finalx - 1][finaly] == -1) {
                    table[finalx - 1][finaly] = score;
                    findSmallest(grid, finalx - 1, finaly, move - 1, table, score);
                }
            } else {
                if (table[finalx - 1][finaly] > score + 1 || table[finalx - 1][finaly] == -1) {
                    table[finalx - 1][finaly] = score + 1;
                    findSmallest(grid, finalx - 1, finaly, move - 1, table, score + 1);
                }
            }
        }
        if (finalx + 1 < grid.length) {
            if (grid[finalx + 1][finaly] == 'U') {
                if (table[finalx + 1][finaly] > score || table[finalx + 1][finaly] == -1) {
                    table[finalx + 1][finaly] = score;
                    findSmallest(grid, finalx + 1, finaly, move - 1, table, score);
                }
            } else {
                if (table[finalx + 1][finaly] > 1 + score || table[finalx + 1][finaly] == -1) {
                    table[finalx + 1][finaly] = score + 1;
                    findSmallest(grid, finalx + 1, finaly, move - 1, table, score + 1);
                }
            }
        }
    }

    public static boolean isValid(int move, int finalx, int finaly) {
        if (Math.abs(finalx) + Math.abs(finaly) > move)
            return false;
        else
            return true;
    }
}