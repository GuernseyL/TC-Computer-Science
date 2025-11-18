package Q1.Java.MSOE;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class HappyAlphabeticalAnts {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("Langdat/HappyAlphabeticalAnts.txt"));
        String line = file.nextLine();
        String line2 = line;
        String data = line.toLowerCase();
        System.out.println(line);

        String[] Data = new String[data.length()];
        for (int i = 0; i < data.length(); i++) {
            Data[i] = data.substring(i, i + 1);
        }

        String Long = Data[0] + "";
        String temp = "";
        int temp2;
        int index = 0;
        for (int i = 0; i < Data.length-2; i++){
            temp2 = i+1;
            while((Data[temp2].equals(" ")) || (Data[temp2].equals(","))){
                ++temp2;
            }
            if (Data[i].compareTo(Data[temp2]) < 0)
                Long += Data[temp2];
            else {
                if (Long.length() > temp.length()) {
                    temp = Long;
                }
                index = temp2;
                Long = Data[temp2] + "";
            }
            i = temp2-1;
        }

        System.out.println(temp + " starting at character " + index);
    }
}
