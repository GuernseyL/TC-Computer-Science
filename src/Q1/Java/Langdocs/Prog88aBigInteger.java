package Q1.Java.Langdocs;
import java.math.BigInteger;
import java.util.Scanner;
import java.math.BigDecimal;

public class Prog88aBigInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        BigInteger first = input.nextBigInteger();
        System.out.print("Enter the second number: ");
        BigInteger second = input.nextBigInteger();

        System.out.println("Sum: " + first.add(second));
        System.out.println("Difference: " + first.subtract(second));
        System.out.println("Product: " + first.multiply(second));
        System.out.println("Average: " + BigDecimal.valueOf((((first.add(second)).doubleValue()/(BigInteger.valueOf(2)).doubleValue()))));
        System.out.println("Absolute Value: " + first.subtract(second).abs());
        System.out.println("Maximum: " + first.max(second));
        System.out.println("Minimum: " + first.min(second));
    }
}
/*
Enter the first number: 7933
Enter the second number: 2398
Sum: 10331
Difference: 5535
Product: 19023334
Average: 5165.5
Absolute Value: 5535
Maximum: 7933
Minimum: 2398
 */