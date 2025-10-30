package Q1.Java.Langdocs.Prog1061h;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lang1061h {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/prg1061h.dat"));

        Lang1061hHelper helper = new Lang1061hHelper();

        while (file.hasNextLine()) {
            String line = file.nextLine();
            char first = line.charAt(0);
            if (first == ('P')) {
                helper.Print();
                System.out.println("\n\n");
            }
            else {
                String word = line.substring(1);
                if (first == 'D') {
                    helper.remove(word);
                }
                if (first == 'A') {
                    helper.add(word);
                }
            }
        }
    }
}
