package Q1;
import java.util.Scanner;

public class Prog335e {
    static int[] List = new int[100];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int x = 1; x <= 100; ++x) {
            int delta = (int) (Math.random() * (1001 - 1)) + 1;
            List[x-1] = delta;
            System.out.print(List[x-1] + " ");
            if ((x-1) % 10 == 0 && (x-1) != 0) { System.out.println(); }
        }
        System.out.println();
        for (int lcv = 1; lcv <= 7; ++lcv) {
            int x = (int) (Math.random() * (1001 - 1)) + 1;
            int Solution = location(x);
            if (Solution != -1) { System.out.println(x + " IS LOCATED IN POSITION " + Solution); }
            else { System.out.println(x + " DOES NOT EXIST IN THIS ARRAY"); }
        }
    }

    public static int location(int n) {
    for (int X = 0; X <= 99; ++X) {
        if (List[X] == n) {
            return X;
        }
    }
    return -1;
    }
}

/*
152 825 576 927 664 654 778 733 251 480 728
956 214 480 929 336 763 504 211 30 360
614 694 908 547 727 753 735 3 581 216
724 722 300 633 200 543 482 859 332 1000
861 403 238 350 299 943 22 930 36 167
710 454 928 630 417 723 607 644 469 231
374 280 693 565 908 479 532 123 798 896
165 566 259 537 348 685 359 507 270 780
516 134 300 480 47 565 177 930 44 452
803 621 938 732 542 767 679 588 645
981 DOES NOT EXIST IN THIS ARRAY
575 DOES NOT EXIST IN THIS ARRAY
630 IS LOCATED IN POSITION 54
150 DOES NOT EXIST IN THIS ARRAY
216 IS LOCATED IN POSITION 30
510 DOES NOT EXIST IN THIS ARRAY
973 DOES NOT EXIST IN THIS ARRAY
 */
