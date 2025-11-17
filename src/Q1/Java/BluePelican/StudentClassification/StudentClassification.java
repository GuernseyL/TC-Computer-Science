package Q1.Java.BluePelican.StudentClassification;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentClassification {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/BluePelican/StudentClassification/StudentClassification.txt"));
        Map<String, Set<String>> map = new HashMap<>();
        String[] keys = {"Freshman", "Sophomore", "Junior", "Senior"};
        for (int lcv = 0; lcv < keys.length; ++lcv) {
            map.put(keys[lcv], new TreeSet<>());
        }


        while (file.hasNextLine()) {
            map.get(file.next()).add(file.next());
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key) + "\n");
        }
    }
}
/*
Sophomore:[Ahab, Julie, Solomon]

Junior:[Betty, David, Ruth]

Senior:[Agnes, Bill, Boaz, Jezebel]

Freshman:[Fred]
 */
