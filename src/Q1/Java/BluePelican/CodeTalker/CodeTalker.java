package Q1.Java.BluePelican.CodeTalker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeTalker {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/BluePelican/CodeTalker/CodeTalkerData.dat"));
        Map<String, String> map = new HashMap<>();
        int cnt = file.nextInt();
        String junk = file.nextLine();
        for (int lcv = 1; lcv <= cnt; ++lcv) {
            String[] data = file.nextLine().split("=");
            System.out.println(data[0] + "=" + data[1]);
            map.put(data[0], data[1]);
        }
        String[] data = file.nextLine().split(" ");
        for (int lcv = 0; lcv < data.length; ++lcv) {
            System.out.print(data[lcv] + " ");
        }
        System.out.println();

        for (String s : data) {
            if (map.containsKey(s)) {
                s = map.get(s);
            }
            System.out.print(s + " ");
        }
    }
}
/*
beaver=swim
hello=fierce
spank=like
freedom=wrench
yellow=can't
whale=for
ketchup=pickles
yes=me
meter=I
foreign=state
staple=but
wood=sandwich
hand=could
meter always spank ketchup staple meter yellow beaver
I always like pickles but I can't swim
*/

