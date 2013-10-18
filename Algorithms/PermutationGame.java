/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/permutation-game
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class PermutationGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System. in );
        int T = in .nextInt();

        for (int j = 0; j < T; j++) {
            int N = in .nextInt();
            ArrayList < Integer > array = new ArrayList < Integer > ();
            Hashtable < String, Boolean > t = new Hashtable < String, Boolean > ();

            for (int i = 0; i < N; i++)
                array.add( in .nextInt());

            if (isIncreasing(array))
                System.out.println("Alice");
            else {
                if (whoWins(array, true, t))
                    System.out.println("Bob");
                else if (isDecreasing(array)) {
                    if (N % 2 == 0)
                        System.out.println("Alice");
                    else
                        System.out.println("Bob");
                } else
                    System.out.println("Alice");
            }
        }

    }
    //0 is al, 1 is bob
    public static boolean whoWins(ArrayList < Integer > array, boolean player, Hashtable < String, Boolean > t) {
        int size = array.size();
        StringBuffer s = new StringBuffer();
        String o;
        for (int i = 0; i < size; i++) {
            s.append(array.get(i).toString() + '_');
        }
        o = s.toString();
        if (t.containsKey(o)) {
            return t.get(o);
        }

        if (isIncreasing(array)) {
            t.put(o, player);
            return player;
        }
        if (isDecreasing(array)) {
            if (size % 2 == 0) {
                t.put(o, !player);
                return !player;
            } else {
                t.put(o, player);
                return player;
            }
        }
        player = !player;
        for (int i = 0; i < size; i++) {
            int num = array.get(i);
            array.remove(i);
            if (whoWins(array, player, t) == player) {
                array.add(i, num);
                t.put(o, player);
                return player;
            }
            array.add(i, num);
        }
        t.put(o, !player);
        return !player;

    }
    public static boolean isDecreasing(ArrayList < Integer > array) {
        int size = array.size();
        for (int i = 0; i < size - 1; i++) {
            if (array.get(i) < array.get(i + 1))
                return false;
        }
        return true;
    }
    public static boolean isIncreasing(ArrayList < Integer > array) {
        int size = array.size();
        for (int i = 0; i < size - 1; i++) {
            if (array.get(i) > array.get(i + 1))
                return false;
        }
        return true;
    }
}