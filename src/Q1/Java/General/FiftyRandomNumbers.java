package Q1.Java.General;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class FiftyRandomNumbers {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();

        while (set.size() < 50) {
            set.add(r.nextInt(1000));
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
