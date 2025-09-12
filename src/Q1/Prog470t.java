package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog470t {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/prg470t1.dat"));
        int[][] magic = new int[4][4];
        while (file.hasNextLine()) {
            for (int r = 0; r < magic.length; ++r) {
                for (int c = 0; c < magic[r].length; ++c) {
                    magic[r][c] = file.nextInt();
                }
            }
        }

        for (int r = 0; r < magic.length; ++r) {
            int RowTotal = 0;
            for (int c = 0; c < magic[r].length; ++c) {
                RowTotal += magic[r][c];
            }
            System.out.println(RowTotal);
        }
        for (int r = 0; r < magic.length; ++r) {
            int ColTotal = 0;
            for (int c = 0; c < magic[r].length; ++c) {
                ColTotal += magic[r][c];
            }
            System.out.println(ColTotal);
        }

        for (int r = 0; r < magic.length; ++r) {
            for (int c = 0; c < magic[r].length; ++c) {
                System.out.print(magic[r][c] + " ");
            }
            System.out.println();
        }
    }
}
