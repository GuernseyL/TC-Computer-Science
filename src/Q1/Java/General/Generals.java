package Q1.Java.General;

import java.util.ArrayList;

public class Generals {
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static boolean even(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;
    }

    public static int FindLowestIntArrayList(ArrayList<Integer> array) {
        int lowest = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < lowest) {
                lowest = array.get(i);
            }
        }
        return lowest;
    }

    public static double FindLowestDoubleArrayList(ArrayList<Double> array) {
        double lowest = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < lowest) {
                lowest = array.get(i);
            }
        }
        return lowest;
    }
}
