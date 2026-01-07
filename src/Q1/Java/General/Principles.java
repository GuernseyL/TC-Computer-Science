package Q1.Java.General;

import java.util.Scanner;

public class Principles {
    public static void main(String[] args) {
        String[] words;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter in a sentence (Do not add punctuation): ");
        words = input.nextLine().split(" ");
        sort(words);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public static String[] sort(String[] Alpha) {
        for (int i = 0; i < Alpha.length; i++) {
            for (int j = i; j < Alpha.length; j++) {
                if (Alpha[j].compareTo(Alpha[i]) < 0) {
                    String temp = Alpha[j];
                    Alpha[j] = Alpha[i];
                    Alpha[i] = temp;
                }
            }
        }
        return Alpha;
    }
}
