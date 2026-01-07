package Q1.Java.Langdocs.Prog285bBinaryTree;

public class BinaryTreeNode {
    private int mynumber;
    public BinaryTreeNode myleft;
    public BinaryTreeNode myright;

    public BinaryTreeNode(int mynumber) {
        this.mynumber = mynumber;
        myleft = null;
        myright = null;
    }

    public int getMyNumber() {
        return mynumber;
    }

    public void setMyNumber(int newnumber) {
        mynumber = newnumber;
    }
}