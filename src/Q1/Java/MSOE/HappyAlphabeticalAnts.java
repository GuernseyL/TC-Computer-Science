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
        String data = line.toLowerCase();

        String[] Data = new String[data.length()];
        for (int i = 0; i < data.length(); i++) {
            Data[i] = data.substring(i, i + 1);
        }

        String Long = Data[0] + "";
        String temp = "";
        int temp2 = 0;
        int index = 0;
        int tempindex = 0;
        for (int i = 0; i < Data.length; i++){
            if (temp2 < Data.length-1) {
                temp2 = i + 1;
                while ((Data[temp2].equals(" ")) || (Data[temp2].equals(","))) {
                    ++temp2;
                }
            }
            if (Data[i].compareTo(Data[temp2]) < 0) {
                Long += Data[temp2];
            }
            else {
                if (Long.length() > temp.length()) {
                    temp = Long;
                    tempindex = index+1;
                }
                else if (Long.length() == temp.length()) {
                    temp = Long;
                    tempindex = temp2+1;
                }
                else { index = temp2; }
                Long = Data[temp2] + "";
            }
            if (i != data.length()-1 ) {i = temp2-1;}
        }

        System.out.println("Happiest: " + temp + " starting at character " + tempindex);
    }
}
