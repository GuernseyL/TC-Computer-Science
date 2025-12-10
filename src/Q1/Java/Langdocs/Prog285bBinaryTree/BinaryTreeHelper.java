package Q1.Java.Langdocs.Prog285bBinaryTree;

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
                if (number < spot.getmynumber()) {
                    previous = spot;
                    spot = spot.myleft;
                }
                else {
                    previous = spot;
                    spot = spot.myright;
                }
            }

            if (number < previous.getmynumber()) {
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
        System.out.println(spot.getmynumber());
        printinFix(spot.myright);
    }

    private void printpreFix(BinaryTreeNode spot) {
        if (spot == null) {
            return;
        }
        System.out.println(spot.getmynumber());
        printinFix(spot.myleft);
        printinFix(spot.myright);
    }

    private void printpostFix(BinaryTreeNode spot) {
        if (spot == null) {
            return;
        }
        printinFix(spot.myleft);
        printinFix(spot.myright);
        System.out.println(spot.getmynumber());
    }

    private void remove(int number) {
        BinaryTreeNode spot = null;
        BinaryTreeNode temporary = myroot;

        while (temporary != null && temporary.getmynumber() != number) {
            spot = temporary;
            if (number < temporary.getmynumber()) {
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
            if (number<spot.getmynumber()) {
                spot.myleft = null;
                return;
            }
            else {
                spot.myright = null;
                return;
            }
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
                    if (number < spot.getmynumber()) {
                        spot.myleft = temporary.myright;
                    }
                    else {
                        spot.myright = temporary.myright;
                    }
                }
                else {
                    if (number < spot.getmynumber()) {
                        spot.myleft = temporary.myleft;
                    }
                    else {
                        spot.myright = temporary.myleft;
                    }
                }
            }
        }

        if (temporary.myleft != null && temporary.myright != null) {
            if (temporary == myroot) {
                spot = temporary.myleft;
                while (spot.myright != null) {
                    spot = spot.myright;
                }
            }
        }
    }
}
