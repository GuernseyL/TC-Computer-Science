package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog480h {
    public static void main(String[] args) throws IOException {
        Scanner File = new Scanner(new File("Langdat/prog480h.dat"));
        int[][] Key = new int[12][24];
        for     (int i = 0; i < 12; i++) {
            for (int j = 0; j < 24; j++) {
                Key[i][j] = -1;
            }
        }
        System.out.print("ID     ");
        for (int i = 1; i < 11; ++i) {
            Key[i][0] = i;
            System.out.print(Key[i][0] + " ");
        }
        System.out.println("Correct:  Grade:");
        System.out.print("Key:   ");
        while  (File.hasNextLine()) {
            if (File.nextInt() == -1) {
                for (int i = 1; i < 11; ++i) {
                    Key[i][1] = File.nextInt();
                    System.out.print(Key[i][1] + " ");
                }
            }
            System.out.println();
            for        (int r = 2; r < Key[0].length-2; ++r) {
                for    (int c = 0; c < Key.length-1; ++c) {
                    if (!File.hasNext()) { break; }
                    Key[c][r] = File.nextInt();
                    System.out.print(Key[c][r] + " ");
                    if (c == 0) { System.out.print("   "); }
                }
                if (Key[0][r] >= 100) {
                    Key[Key.length - 1][r] = 0;
                    int correct = 0;
                    for (int c = 1; c <= Key.length - 1; ++c) {
                        if (Key[c][r] == Key[c][1] && Key[c][r] > -1) {
                            ++correct;
                            Key[Key.length - 1][r] = correct;
                        }
                    }
                    if (Key[Key.length - 1][r] > -1) {
                        System.out.print("   " + Key[Key.length - 1][r] + "         ");
                        if (Key[Key.length - 1][r] >= 9) {
                            System.out.print("A");
                        } else if (Key[Key.length - 1][r] >= 7) {
                            System.out.print("C");
                        } else if (Key[Key.length - 1][r] < 7) {
                            System.out.print("F");
                        }
                    }
                    System.out.println();
                }
            }
            int lastindex = 0;
            for (int i = 0; i < 24; ++i) {
                if (Key[1][i] != -1) {
                    ++lastindex;
                }
                if (Key[1][i] == -1) {
                    break;
                }
            }
            System.out.print("Correct: ");
            for (int r = 1; r < Key.length-1; ++r) {
                int correct = 0;
                int Wrong = 0;
                for (int c = 2; c < lastindex; ++c) {
                    if (Key[r][c] == Key[r][1]) { ++correct; }
                    else { ++Wrong; }
                }
                Key[r][lastindex] = correct;
                Key[r][lastindex+1] = Wrong;
                System.out.print(Key[r][lastindex] + " ");
            }
            System.out.println();
            System.out.print("Wrong: ");
            for (int r = 1; r < Key.length-1; ++r) {
                System.out.print(Key[r][lastindex+1] + " ");
            }
        }
    }
}
