package Q1.Java.MSOE;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HowLongUntilWeMeet {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/HowLongUntilWeMeet.txt"));
        int Distance = file.nextInt();
        System.out.println(Distance);
        int rows = file.nextInt();
        System.out.println(rows);
        int cols = file.nextInt();
        System.out.println(cols);
        String[][] matrixA = new String[rows][cols];
        String[][] matrixB = new String[rows][cols];
        for (int i = 0; i < rows; ++i) {
            String line = file.nextLine();
            if (!line.isBlank()) {
                matrixA[i] = line.split("");
            }
            else { --i; }
        }
        for (int i = 0; i < rows; ++i) {
            String line = file.nextLine();
            if (!line.isEmpty()) {
                matrixB[i] = line.split("");
            }
            else { --i; }
        }

        for (int x = 0; x < rows; x++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixA[x][j] + " ");
            }
            System.out.println();
        }

        for (int x = 0; x < rows; x++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixB[x][j] + " ");
            }
            System.out.println();
        }

        Map<String, Integer> map = new HashMap<>();
        for (int x = 0; x <= 25; x++) {
            char character = (char)(97+x);
            map.put(String.valueOf(character), x);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrixA[row][col] = map.get(matrixA[row][col]).toString();
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrixB[row][col] = map.get(matrixB[row][col]).toString();
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrixA[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrixB[row][col] + " ");
            }
            System.out.println();
        }
    }
}
