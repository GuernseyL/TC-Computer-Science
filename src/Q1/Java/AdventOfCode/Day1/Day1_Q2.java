package Q1.Java.AdventOfCode.Day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1_Q2 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day1-25.txt"));
        int index = 50;
        int count = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String data = line.substring(0, 1);
            int rotate = Integer.parseInt(line.substring(1));
            if (data.equals("R")) {
                for (int lcv = rotate; lcv > 0; --lcv) {
                    index++;
                    if (index == 100) {
                        index = 0;
                        ++count;
                    }
                }
            }
            else {
                for (int lcv = rotate; lcv > 0; --lcv) {
                    index--;
                    if (index == 0) {
                        ++count;
                    }
                    if (index == -1) {
                        index = 99;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
