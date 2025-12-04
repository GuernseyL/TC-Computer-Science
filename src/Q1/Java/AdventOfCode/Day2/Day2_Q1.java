package Q1.Java.AdventOfCode.Day2;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Day2_Q1 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Day2-25.txt"));
        String[] data = file.nextLine().split(",");
        BigInteger Invalidsum = new BigInteger("0");
        boolean truth = true;
        for (String s : data) {
            int index = s.indexOf("-");
            BigInteger first = new BigInteger(s.substring(0, index));
            BigInteger second = new BigInteger(s.substring(index + 1));
            for (BigInteger lcvA = first; !(lcvA.compareTo(second) > 0); lcvA = lcvA.add(BigInteger.ONE)) {
                int length = Math.ceilDiv(lcvA.toString().length(), 2);
                for (int lcvB = 1; lcvB <= length; ++lcvB) {
                    BigInteger same = new BigInteger(lcvA.toString().substring(0, lcvB));
                    for (int lcvC = lcvB; lcvC+same.toString().length() < lcvA.toString().length(); ++lcvC) {
                        if (!same.equals(new BigInteger(lcvA.toString().substring(lcvC, lcvC + same.toString().length())))) {
                            System.out.println("Second: " + lcvA.toString().substring(lcvC, lcvC + same.toString().length()));
                            System.out.println("First: " + lcvA.toString().substring(0, lcvB));
                            //System.out.println("Length of same: " + lcvB);
                            //System.out.println("Length of copy: " + (lcvC));
                            //System.out.println("Length of half of lcvA: " + length);
                            truth = false;
                        }
                    }
                }
                if (truth) {
                    System.out.println(lcvA);
                    Invalidsum = Invalidsum.add(lcvA);
                }
            }
        }
        System.out.println(Invalidsum);
    }
}
