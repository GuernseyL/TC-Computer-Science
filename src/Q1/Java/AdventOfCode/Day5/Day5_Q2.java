package Q1.Java.AdventOfCode.Day5;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day5_Q2 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day5-25.txt"));
        BigInteger fresh = new BigInteger("0");
        ArrayList<String> list = new ArrayList<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            if (line.contains("-")) {
                list.add(line);
            }
            else {
                file.nextLine();
            }
        }
        for (String s : list) {
            for (String ss : list) {
                BigInteger one = new BigInteger(s.substring(0, s.indexOf("-")));
                BigInteger two = new BigInteger(ss.substring(0, ss.indexOf("-")));
                if (one.compareTo(two) > 0 && list.indexOf(s) < list.indexOf(ss)) {
                    String temp = list.get(list.indexOf(s));
                    list.set(list.indexOf(ss), s);
                    list.set(list.indexOf(temp), ss);
                }
            }
        }
        int i = 0;
        String[] data = new String[list.size()];
        int a = 0;
        for (String s : list) {
            data[a] = s;
            ++a;
        }

        ArrayList<String> complete = new ArrayList<>();
        complete.add(list.get(0));

        BigInteger bi = new BigInteger(list.getFirst().substring(0, list.getFirst().indexOf("-")));
        BigInteger bi2 = new BigInteger(list.getFirst().substring(list.getFirst().indexOf("-") + 1));

        for (int j = 1; j < list.size(); ++j) {
            long bi1 = Long.parseLong(list.get(j).substring(0, list.get(j).indexOf("-")));
            long bi12 = Long.parseLong(list.get(j).substring(list.get(j).indexOf("-") + 1));
            long bi3 = Long.parseLong((complete.getLast().substring(0, complete.getLast().indexOf("-"))));
            long bi4 = Long.parseLong((complete.getLast().substring(complete.getLast().indexOf("-") + 1)));
            if (bi1 > bi4) {
                complete.add(list.get(j));
            }
            else if (bi12 > bi4) {
                complete.set(complete.size() - 1, bi3 + "-" + bi2);
            }
        }

        for (String s : list) {
            System.out.println(s);
        }

        for (String sss : complete) {
            bi = new BigInteger(sss.substring(0, sss.indexOf("-")));
            bi2 = new BigInteger(sss.substring(sss.indexOf("-") + 1));
            fresh = fresh.add(bi2.subtract(bi).add(BigInteger.ONE)).abs();
            /*while (!bi.equals(bi2)) {
                ++fresh;
                bi = bi.add(BigInteger.ONE);
                System.out.println(bi + "\t\t\t" + bi2);
            }*/
        }
        System.out.print(fresh);
    }
}
