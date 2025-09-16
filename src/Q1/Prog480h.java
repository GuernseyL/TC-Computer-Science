package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog480h {
    public static void main(String[] args) throws IOException {
        Scanner File = new Scanner(new File("Langdat/prog480h.dat"));
        int[][] Key = new int[12][24];
        System.out.print("ID     ");
        for (int i = 1; i < 11; ++i) {
            Key[i][0] = i;
            System.out.print(Key[i][0] + " ");
        }
        System.out.print("Right  Grade");
        System.out.println();
        System.out.print("       ");
        while (File.hasNextLine()) {
            if (File.nextInt() == -1) {
                for (int i = 1; i < 11; ++i) {
                    Key[i][1] = File.nextInt();
                    System.out.print(Key[i][1] + " ");
                }
            }
            System.out.println();
            for (int r = 2; r < 24; ++r) {
                for (int c = 0; c < 11; ++c) {
                    if (!File.hasNext()) { break; }
                    Key[c][r] = File.nextInt();
                    System.out.print(Key[c][r] + " ");
                    if (c == 0) { System.out.print("   "); }
                }
                System.out.println();
            }
        }
    }
}
