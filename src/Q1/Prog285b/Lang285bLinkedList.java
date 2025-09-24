package Q1.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Lang285bLinkedList {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("langdat/prog285b.txt"));

        Land285bHelper list = new Land285bHelper();

        while (input.hasNext()) {
            list.addBack(new Node(new Com(input.nextInt(), input.nextInt(), input.nextDouble())));
        }
        list.print();
    }
}
