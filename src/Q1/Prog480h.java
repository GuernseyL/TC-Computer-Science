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
        System.out.print("ID:\t\t\t");
        for (int i = 1; i < 11; ++i) {
            Key[i][0] = i;
            System.out.print(Key[i][0] + "\t");
        }
        System.out.println("Correct:\tGrade:");
        System.out.print("Key:\t\t");
        while  (File.hasNextLine()) {
            if (File.nextInt() == -1) {
                for (int i = 1; i < 11; ++i) {
                    Key[i][1] = File.nextInt();
                    System.out.print(Key[i][1] + "\t");
                }
            }
            System.out.println();
            for        (int r = 2; r < Key[0].length-2; ++r) {
                for    (int c = 0; c < Key.length-1; ++c) {
                    if (!File.hasNext()) { break; }
                    Key[c][r] = File.nextInt();
                    System.out.print(Key[c][r] + "\t");
                    if (c == 0) { System.out.print("\t\t"); }
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
                        System.out.print("\t" + Key[Key.length - 1][r] + "\t");
                        if (Key[Key.length - 1][r] >= 9) {
                            System.out.print("\tA");
                        } else if (Key[Key.length - 1][r] >= 7) {
                            System.out.print("\tC");
                        } else if (Key[Key.length - 1][r] < 7) {
                            System.out.print("\tF");
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
            System.out.print("Correct:\t");
            for (int r = 1; r < Key.length-1; ++r) {
                int correct = 0;
                int Wrong = 0;
                for (int c = 2; c < lastindex; ++c) {
                    if (Key[r][c] == Key[r][1]) { ++correct; }
                    else { ++Wrong; }
                }
                Key[r][lastindex] = correct;
                Key[r][lastindex+1] = Wrong;
                System.out.print(Key[r][lastindex] + "\t");
            }
            System.out.println();
            System.out.print("Wrong:\t\t");
            for (int r = 1; r < Key.length-1; ++r) {
                System.out.print(Key[r][lastindex+1] + "\t");
            }
        }
    }
}

/*
ID:			1	2	3	4	5	6	7	8	9	10	Correct:	Grade:
Key:		0	1	0	0	1	0	0	1	0	1
180			0	1	1	0	1	0	1	1	0	1		8		C
340			0	1	0	1	0	1	1	1	0	0		5		F
341			0	1	1	0	1	1	1	1	1	1		6		F
401			1	1	0	0	1	0	0	1	1	1		8		C
462			1	1	0	1	1	1	0	0	1	0		4		F
463			1	1	1	1	1	1	1	1	1	1		4		F
464			0	1	0	0	1	0	0	1	0	1		10		A
512			1	0	1	0	1	0	1	0	1	0		3		F
618			1	1	1	0	0	1	1	0	1	0		2		F
619			0	0	0	0	0	0	0	0	0	0		6		F
687			1	0	1	1	0	1	1	0	1	0		0		F
700			0	1	0	0	1	1	0	0	0	1		8		C
712			0	1	0	1	0	1	0	1	0	1		7		C
837			1	0	1	0	1	1	0	1	0	1		6		F
Correct:	7	10	7	9	9	5	7	8	7	8
Wrong:		7	4	7	5	5	9	7	6	7	6
 */
