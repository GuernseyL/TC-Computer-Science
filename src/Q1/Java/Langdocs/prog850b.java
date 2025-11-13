package Q1.Java.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class prog850b {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prog850b.txt"));
        Map<String, Integer[]> map = new TreeMap<>();
        while (file.hasNextLine()) {
            String name = file.next();
            Integer[] data = {file.nextInt(), 0};
            file.next();
            file.next();
            file.next();
            map.put(name, map.getOrDefault(name, 0) + data);
        }
        //map.put(line[0], Integer.parseInt(line[1]));
        for (String key : map.keySet()) System.out.printf(key + "\t" + map.get(key));
    }
}
