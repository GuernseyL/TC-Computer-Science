package Q1.Java.Langdocs.Prog285bBinaryTree;
import Q1.Java.General.Generals;

public class BinaryTreeHelper {
    private BinaryTreeNode myroot;

    public BinaryTreeHelper() {
        myroot = null;
    }

    public void add(int number) {
        BinaryTreeNode temporary = new BinaryTreeNode(number);

        if (myroot == null) {
            myroot = temporary;
        }
        else {
            BinaryTreeNode spot = myroot;
            BinaryTreeNode previous = myroot;
            while (spot != null) {
                if (number < spot.getMyNumber()) {
                    previous = spot;
                    spot = spot.myleft;
                }
                else {
                    previous = spot;
                    spot = spot.myright;
                }
            }

            if (number < previous.getMyNumber()) {
                previous.myleft = temporary;
            }
            else {
                previous.myright = temporary;
            }
        }
    }

    public void printinFix() {
        printinFix(myroot);
    }

    public void printpreFix() {
        printpreFix(myroot);
    }

    public void printpostFix() {
        printpostFix(myroot);
    }

    private void printinFix(BinaryTreeNode spot) {
        if (spot == null) {
            return;
        }
        printinFix(spot.myleft);
        System.out.println(spot.getMyNumber());
        printinFix(spot.myright);
    }

    private void printpreFix(BinaryTreeNode spot) {
        if (spot == null) {
            return;
        }
        System.out.println(spot.getMyNumber());
        printpreFix(spot.myleft);
        printpreFix(spot.myright);
    }

    private void printpostFix(BinaryTreeNode spot) {
        if (spot == null) {
            return;
        }
        printpostFix(spot.myleft);
        printpostFix(spot.myright);
        System.out.println(spot.getMyNumber());
    }

    public void remove(int number) {
        BinaryTreeNode spot = null;
        BinaryTreeNode temporary = myroot;

        while (temporary != null && temporary.getMyNumber() != number) {
            spot = temporary;
            if (number < temporary.getMyNumber()) {
                temporary = temporary.myleft;
            }
            else {
                temporary = temporary.myright;
            }
        }

        if (temporary == null) {
            return;
        }

        if (temporary.myright == null && temporary.myleft == null) {
            if (number<spot.getMyNumber()) {
                spot.myleft = null;
            }
            else {
                spot.myright = null;
            }
            return;
        }

        if (temporary.myright == null || temporary.myleft == null) {
            if (temporary == myroot) {
                if (temporary.myleft == null) {
                    myroot = temporary.myright;
                }
                else {
                    myroot = temporary.myleft;
                }
            }
            else {
                if (temporary.myleft == null) {
                    if (number < spot.getMyNumber()) {
                        spot.myleft = temporary.myright;
                    }
                    else {
                        spot.myright = temporary.myright;
                    }
                }
                else {
                    if (number < spot.getMyNumber()) {
                        spot.myleft = temporary.myleft;
                    }
                    else {
                        spot.myright = temporary.myleft;
                    }
                }
            }
            return;
        }

        spot = temporary;
        BinaryTreeNode find = temporary.myleft;
        while (find != null) {
            spot = find;
            find = find.myright;
        }
        if (find == temporary.myleft) {
            temporary.setMyNumber(find.getMyNumber());
            temporary.myleft = find.myleft;
        }
        else {
            temporary.setMyNumber(find.getMyNumber());
            spot.myright = find.myleft;
        }

    }

    public int count() {
        return count(myroot);
    }

    private int count(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + count(node.myleft) + count(node.myright);
    }

    public boolean findNum(int number) {
        return findNum(myroot, number);
    }

    private boolean findNum(BinaryTreeNode node, int number) {
        if (node == null) {
            return false;
        }

        if (node.getMyNumber() == number) {
            return true;
        }
        else { return findNum(node.myleft, number) || findNum(node.myright, number); }
    }

    public int findDepth() {
        return findDepth(myroot) + 1;
    }

    private int findDepth(BinaryTreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftDepth = findDepth(node.myleft);
        int rightDepth = findDepth(node.myright);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int findWidth() {
        return findWidth(myroot, 1);
    }

    private int findWidth(BinaryTreeNode node, int width) {
        if (node == null) {
            return 0;
        }
        return 0;
    }
}
