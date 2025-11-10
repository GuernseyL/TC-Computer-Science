package Q1.Java.Langdocs.Prog285bMaps;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog285bMaps {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Langdat/prog285b.txt"));
        Map<Integer, Com> map = new HashMap<>();

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
/*
101	17	2250.0	213.75
103	5	4000.0	3000.0
117	3	7350.0	0.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	605.625
192	8	8125.0	640.625
203	8	3250.0	2437.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
264	17	4150.0	394.25
291	17	750.0	71.25

101	17	2250.0	213.75
103	5	4000.0	3000.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	605.625
192	8	8125.0	640.625
203	8	3250.0	2437.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
264	17	4150.0	394.25
291	17	750.0	71.25
 */