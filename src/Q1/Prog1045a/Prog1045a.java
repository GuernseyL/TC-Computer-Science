package Q1.Prog1045a;

import java.io.IOException;
import java.util.Scanner;

public class Prog1045a {
    public static void main(String[] args) throws IOException {
        Scanner data = new Scanner(System.in);
        int people = 0;
        while (people != -1) {
            Prog1045aHelper employees = new Prog1045aHelper();
            System.out.print("Enter number of people laid off: ");
            people = data.nextInt();
            for (int i = 1; i <= people; i++) {
                employees.addFront(i);
            }
            System.out.println("When releasing " + people + " employees, you need to be in position : " + employees.lastSpot() + "\n");
        }
    }
}
