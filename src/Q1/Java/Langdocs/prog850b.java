package Q1.Java.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class prog850b {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prog850b.csv"));
        Map<String, Integer> map = new TreeMap<>();
        while (file.hasNextLine()) {
            String[] line = file.nextLine().split(",");
            if (!line[1].equals("total")) {
                map.put(line[0], map.getOrDefault(line[0], 0) + Integer.parseInt(line[line.length - 1]));
            }
        }
        //map.put(line[0], Integer.parseInt(line[1]));
        for (String key : map.keySet()) System.out.printf(key + "\t" + map.get(key));
    }
}
