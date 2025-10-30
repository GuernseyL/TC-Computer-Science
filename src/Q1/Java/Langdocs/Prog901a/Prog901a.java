package Q1.Java.Langdocs.Prog901a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog901a {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prog512h.dat"));
        Prog901aHelper text = new Prog901aHelper();

        while (file.hasNextLine()) {
            text.addLast(file.nextLine());
        }

        text.printForward();

        System.out.println();

        text.printReverse();
    }
}
