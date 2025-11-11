package Q1.Java.BluePelican.Histogram;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Histogram {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/BluePelican/Histogram/HistogramData.txt"));
        Map<String, Integer> map = new TreeMap<>();
        String[] line = file.nextLine().split(", ");
        for (int lcv = 0; lcv < line.length; lcv++) {
            map.put(line[lcv], map.getOrDefault(line[lcv], 0) + 1);
        }
        for (String key : map.keySet()) {
            System.out.println(key + "," + map.get(key));
        }
        System.out.print("\nWords\tFrequency");
        for (String key : map.keySet()) {
            System.out.printf("\n%-5s\t%9s", key, "*".repeat(map.get(key)));
        }
    }
}
/*
bank,2
book,3
car,1
cow,1
hello,2
mud,3
ruby,1
toenail,1
yellow,2

Words	Frequency
bank 	       **
book 	      ***
car  	        *
cow  	        *
hello	       **
mud  	      ***
ruby 	        *
toenail	        *
yellow	       **
 */
