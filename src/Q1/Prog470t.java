package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog470t {
    public static void main(String[] args) throws IOException {
        Scanner File = new Scanner(new File("Langdat/prg470t1.dat"));
        for (int x = 0; x < 2; ++x) {
        int[][] magic = new int[5][5];
        while (File.hasNextLine()) {
            for (int r = 0; r < 4; ++r) {
                for (int c = 0; c < 4; ++c) {
                    magic[r][c] = File.nextInt();
                }
            }
        }

        for (int r = 0; r < 4; ++r) {
            int RowTotal = 0;
            for (int c = 0; c < 4; ++c) {
                RowTotal += magic[r][c];
            }
            if (RowTotal == 34) { magic[r][4] = RowTotal; }
        }
        for (int r = 0; r < 4; ++r) {
            int ColTotal = 0;
            for (int c = 0; c < 4; ++c) {
                ColTotal += magic[c][r];
            }
            if (ColTotal == 34) { magic[4][r] = ColTotal; }
        }

        int Main = 0;
        int Other = 0;
        for (int d = 0; d < 4; ++d) {
            Main += magic[d][d];
        }

        int iC = 3;
        for (int r = 0; r < 4; ++r) {
            Other += magic[r][iC];
            --iC;
        }

        for (int r = 0; r < magic.length; ++r) {
            for (int c = 0; c < magic[0].length; ++c) {
                if (r == 4  && magic [r][c] == 0 || c == 4 && magic[r][c] == 0) { continue; }
                System.out.print(magic[r][c] + "   ");
            }
            System.out.println();
        }

        boolean MagicCorrect = true;

        if (Main == 34) { System.out.println("\nMain Diagonal: 34"); }
        else { MagicCorrect = false; }
        if (Other == 34) { System.out.println("Other Diagonal: 34"); }
        else { MagicCorrect = false; }

        for (int r = 0; r < 4; ++r) {
            if (magic[r][4] != 34) { MagicCorrect = false; }
        }
        for (int c = 0; c < 4; ++c) {
            if (magic[c][4] != 34) { MagicCorrect = false; }
        }

        if (MagicCorrect) { System.out.println("\nThe Above Configuration is a perfect square\n"); }
        else { System.out.println("\nThe Above Configuration does not form a perfect square\n"); }
        File = new Scanner(new File("langdat/prg470t2.dat"));
        }
    }
}

/*
16   3   2   13   34
5   10   11   8   34
9   6   7   12   34
4   15   14   1   34
34   34   34   34

Main Diagonal: 34
Other Diagonal: 34

The Above Configuration is a perfect square

16   3   2   13   34
5   10   8   11   34
9   6   7   12   34
4   15   14   1   34
34   34

Main Diagonal: 34

The Above Configuration does not form a perfect square


 */
