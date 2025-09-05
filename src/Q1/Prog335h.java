package Q1;
import java.util.Scanner;

public class Prog335h {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] List = new int[100];
        for (int x = 1; x <= 1000; ++x) {
            int delta = (int) (Math.random() * (1001 - 1)) + 1;
            List[x] = delta;
        }
        System.out.println("Enter a number to search for: ");
        int x = input.nextInt();
        int Solution = location(x, List);
    }

    public int location(int n, int[] List) {
    for (int X : List) {
        if (List[X] == n) {
            return X;
        }
    }
    return -1;
    }
}
