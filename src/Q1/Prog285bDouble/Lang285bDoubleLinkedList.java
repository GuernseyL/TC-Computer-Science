package Q1.Prog285bDouble;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lang285bDoubleLinkedList {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/prog285b.txt"));

        Lang285bDoubleHelper helper = new Lang285bDoubleHelper();

        while(file.hasNext()){
            int id = file.nextInt();
            int c = file.nextInt();
            double s = file.nextDouble();
            doubleNode markiplier = new doubleNode(id, c, s);
            helper.addfront(markiplier);
        }

        helper.calcall();

        helper.print();

        System.out.println("\n\n");

        helper.remove0();

        helper.print();
    }
}
