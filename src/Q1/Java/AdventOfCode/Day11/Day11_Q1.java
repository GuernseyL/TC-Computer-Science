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
    }


    public static int Reccursion(Map<String, ArrayList<String>> map, int count, String key, int n, String Oyou) {
        if (map.get(key).contains("out")) {
            count++;
        }
        while (n < map.size()) {
            if (key.equals("you")) {

            }
            for (String s : map.get(key)) {
                count = Reccursion(map, count, s, n + 1, "you");
            }
        }

        if (n > map.size()) {
            count
        }

        return count;
    }
}
