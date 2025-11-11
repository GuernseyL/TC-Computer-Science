package Q1.Java.BluePelican.StudentClassification;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentClassification {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/BluePelican/StudentClassification/StudentClassification.txt"));
        Map<String, Set> map = new TreeMap<>();
        Set<String> SetFreshmen = new HashSet<>();
        Set<String> SetSophmore = new HashSet<>();
        Set<String> SetJunior = new HashSet<>();
        Set<String> SetSenior = new HashSet<>();

        while (file.hasNextLine()) {
            String[] line = file.nextLine().split(" ");
            if (line[0].equals("Freshman")) {
                SetFreshmen.add(line[1]);
            }
            if (line[0].equals("Sopherman")) {
                SetSophmore.add(line[1]);
            }
            if (line[0].equals("Junior")) {
                SetJunior.add(line[1]);
            }
            if (line[0].equals("Senior")) {
                SetSenior.add(line[1]);
            }
        }
        map.put("Freshman", SetFreshmen);
        map.put("Sophmore", SetSophmore);
        map.put("Junior", SetJunior);
        map.put("Senior", SetSenior);

        for (Map.Entry<String, Set> entry : map.entrySet()) {
            String key = entry.getKey();
            Set value = entry.getValue();
            for (Object o : value) {

            }
        }
    }
}
