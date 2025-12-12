package Q1.Java.AdventOfCode.Day11;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day11_Q1 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/Day11-25.txt"));
        Map<String, ArrayList<String>> map = new HashMap<>();
        while (file.hasNext()) {
            ArrayList<String> words = new ArrayList<>();
            String line = file.nextLine();
            String key = line.substring(0, line.indexOf(":"));
            String[] outputs = line.substring(line.indexOf(":") + 2).split(" ");
            Set<String> set = new HashSet<>();
            for (String s : outputs) {
                if (!(s.equals("you"))) {
                    set.add(s);
                }
            }
            for (String s : outputs) {
                words.add(s);
            }
            map.put(key, words);
        }
        int alpha = Reccursion(map, 0, "you", 0, 0);
    }


    public static int Reccursion(Map<String, ArrayList<String>> map, int count, String key, int n, int you) {
        if (map.get(key).contains("out")) {
            count++;
            ++you;
        }
        while (n < map.size()) {
            if (key.equals("you")) {
                count = Reccursion(map, count, map.get(key).get(you), 0, you);
            }
            for (String s : map.get(key)) {
                count = Reccursion(map, count, s, n + 1, 0);
            }
        }

        if (n > map.size()) {
            ++you;
        }

        return count;
    }
}
