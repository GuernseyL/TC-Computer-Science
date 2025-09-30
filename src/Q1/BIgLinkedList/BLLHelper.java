package Q1.BIgLinkedList;

public class BLLHelper {
    private Node myroot;



    public void addFront(Node spot) {
        if (myroot == null){
            myroot = spot;
        }
        else {
            spot.mynext = myroot;
            myroot = spot;
        }
    }

    public void addBack(Node spot){
        if (myroot == null) {
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while(temp.mynext!=null){
                temp = temp.mynext;
            }
            temp.mynext = spot;
        }
    }

    public void NodeNum() {
        int count = 0;
        Node temp = myroot;
        w
    }

    public void print() {
        Node temp = myroot;
        while (temp != null) {
            System.out.println(myroot.getVal());
            temp = temp.mynext;
        }
    }
}
