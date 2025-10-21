package Q1.Day16;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day16a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day16.txt"));
        ArrayList<int[]> data = new ArrayList<>
        int len = 15;
        String[][] map = new String[len][len];
        int count = 0;

        while (file.hasNextLine()) {
            String[] line = file.nextLine().split("");
            map[count] = line;
            count++;
        }

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

        int ans = Integer.MAX_VALUE;

        int stsrow = 0;
        int stscol = 0;

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if(map[r][c].equals("S"))
                {
                    stsrow = r;
                    stscol = c;
                }
            }
        }
        System.out.println(stsrow + " " + stscol);
        int answer = maze(stsrow,stscol,1,0, map);


    }

    public static int maze(int r, int c, int d, int sc, String[][] map) {
        if (map[r][c].equals("E")) {
            return sc;
        }
        if (map[r][c + 1].equals("#") && map[r - 1][c].equals("#") && map[r][c - 1].equals("#") && map[r + 1][c].equals("#")) {
            map[r][c] = "#";
            return Integer.MAX_VALUE;
        }
        if (map[r][c + 1].equals(".")) {
            map[r][c] = "#";
            if (d == 1) { return maze(r, c + 1, 1, sc + 1, map); }
            else if (d == 2) { return maze(r, c + 1, 1, sc + 1000, map); }
            else if (d == 4) { return maze(r, c + 1, 1, sc + 1000, map); }
        }
        if (map[r - 1][c].equals(".")) {
            map[r][c] = "#";
            if (d == 1) { return maze(r, c + 1, 1, sc + 1000, map); }
            else if (d == 2) { return maze(r, c + 1, 1, sc + 1, map); }
            else if (d == 3) { return maze(r, c + 1, 1, sc + 1000, map); }
        }
        if (map[r][c - 1].equals(".")) {
            map[r][c] = "#";
            if (d == 2) { return maze(r, c + 1, 1, sc + 1000, map); }
            else if (d == 3) { return maze(r, c + 1, 1, sc + 1, map); }
            else if (d == 4) { return maze(r, c + 1, 1, sc + 1000, map); }
        }
        if (map[r - 1][c].equals(".")) {
            map[r][c] = "#";
            if (d == 1) { return maze(r, c + 1, 1, sc + 1000, map); }
            else if (d == 3) { return maze(r, c + 1, 1, sc + 1000, map); }
            else if (d == 4) { return maze(r, c + 1, 1, sc + 1, map); }
        }
        return 0;
    }
}
