package Q1.Java.Langdocs.Prog285bBinaryTree;

public class BigBinaryTree {
    public static void main(String[] args) {
        int[] list = {4, 2, 8, 5, 1, 7, 3};

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
    }
}
