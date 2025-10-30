package Q1.Java.Langdocs.Prog285bCircular;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog285bCircularLinkedList {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/prog285b.txt"));

        Prog285bCircularHelper helper = new Prog285bCircularHelper();

        while(file.hasNext()){
            int id = file.nextInt();
            int c = file.nextInt();
            double s = file.nextDouble();
            Node markiplier = new Node(id, c, s);
            helper.addfront(markiplier);
        }

        helper.calcall();

        helper.print();

        System.out.println("\n\n");

        helper.remove0();

        helper.print();
    }
}
