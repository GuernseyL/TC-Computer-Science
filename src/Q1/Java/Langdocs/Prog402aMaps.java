package Q1.Java.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Prog402aMaps {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prg402a.dat"));

        Map<Integer, Integer> map = new HashMap<>();

        while (file.hasNext()) {
            map.put(file.nextInt(), file.nextInt());
        }

        Set<Integer> keys = map.keySet();

        Iterator<Integer> it = keys.iterator();
        double Average = 0;
        while (it.hasNext()) {
            Integer key = it.next();
            Average += map.get(key);
        }
        Average /= keys.size();

        System.out.println("ID:\t\tScore:\tDiff:");
        it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            Integer value = map.get(key);
            System.out.printf("%d\t\t%d\t\t%.2f\n", key, value, (value - Average));
        }
        System.out.printf("Average: %.2f",Average);
    }
}
/*
ID:		Score:	Diff:
321		245		2.38
323		245		2.38
325		246		3.38
104		239		-3.62
203		224		-18.62
301		242		-0.62
110		238		-4.62
207		228		-14.62
112		239		-3.62
208		242		-0.62
113		243		0.38
305		265		22.38
306		262		19.38
115		257		14.38
116		246		3.38
213		229		-13.62
311		256		13.38
218		243		0.38
123		253		10.38
222		223		-19.62
223		230		-12.62
Average: 242.62
 */