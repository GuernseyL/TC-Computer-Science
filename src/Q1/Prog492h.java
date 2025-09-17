package Q1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog492h {
    public static void main(String[] args) throws IOException {
        Scanner File = new Scanner(new File("Langdat/Prog492h.dat"));

        String[][] board = new String[30][30];
        int r = 0;

        while(File.hasNext()) {
            String line = File.nextLine();
            String[] stuff = line.split("");
            board[r] = stuff;
            ++r;
        }

        for (String[] row : board) {
            for (String index : row) {
                System.out.print(index + " ");
            }
            System.out.println();
        }

        String[][] ansBoard = new String[30][30];

        for (r = 0; r < board.length; ++r ) {
            for (int c = 0; c < board[r].length; ++c ) {
                int count = 0;
                //1
                if (r >= 1) {
                    String ch = board[r-1][c];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //2
                if ((r >= 1) && (c <= board[0].length-2)) {
                    String ch = board[r-1][c+1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //3
                if (c <= board[0].length-2) {
                    String ch = board[r][c+1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //4
                if (r <= board.length-2 && c <= board[0].length-2) {
                    String ch = board[r+1][c+1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //5
                if (r <= board.length-2) {
                    String ch = board[r+1][c];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //6
                if (r <= board.length-2 && c >= 1) {
                    String ch = board[r+1][c-1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //7
                if (c >= 1) {
                    String ch = board[r][c-1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }
                //8
                if (r >= 1 && c >= 1) {
                    String ch = board[r-1][c-1];
                    if (ch.equals("*")){
                        ++count;
                    }
                }

                if (count <= 1||count >= 4){
                    ansBoard[r][c] = ".";
                }
                if (count ==3) {
                    ansBoard[r][c] = "*";
                }
                else { ansBoard[r][c] = board[r][c]; }
            }
        }
        board = ansBoard;

        System.out.println("\n\n");
    }

    /*public static int[][] boardCheck(int[][] board) {
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[r].length; ++c) {
                if ((r >= 1) || (r >= 1 && c <= board[r].length-2) || (c <= board[r].length-2) || (r <= board.length-2 && c >= 1) || )
                }
            }
        }
        return board;
    }*/

    public static int[][] boardCheck(int r, int c, int[][] board, int indexR, int indexC, int count) {
        if (r < 0) {
            if (c < 0) {if index }
            else if (c >= board[0].length-2) { }
            else { }
        }

        boardCheck(r, c, board);
    }
}
