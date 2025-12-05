package Q1.Java.AdventOfCode.Day5;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day5_Q1 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day5-25.txt"));
        int fresh = 0;
        ArrayList<String> list = new ArrayList<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.contains("-")) {
                list.add(line);
            }
            else {
                Boolean truth = true;
                for (String s : list) {
                    if (new BigInteger(line).compareTo(new BigInteger(s.substring(0, s.indexOf("-")))) > 0 && new BigInteger(line).compareTo(new BigInteger(s.substring(s.indexOf("-") + 1))) < 0 && (truth)) {
                        ++fresh;
                        truth = false;
                    }
                }
            }
        }
        System.out.print(fresh);
    }
}
