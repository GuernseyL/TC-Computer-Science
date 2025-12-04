package Q1.Java.General;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordleBestWord {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/Wordle.txt"));
        ArrayList<String[]> words = new ArrayList<String[]>();

        while (file.hasNextLine()) {
            words.add(file.nextLine().split(""));
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 26; ++i) {
            char character = (char)(97 + i);
            map.put(String.valueOf(character), 0);
        }

        for (String[] word : words) {
            for (String letter : word) {
                map.put(letter, map.get(letter) + 1);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) > 720) {
                System.out.println(key + " : " + map.get(key));
            }
        }
    }

}
