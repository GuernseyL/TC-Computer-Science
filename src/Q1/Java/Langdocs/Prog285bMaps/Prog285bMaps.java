package Q1.Java.Langdocs.Prog285bMaps;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog285bMaps {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdat/prog285b.txt"));
        Map<Integer, Com> map = new TreeMap<>();

        while (input.hasNext()) {
            int id = input.nextInt();
            map.put(id, new Com(id, input.nextInt(), input.nextDouble()));
        }

        Set<Integer> keys = map.keySet();

        Iterator<Integer> stuff = keys.iterator();
        ArrayList<Integer> list = new ArrayList<>();

        while (stuff.hasNext()) {
            int key = stuff.next();
            Com com = map.get(key);
            com.calc();
            if (com.getmycommission() == 0) { list.add(com.getMyid()); }
            System.out.println(com);
        }

        for (int i = 0; i < list.size(); i++) {
            if (keys.contains(list.get(i))) {
                keys.remove(list.get(i));
            }
        }

        stuff = keys.iterator();
        System.out.println();

        while (stuff.hasNext()) {
            int key = stuff.next();
            Com com = map.get(key);
            com.calc();
            System.out.println(com);
        }
    }
}
