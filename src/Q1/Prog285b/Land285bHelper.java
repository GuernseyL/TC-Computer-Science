package Q1.Prog285b;

public class Land285bHelper {
    private Node myroot;

    public Land285bHelper(){
        myroot=null;
    }

    public void add(Node spot){
        if (myroot == null) {
            myroot=spot;
        }
        else {
            spot.mynext = myroot;
            myroot = spot;
        }
    }

    public void print() {
        Node temp = myroot;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.mynext;
        }
    }
}
