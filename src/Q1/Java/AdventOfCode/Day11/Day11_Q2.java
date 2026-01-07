package Q1.Java.AdventOfCode.Day11;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Day11_Q2 {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/Day11-25.txt"));
        Map<String, Set<String>> map = new HashMap<>();
        while (file.hasNext()) {
            String line = file.nextLine();
            String key = line.substring(0, line.indexOf(":"));
            String outputs = line.substring(line.indexOf(":") + 2);
            String[] list = outputs.split(" ");
            Set<String> set = new HashSet<>();
            for(int lcv = 0; lcv < list.length; lcv++) {
                set.add(list[lcv]);
            }
            map.put(key, set);
        }
        ArrayList<String> code = new ArrayList<>();
        code.add("svr");
        int count = 0;
        for (int lcvA = 0; lcvA < 604; lcvA++) {
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            ArrayList<String> nextCode = new ArrayList<>();
            for (int lcvB = 0; lcvB < code.size(); lcvB++) {
                String yes = code.get(lcvB);
                Set<String> temps = map.get(yes);
                Iterator<String> it = temps.iterator();
                while (it.hasNext()) {
                    int index = 0;
                    String look = it.next();
                    if (look.equals("svr")) {
                    }
                    else {
                        if (look.equals("out")) {
                            if (list.get(index).contains("dac") || list.get(index).contains("fft")) {
                                ++count;
                            }
                        }
                        else {
                            nextCode.add(look);
                            ArrayList<String> temp = new ArrayList<>();
                            temp.add(look);
                            if (list.size() < index) {
                                list.add(temp);
                            }
                            else {
                                temp = list.get(index);
                                temp.add(look);
                                list.set(index, temp);
                            }
                        }
                    }
                    ++index;
                }
            }
            code = nextCode;
            System.out.println("\n\n\n\n\n\n\n\n");
        }
        System.out.println(count);
    }
}
