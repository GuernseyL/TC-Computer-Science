package Q1.Java.BluePelican.StudentClassification;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentClassification {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/BluePelican/StudentClassification/StudentClassification.txt"));
        Map<String, TreeSet<String>> map = new TreeMap<>();
        TreeSet<String>[] set = new TreeSet[4];


        while (file.hasNextLine()) {
            String[] line = file.nextLine().split(" ");
            set[(line[0].equals("Freshman")) ? 0 : (line[0].equals("Sophomore")) ? 1 : (line[0].equals("Junior")) ? 2 : 3].add(line[1]);
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Set value = entry.getValue();
            System.out.print(key + ": ( ");
            for (Object o : value) {
                System.out.print(o + " ");
            }
            System.out.println(")");
        }
    }
}
/*
Freshman: ( Fred )
Junior: ( Betty David Ruth )
Senior: ( Agnes Bill Boaz Jezebel )
Sophomore: ( Ahab Julie Solomon )
 */
