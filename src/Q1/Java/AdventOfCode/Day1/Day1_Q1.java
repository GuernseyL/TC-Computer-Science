package Q1.Java.AdventOfCode.Day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day1_Q1 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day1-25.txt"));
        int index = 50;
        int count = 0;
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String data = line.substring(0, 1);
            int rotate = Integer.parseInt(line.substring(1));
            if (data.equals("R")) {
                index += rotate;
                while (index > 99) {
                    index -= 100;
                }
            }
            else {
                index -= rotate;
                while (index < 0) {
                    index += 100;
                }
            }
            if (index == 0) {
                ++count;
            }
        }
        System.out.println(count);
    }
}
