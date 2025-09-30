package Q1.AdventsOfCode.Day22;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Day22 {
    public static void main(String[] args) throws IOException {

        Scanner File = new Scanner(new File("Langdat/Day22.txt"));
        BigInteger ans = new BigInteger("" + 0);
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (File.hasNext()) {
            list.add(File.nextInt());
        }

        for (int i = 0; i < list.size(); ++i) {
            BigInteger secret = new BigInteger("" + list.get(i));
            for (int lcv=0; lcv<2000; lcv++) {
                BigInteger temp = secret.multiply(new BigInteger("" + 64));
                secret = temp.xor(secret);
                secret = secret.mod(new BigInteger("" + 16777216));

                BigInteger temp2 = secret.divide(new BigInteger("" + 32));
                secret = temp2.xor(secret);
                secret = secret.mod(new BigInteger("" + 16777216));

                BigInteger temp3 = secret.multiply(new BigInteger("" + 2048));
                secret = temp3.xor(secret);
                secret = secret.mod(new BigInteger("" + 16777216));

            }
            System.out.println(secret);
            ans = ans.add(secret);
        }
        System.out.println(ans);
    }
}
