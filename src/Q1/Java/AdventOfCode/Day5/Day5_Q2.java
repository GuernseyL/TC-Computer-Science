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
        int fresh = 0;
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
        int i = 0;
        String[] data = new String[list.size()];
        int a = 0;
        for (String s : list) {
            data[a] = s;
        }
        BigInteger bi = new BigInteger(list.getFirst().substring(0, list.getFirst().indexOf("-")));
        BigInteger bi2 = new BigInteger(list.getFirst().substring(list.getFirst().indexOf("-") + 1));
        for (String s : data) {
            if (s != null) {
                bi = new BigInteger(s.substring(0, s.indexOf("-")));
                bi2 = new BigInteger(s.substring(s.indexOf("-") + 1));
                for (String ss : data) {
                    if (ss != null) {
                        BigInteger bi3 = new BigInteger(ss.substring(0, ss.indexOf("-")));
                        BigInteger bi4 = new BigInteger(ss.substring(ss.indexOf("-") + 1));
                        if (s.equals(ss)) {
                            break;
                        } else if (bi.compareTo(bi3) >= 0 && bi.compareTo(bi4) <= 0) {
                            if (bi2.compareTo(bi4) >= 0) {
                                s = bi3.toString() + bi2.toString();
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                            } else {
                                s = ss;
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                            }
                        } else if (bi.compareTo(bi3) < 0) {
                            if (bi2.compareTo(bi3) >= 0 && bi2.compareTo(bi4) <= 0) {
                                s = bi.toString() + bi4.toString();
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                            } else if (bi2.compareTo(bi4) >= 0) {
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                            }
                        }
                    }
                }
            }
        }
        for (String sss : list) {
            bi = new BigInteger(sss.substring(0, sss.indexOf("-")));
            bi2 = new BigInteger(sss.substring(sss.indexOf("-") + 1));
            while (!bi.equals(bi2)) {
                ++fresh;
                bi = bi.add(BigInteger.ONE);
                System.out.println(bi + "\t\t\t" + bi2);
            }
            ++fresh;
        }
        System.out.print(fresh);
    }
}
