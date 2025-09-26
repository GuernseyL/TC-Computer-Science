package Q1.Prog285b;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void calc() {
        Node temp = myroot;
        while (temp!=null){
            Com wow = temp.getCom();
            wow.calc();
            temp=temp.mynext;
        }
    }

    public Iterator<Com> iterator() {
        ArrayList<Com> stuff = new ArrayList<Com>();
        Node temp = myroot;
        while (temp!= null) {
            stuff.add(temp.getCom());
            temp = temp.mynext;
        }
        return stuff.iterator();
    }


    public void delete0(){
        while((myroot != null)&&(myroot.getCom().getmycommission() == 0 )){
            myroot = myroot.mynext;
        }

        Node prev = myroot;
        Node temp = myroot;
        while(temp!=null){
            if (temp.getCom().getmycommission()==0){
                prev.mynext = temp.mynext;
                temp = temp.mynext;
            }
            else {
                prev = temp;
            }
            temp = temp.mynext;
        }
    }
}


