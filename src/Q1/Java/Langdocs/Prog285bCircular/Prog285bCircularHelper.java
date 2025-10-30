package Q1.Java.Langdocs.Prog285bCircular;

public class Prog285bCircularHelper {
    private Node myroot;

    public Prog285bCircularHelper() {
        myroot = null;
    }

    public void addfront(Node node) {
        if (myroot == null) {
            myroot = node;
            myroot.myNext = myroot;
            myroot.myPrev = myroot;
        }
        else {
            node.myNext = myroot;
            myroot.myPrev = node;
            Node temp = myroot.myNext;
            while (temp.myNext != myroot) {
                temp = temp.myNext;
            }
            temp.myNext = node;
            temp.myNext.myPrev = temp;
        }
    }

    public void print() {
        System.out.println(myroot);
        Node temp = myroot.myNext;
        while(temp!=myroot) {
            System.out.println(temp);
            temp = temp.myNext;
        }
    }

    public void calcall() {
        myroot.calc();
        Node temp = myroot.myNext;
        while (temp!=myroot)
        {
            temp.calc();
            temp = temp.myNext;
        }
    }

    public void remove0() {
        if (myroot.getCom() == 0.0) {
            myroot.myNext.myPrev = myroot.myPrev;
            myroot.myPrev.myNext = myroot.myNext;
            myroot = myroot.myNext;
        }
        Node temp = myroot.myNext;

        while (temp != myroot) {
            if (temp.getCom() == 0.0) {
                temp.myNext.myPrev = temp.myPrev;
                temp.myPrev.myNext = temp.myNext;
            }
            temp = temp.myNext;
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
 */

