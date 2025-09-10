package Q1;
import java.util.*;
import java.io.*;

public class Prog404a {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdat/prg404a1.dat"));
        for (int x = 0; x < 2; ++x) {
            ArrayList<Integer> List = new ArrayList<Integer>();
            int PosVal = 0;
            int NegVal = 1;
            while (input.hasNext()) {
                int A = input.nextInt();
                if (A > 0) {
                    List.add(0);
                    List.add(0);
                    List.set(PosVal, A);
                    PosVal += 2;
                }
                else if (A < 0) {
                    List.add(0);
                    List.add(0);
                    List.set(NegVal, A);
                    NegVal += 2;
                }
            }

            System.out.println("Postive    Negative\nNumbers    Numbers");

            for (int lcv = 0; lcv < List.size(); ++lcv) {
                if (List.get(lcv) == 0 && List.get(lcv + 1) == 0) { System.out.println("\n"); break; }
                else if (List.get(lcv) == 0)                           { System.out.print("            "); }
                else                                              { System.out.print("  " + List.get(lcv) + "         "); }
                if (lcv % 2 == 1)                                 { System.out.print("\n"); }
            }
            input = new Scanner(new File("Langdat/prg404a2.dat"));
        }
    }
}

/*
Postive    Negative
Numbers    Numbers
  3           -8
  66           -16
  54           -56
  22           -34
  19           -22
  21           -55
  34           -3
  64           -55
  55           -76
  9           -45
  39
  54
  33

Postive    Negative
Numbers    Numbers
  8           -3
  10           -66
  56           -54
  34           -22
  22           -19
  55           -21
  3           -34
  55           -64
  76           -55
  45           -9
              -89
              -54
              -33



 */