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
                file.close();
            }
            }
            for (String s : list) {
                BigInteger bi = new BigInteger(s.substring(0, s.indexOf("-")));
                BigInteger bi2 = new BigInteger(s.substring(s.indexOf("-") + 1));
                for (String ss : list) {
                    BigInteger bi3 = new BigInteger(ss.substring(0, ss.indexOf("-")));
                    BigInteger bi4 = new BigInteger(ss.substring(ss.indexOf("-") + 1));
                    if (s.equals(ss)) {
                        break;
                    }
                    else if (bi.compareTo(bi3) >= 0 && bi.compareTo(bi4) <= 0) {
                        if (bi2.compareTo(bi4) >= 0) {
                            s = bi3.toString() + bi2.toString();
                            list.remove(ss);
                        }
                        else {
                            s = ss;
                            list.remove(ss);
                        }
                    } else if (bi.compareTo(bi3) < 0) {
                        if (bi2.compareTo(bi3) >= 0 && bi2.compareTo(bi4) <= 0) {
                            s = bi.toString() + bi4.toString();
                            list.remove(ss);
                        }
                        else if (bi2.compareTo(bi4) >= 0) {
                            list.remove(ss);
                        }
                    }
                }
            }
            for (String sss : list) {
                BigInteger bi = new BigInteger(sss.substring(0, sss.indexOf("-")));
                BigInteger bi2 = new BigInteger(sss.substring(sss.indexOf("-") + 1));
                while (!bi.equals(bi2)) {
                    ++fresh;
                    bi = bi.add(BigInteger.ONE);
                }
                ++fresh;
            }
            System.out.print(fresh);
    }
}
