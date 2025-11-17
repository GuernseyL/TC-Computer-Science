package Q1.Java.MSOE;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class HappyAlphabeticalAnts {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/HappyAlphabeticalAnts.txt"));
        String line = file.nextLine();
        String line2 = line;
        String[] data = line.toLowerCase().split(" ");
        line = "";
        for (int i = 0; i < data.length; i++){
            line += data[i];
        }
        data = line.split(",");
        line = "";
        for (int i = 0; i < data.length; i++){
            line += data[i];
        }
        System.out.println(line);

        String Long = "";
        for (int i = 0; i < line.length(); i++){
            if
        }
    }
}
