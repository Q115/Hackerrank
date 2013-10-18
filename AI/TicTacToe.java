/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/tic-tac-toe
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.util.*;

//need a method to check if there's a way to make double
public class TicTacToe {

    /* Complete the function below to print 2 integers separated by a single space which will be your next move */
    static void nextMove(String player, String [] board, int moveNum){
        int x =0;
        int y=0;
        int[] loc = new int[2];

        if(moveNum==1) //always put middle or diagonal
        {
            makeFirst(player, board);
            return;
        }
        else if(moveNum==2)
        {
            if(player.charAt(0)=='O')
            {
                if(board[1].charAt(1) =='X' && board[2].charAt(0) =='X'){
                    System.out.println("2 2");
                    return;
                }
                //cross is empty
                else if(board[0].charAt(1) == board[1].charAt(2) && board[1].charAt(0) == board[1].charAt(2) && board[2].charAt(1) == '_'&& board[2].charAt(1) == board[1].charAt(0))
                {
                    if(board[0].charAt(0) != '_' && board[2].charAt(2) != '_')
                    {
                        System.out.println("1 2");
                        return;
                    } else if(board[0].charAt(2) != '_' && board[2].charAt(0) != '_')
                    {
                        System.out.println("1 2");
                        return;
                    }
                }
            }
            else
            {
                if(board[1].charAt(1)!='_')
                {
                    System.out.println("2 0");
                    return;
                }else if(board[2].charAt(0)!='_')
                {
                    System.out.println("0 0");
                    return;
                }else if(board[0].charAt(0)!='_' || board[2].charAt(2)!='_')
                {
                    System.out.println("2 0");
                    return;
                }else
                {
                    System.out.println("1 1");
                    return;
                }           
            }
        }

        boolean isWinning;
        boolean hasDouble;
        if(player.charAt(0)=='X'){
            isWinning= isLosing("O",board,loc);
            hasDouble = isDouble("O", board,loc);
        }
        else{
            isWinning= isLosing("X",board,loc);
            hasDouble = isDouble("X", board,loc);
        }

        if(isWinning){ //i'm winning
            System.out.print(loc[0]+" "+loc[1]);
            return;
        }
        else if(isLosing(player,board,loc)) //i'm losing
        {
            System.out.print(loc[0]+" "+loc[1]);
            return;
        }
        else if(isDouble(player, board,loc)){ // i have double move
            System.out.print(loc[0]+" "+loc[1]);
            return;
        }
        else if(hasDouble) {// opp has double move
            System.out.print(loc[0]+" "+loc[1]);
            return;
        }

        for(int i=0;i<3;i++) // randomly pick a move
        {
            for(int j=0;j<3;j++)
            {
                if(board[i].charAt(j)=='_'){
                    System.out.print(i+" "+j);
                    return;
                }   
            }
        }
    }

    static boolean isLosing(String player, String[]board, int[]loc)
    {
        char p = player.charAt(0);
        char op;

        if(p=='X')
            op='O';
        else
            op='X';

        if(board[0].charAt(0)==op && board[0].charAt(1)==op && board[0].charAt(2)=='_'){
            loc[0]=0;
            loc[1]=2;
            return true;
        }
        else if (board[0].charAt(0)==op && board[0].charAt(1)=='_' && board[0].charAt(2)==op){
            loc[0]=0;
            loc[1]=1;
            return true;
        }
        else if (board[0].charAt(0)=='_' && board[0].charAt(1)==op && board[0].charAt(2)==op){
            loc[0]=0;
            loc[1]=0;
            return true;
        }     
        else if(board[1].charAt(0)==op && board[1].charAt(1)==op && board[1].charAt(2)=='_'){
            loc[0]=1;
            loc[1]=2;
            return true;
        }
        else if (board[1].charAt(0)==op && board[1].charAt(1)=='_' && board[1].charAt(2)==op){
            loc[0]=1;
            loc[1]=1;
            return true;
        }
        else if (board[1].charAt(0)=='_' && board[1].charAt(1)==op && board[1].charAt(2)==op){
            loc[0]=1;
            loc[1]=0;
            return true;
        }   
        else if(board[2].charAt(0)==op && board[2].charAt(1)==op && board[2].charAt(2)=='_'){
            loc[0]=2;
            loc[1]=2;
            return true;
        }
        else if (board[2].charAt(0)==op && board[2].charAt(1)=='_' && board[2].charAt(2)==op){
            loc[0]=2;
            loc[1]=1;
            return true;
        }
        else if (board[2].charAt(0)=='_' && board[2].charAt(1)==op && board[2].charAt(2)==op){
            loc[0]=2;
            loc[1]=0;
            return true;
        }    //horizontal now
        else if(board[0].charAt(0)==op && board[1].charAt(0)==op && board[2].charAt(0)=='_'){
            loc[0]=2;
            loc[1]=0;
            return true;
        }
        else if (board[0].charAt(0)==op && board[1].charAt(0)=='_' && board[2].charAt(0)==op){
            loc[0]=1;
            loc[1]=0;
            return true;
        }
        else if (board[0].charAt(0)=='_' && board[1].charAt(0)==op && board[2].charAt(0)==op){
            loc[0]=0;
            loc[1]=0;
            return true;
        }   
        else if(board[0].charAt(1)==op && board[1].charAt(1)==op && board[2].charAt(1)=='_'){
            loc[0]=2;
            loc[1]=1;
            return true;
        }
        else if (board[0].charAt(1)==op && board[1].charAt(1)=='_' && board[2].charAt(1)==op){
            loc[0]=1;
            loc[1]=1;
            return true;
        }
        else if (board[0].charAt(1)=='_' && board[1].charAt(1)==op && board[2].charAt(1)==op){
            loc[0]=0;
            loc[1]=1;
            return true;
        }   
        else if(board[0].charAt(2)==op && board[1].charAt(2)==op && board[2].charAt(2)=='_'){
            loc[0]=2;
            loc[1]=2;
            return true;
        }
        else if (board[0].charAt(2)==op && board[1].charAt(2)=='_' && board[2].charAt(2)==op){
            loc[0]=1;
            loc[1]=2;
            return true;
        }
        else if (board[0].charAt(2)=='_' && board[1].charAt(2)==op && board[2].charAt(2)==op){
            loc[0]=0;
            loc[1]=2;
            return true;
        }         
        else if(board[0].charAt(0)==op && board[1].charAt(1)==op && board[2].charAt(2)=='_'){
            loc[0]=2;
            loc[1]=2;
            return true;
        }
        else if (board[0].charAt(0)==op && board[1].charAt(1)=='_' && board[2].charAt(2)==op){
            loc[0]=1;
            loc[1]=1;
            return true;
        }
        else if (board[0].charAt(0)=='_' && board[1].charAt(1)==op && board[2].charAt(2)==op){
            loc[0]=0;
            loc[1]=0;
            return true;
        }   
        else if(board[0].charAt(2)==op && board[1].charAt(1)==op && board[2].charAt(0)=='_'){
            loc[0]=2;
            loc[1]=0;
            return true;
        }
        else if (board[0].charAt(2)==op && board[1].charAt(1)=='_' && board[2].charAt(0)==op){
            loc[0]=1;
            loc[1]=1;
            return true;
        }
        else if (board[0].charAt(2)=='_' && board[1].charAt(1)==op && board[2].charAt(0)==op){
            loc[0]=0;
            loc[1]=2;
            return true;
        }   

        return false;
    }
    public static void makeFirst(String player, String[]board) {
        if(player.charAt(0)=='O' && board[1].charAt(1)=='_'){ // put in middle
            System.out.println("1 1");
        }
        else
        {
            System.out.println("0 2");
        }

    }

    public static boolean isDouble(String player,String[]board,int[]loc) {

        if(board[0].charAt(0)=='_' && board[0].charAt(1)+board[0].charAt(2)==player.charAt(0)+95 && board[1].charAt(0)+board[2].charAt(0)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=0;
                loc[1]=0;
                return true;
            }
        
        else if(board[0].charAt(1)=='_'&& board[0].charAt(0)+board[0].charAt(2)==player.charAt(0)+95 && board[1].charAt(1)+board[2].charAt(1)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=0;
                loc[1]=1;
                return true;
            }
        
        else if(board[0].charAt(2)=='_'&& board[0].charAt(0)+board[0].charAt(1)==player.charAt(0)+95 && board[1].charAt(2)+board[2].charAt(2)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=0;
                loc[1]=2;
                return true;
            }
        
        else if(board[1].charAt(0)=='_'&&board[0].charAt(0)+board[2].charAt(0)==player.charAt(0)+95 && board[1].charAt(2)+board[1].charAt(1)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=1;
                loc[1]=0;
                return true;
            }
        
        else if(board[1].charAt(1)=='_'&&board[0].charAt(1)+board[2].charAt(1)==player.charAt(0)+95 && board[1].charAt(2)+board[1].charAt(0)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=1;
                loc[1]=1;
                return true;
            }
        
        else if(board[1].charAt(2)=='_'&&board[0].charAt(2)+board[2].charAt(2)==player.charAt(0)+95 && board[1].charAt(1)+board[1].charAt(0)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=1;
                loc[1]=2;
                return true;
            }
        
        else if(board[2].charAt(0)=='_'&&board[0].charAt(0)+board[1].charAt(0)==player.charAt(0)+95 && board[2].charAt(2)+board[2].charAt(1)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=2;
                loc[1]=0;
                return true;
            }
        
        else if(board[2].charAt(1)=='_'&&board[0].charAt(1)+board[1].charAt(1)==player.charAt(0)+95 && board[2].charAt(2)+board[2].charAt(0)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=2;
                loc[1]=1;
                return true;
            }
        
        else if(board[2].charAt(2)=='_'&&board[0].charAt(2)+board[1].charAt(2)==player.charAt(0)+95 && board[2].charAt(1)+board[2].charAt(0)==player.charAt(0)+95 ) //first line has 1 and empty
            {
                loc[0]=2;
                loc[1]=2;
                return true;
            }
        
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player;
        String board[] = new String[3];

        //If player is X, I'm the first player.
        //If player is O, I'm the second player.
        player = in.next();
        int moveNum=1;
        //Read the board now. The board is a 3x3 array filled with X, O or _.
        for(int i = 0; i < 3; i++) {
            board[i] = in.next();
        }

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)!='_')
                    moveNum++;
            }
        nextMove(player,board,(moveNum+1)/2);  

    }
}