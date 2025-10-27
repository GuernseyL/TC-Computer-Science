package Q1.BigCircularLinkedList;

import java.io.IOException;
import java.util.Iterator;

public class BCLL {
    public static void main(String[] args) throws IOException {

        BCLLHelper list = new BCLLHelper();
        for (int i = 0; i < 100; ++i) {
            list.addFront((int) (Math.random() * (101)));
            list.addLast((int) (Math.random() * (101)));
        }
        list.print();

        System.out.println("\n");

        System.out.print(list.getCount());

        System.out.println("\n");

        list.add((int) (Math.random() * (101)), (int) (Math.random() * (201-1)) +1);

        if (list.isEmpty()) { System.out.println("List is empty"); }
        else { System.out.println("List is not empty"); }

        list.print();

        System.out.println("\n");

        int num = (int) (Math.random() * (201-1)) +1;
        if (list.isThere(num)) { System.out.println(num + "is there"); }

        System.out.println("First : " + list.getFirst());

        System.out.println("\n");

        System.out.println("Last : " + list.getLast());

        System.out.println("\n");

        num = (int) (Math.random() * (101));

        System.out.println("Number at spot " + num + " is : " + list.getSpot(num));

        list.removeFirst();

        list.removeLast();

        System.out.println("\n");

        list.print();

        System.out.println("\n");

        System.out.print("Numbers less than 10 : " + list.countLess10());

        System.out.println("\n");

        list.removeSpot((int) (Math.random() * (101)));

        num = (int) (Math.random() * (201-1)) +1;

        if (list.checkForNum(num)) { System.out.println("List does contain : " + num); }
        else { System.out.println("List does not contain : " + num); }

        num = (int) (Math.random() * (101));

        System.out.println(list.getNum(num));

        System.out.println("\n");

        list.getReverse().print();

        System.out.println("\n");

        Iterator<Integer> things = list.iterator();
        while (things.hasNext()) {
            Integer cool = things.next();
            System.out.println(cool);
        }

        System.out.println("\n");

        System.out.println("Average of all numbers in list : " + list.avg());

        System.out.println("\n");

        System.out.println("Smallest number in list : " + list.getMin());

        System.out.println("\n");

        System.out.println("Largest number in list : " + list.getMax());

        System.out.println("\n");

        System.out.println("Slot of first Largest number in list : " + list.findSlotMaxFirst());

        System.out.println("\n");

        System.out.println("Slot of last Largest number in list : " + list.findSlotMaxLast());

        System.out.println("\n");

        list = list.sort();

        list.print();

        System.out.println("\n");

        System.out.println("Number of 58's deleted : " + list.lose58());

        list.print();

        System.out.println("\n");

        System.out.println("Number of even numbers in list : " + list.getEvenCount());

        System.out.println("\n");

        list.killOdds();

        list.print();

        System.out.println("\n");

        list.clear();

        System.out.println("List has been cleared");

        System.out.println("\n");

        list.addFront((int) (Math.random() * (101)));

        list.print();
    }
}