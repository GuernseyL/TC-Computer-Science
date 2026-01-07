package Q1.Java.Langdocs.Prog285bBinaryTree;
import Q1.Java.General.Generals;

import java.util.Scanner;

public class BigBinaryTree {
    public static void main(String[] args) {
        int[] list = {4, 2, 8, 5, 1, 6, 3, 9, 7};
        Scanner input = new Scanner(System.in);
        BinaryTreeHelper BinaryTreeHelper = new BinaryTreeHelper();

        for (int lcv = 0; lcv < list.length; lcv++) {
            System.out.print(list[lcv] + " ");
            BinaryTreeHelper.add(list[lcv]);
        }
        System.out.println();

        BinaryTreeHelper.printinFix();

        System.out.println();

        BinaryTreeHelper.printpreFix();

        System.out.println();

        BinaryTreeHelper.printpostFix();

        //BinaryTreeHelper.remove(6);

        System.out.println();

        BinaryTreeHelper.printpreFix();

        System.out.println();

        System.out.println(BinaryTreeHelper.findDepth());

        BinaryTreeHelper = new BinaryTreeHelper();

        for (int lcv = 0; lcv < 100; lcv++) {
            int number = Generals.random(0, 100);
            BinaryTreeHelper.add(number);
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println("Node/Left/Right");
        BinaryTreeHelper.printpreFix();

        System.out.println();

        System.out.println("Left/Node/Right");
        BinaryTreeHelper.printinFix();

        System.out.println();

        System.out.println("Left/Right/Node");
        BinaryTreeHelper.printpostFix();

        System.out.println();

        System.out.println("Count: " + BinaryTreeHelper.count());

        System.out.println("Enter a number: " );
        int number = input.nextInt();
        if (BinaryTreeHelper.findNum(number)) {
            System.out.println("Binary tree contains " + number);
        }

        else {
            System.out.println("Binary tree does not contain " + number);
        }

        System.out.println();

        System.out.println("Depth: " + BinaryTreeHelper.findDepth());
    }
}
