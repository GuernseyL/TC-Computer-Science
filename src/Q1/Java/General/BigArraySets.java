package Q1.Java.General;

import java.util.*;

public class BigArraySets {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 19) {
            set.add(rand.nextInt(20, 90));
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\n\n");

        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n");

        it = set.iterator();

        int count = 0;
        while (count != set.size()/2) {
            count++;
            it.next();
        }
        System.out.print("Middle: " + it.next());

        System.out.println("\n\n");

        it = set.iterator();

        int first;
        int middle;
        int last = 0;
        count = 0;

        first = it.next();

        while (count != set.size()/2) {
            count++;
            it.next();
        }

        middle = it.next();

        while (it.hasNext()) {
            last = it.next();
        }

        double avg = (((double) middle) + first + last)/3;

        it = set.iterator();

        int var = it.next();
        int smallest = var, largest = var;

        while (it.hasNext()) {
            var = it.next();
            if (smallest > var) {
                smallest = var;
            }
            if (largest < var) {
                largest = var;
            }
        }

        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);

        System.out.println("\n\n");

        set.add(rand.nextInt(1, 10));

        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n");

        int[] data = new int[set.size()];
        count = 0;
        for (Integer i : set) {
            data[count] = i+10;
            ++count;
        }
        set.clear();
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }

        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
}
