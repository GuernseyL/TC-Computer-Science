package Q1;
import java.util.*;
import java.io.*;

public class Prog404a {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdat/prg404a1.dat"));
        while (input.hasNext()) {
            int A = input.nextInt();
            if (A > 0) {
                System.out.print(A + " ");
            }
            else {
                System.out.print("  " + A);
            }
            int B = input.nextInt();
            if (B < 0) {
                System.out.print(B + "\n");
            }
            else {
                System.out.print(" \n" + B);
            }
        }
    }

   /* public static void FileSearch(String File) {
        Scanner input = new Scanner(new File(File));
        while (input.hasNext()) {
            if (input.nextInt() > 0) {
                System.out.print(input.next() + " ");
            }
            else {
                System.out.print("  " + input.next());
            }
            if (input.nextInt() < 0) {
                System.out.print(input.next() + "\n");
            }
            else {
                System.out.print(" \n");
            }
        }
    }*/
}
