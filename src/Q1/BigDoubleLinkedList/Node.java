package Q1.BigDoubleLinkedList;

public class Node {
    private int mydata;
    public Node mynext;
    public Node myprev;

    public Node(int data) {
        mydata = data;
        mynext = null;
        myprev = null;
    }

    public int getVal() { return mydata; }
}
