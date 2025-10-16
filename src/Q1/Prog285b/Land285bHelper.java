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
/*
101	17	2250.0	213.75
103	5	4000.0	3000.0
117	3	7350.0	0.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	605.625
192	8	8125.0	640.625
203	8	3250.0	2437.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
264	17	4150.0	394.25
291	17	750.0	71.25

101	17	2250.0	213.75
103	5	4000.0	3000.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	605.625
192	8	8125.0	640.625
203	8	3250.0	2437.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
264	17	4150.0	394.25
291	17	750.0	71.25

101	17	2250.0	213.75
103	5	4000.0	3000.0
118	8	7350.0	574.75
125	5	6500.0	502.5
138	17	6375.0	605.625
192	8	8125.0	640.625
203	8	3250.0	2437.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
264	17	4150.0	394.25
291	17	750.0	71.25
 */


