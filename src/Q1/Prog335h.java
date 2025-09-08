package Q1;
import java.util.*;
import java.io.*;

public class Prog335h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/Prog127a.dat"));
        System.out.println("P Q Value");
        while (file.hasNext) {
            int P = file.nextInt();
            int Q = file.nextInt();
            int V = diceroll(Q, P);
            System.out.println(P + " " + Q + " " + V);
        }


    }
    public static int diceroll(int P, int Q) {
        if (P != Q) {
            if (P % 2 == 0 && Q % 2 != 0) {
                return (2 * P) + Q;
            }
            else if (P % 2 != 0 && Q % 2 == 0) {
                return P + (2 * Q);
            }
            else { return P + Q; }
        }
        if (P % 2 == 0) { return 3 * P; }
        return 3 * Q;
    }
}


