package Q1.Prog285b;

public class Land285bHelper {
    private Node myroot;

    public Land285bHelper(){
        myroot=null;
    }

    public void addFront(Node spot){
        if (myroot == null) {
            myroot = spot;
        }
        else {
            spot.mynext = myroot;
            myroot = spot;
        }
    }

    public void print() {
        Node temp = myroot;
        while(temp!=null){
            System.out.println(temp.getCom().toString());
            temp=temp.mynext;
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
}
