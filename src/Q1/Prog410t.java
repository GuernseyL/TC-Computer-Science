package Q1;
import java.util.*;
import java.io.*;

public class Prog410t {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/survey2.dat"));
        int[][] big = new int[3][25];
        while (file.hasNext()) {
            for (int c = 0; c < 25; ++c ) {
                for (int r = 0; r < 3; ++r ) {
                    int Add = file.nextInt();
                    big[r][c] = Add;
                }
                if (!file.hasNext()) { break; }
            }
        }
        for (int c = 0; c < 25; ++c ) {
            for (int r = 0; r < 3; ++r ) {
                System.out.print(big[r][c] + " ");
            }
            System.out.println();
        }
    }
}
