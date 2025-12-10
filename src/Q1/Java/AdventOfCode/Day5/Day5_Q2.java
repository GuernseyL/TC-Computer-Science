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
        System.out.println(list.size());
        for (String s : list) {
            for (String ss : list) {
                BigInteger one = new BigInteger(s.substring(0, s.indexOf("-")));
                BigInteger two = new BigInteger(ss.substring(0, ss.indexOf("-")));
                if (one.compareTo(two) > 0 && list.indexOf(s) < list.indexOf(ss)) {
                    String temp = list.get(list.indexOf(s));
                    list.set(list.indexOf(ss), s);
                    list.set(list.indexOf(temp), ss);
                }
                for (String sss : list) {
                    System.out.println(sss);
                }
            }
            System.out.println();
        }
        for (String s : list) {
            System.out.println(s);
        }
        int i = 0;
        String[] data = new String[list.size()];
        int a = 0;
        for (String s : list) {
            data[a] = s;
            ++a;
        }
        BigInteger bi = new BigInteger(list.getFirst().substring(0, list.getFirst().indexOf("-")));
        BigInteger bi2 = new BigInteger(list.getFirst().substring(list.getFirst().indexOf("-") + 1));
        for (String s : data) {
            removal(list, i);
        }


        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("\n\n\n\n\n\n");
        a = 0;
        for (String s : list) {
            data[a] = s;
            ++a;
        }
        for (String sss : list) {
            System.out.println(sss);
            bi = new BigInteger(sss.substring(0, sss.indexOf("-")));
            bi2 = new BigInteger(sss.substring(sss.indexOf("-") + 1));
            fresh = fresh.add(bi2.subtract(bi).add(BigInteger.ONE));
            /*while (!bi.equals(bi2)) {
                ++fresh;
                bi = bi.add(BigInteger.ONE);
                System.out.println(bi + "\t\t\t" + bi2);
            }*/
        }
        System.out.print(fresh);
    }



    public static void removal(ArrayList<String> list, int i) {
        for (String s : list) {
            if (s != null) {
                BigInteger bi = new BigInteger(s.substring(0, s.indexOf("-")));
                BigInteger bi2 = new BigInteger(s.substring(s.indexOf("-") + 1));
                for (String ss : list) {
                    if (ss != null) {
                        BigInteger bi3 = new BigInteger(ss.substring(0, ss.indexOf("-")));
                        BigInteger bi4 = new BigInteger(ss.substring(ss.indexOf("-") + 1));
                        if (s.equals(ss)) {
                            break;
                        } else if (bi.compareTo(bi3) >= 0 && bi.compareTo(bi4) <= 0) {
                            if (bi2.compareTo(bi4) >= 0) {
                                list.set(list.indexOf(s), bi3 + "-" + bi2);
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                                return;
                            } else {
                                s = ss;
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                                return;
                            }
                        } else if (bi.compareTo(bi3) < 0) {
                            if (bi2.compareTo(bi3) >= 0 && bi2.compareTo(bi4) <= 0) {
                                list.set(list.indexOf(s), bi + "-" + bi4);
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                                return;
                            } else if (bi2.compareTo(bi4) >= 0) {
                                list.remove(ss);
                                ++i;
                                System.out.println("removed \t\t\t " + i);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
