package Q1.Java.General;

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
}
