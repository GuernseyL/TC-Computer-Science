package Q1.Java.Langdocs.Prog285bDouble;

public class Lang285bDoubleHelper {
    private doubleNode myroot;

    public Lang285bDoubleHelper() {
        myroot = null;
    }

    public void addfront(doubleNode node) {
        if (myroot == null) {
            myroot = node;
        }
        else {
            node.myNext = myroot;
            myroot.myPrev = node;
            myroot = node;
        }
    }

    public void addback(doubleNode node) {
        if (myroot == null) {
            myroot = node;
        }

        else {
            doubleNode temp = myroot;
            while (temp.myNext != null) {
                temp = temp.myNext;
            }
            temp.myNext = node;
            node.myPrev = temp;
        }
    }

    public void print() {
        doubleNode temp = myroot;
        while(temp!=null){
            System.out.println(temp);
            temp = temp.myNext;
        }
    }

    public void calcall() {
        doubleNode temp = myroot;
        while (temp!=null)
        {
            temp.calc();
            temp = temp.myNext;
        }
    }

    public void remove0() {
        if (myroot != null && myroot.getCom() == 0.0) {
            myroot = myroot.myNext;
        }

        doubleNode temp = myroot;

        while(temp != null) {
            if (temp.getCom() == 0.0) {
                temp.myPrev.myNext = temp.myNext;
            }
            temp = temp.myNext;
        }
    }
}
/*
291	17	750.0	71.25
264	17	4150.0	394.25
235	5	5250.0	396.25
218	5	5000.0	3750.0
203	8	3250.0	2437.5
192	8	8125.0	640.625
138	17	6375.0	605.625
125	5	6500.0	502.5
118	8	7350.0	574.75
117	3	7350.0	0.0
103	5	4000.0	3000.0
101	17	2250.0	213.75



291	17	750.0	71.25
264	17	4150.0	394.25
235	5	5250.0	396.25
218	5	5000.0	3750.0
203	8	3250.0	2437.5
192	8	8125.0	640.625
138	17	6375.0	605.625
125	5	6500.0	502.5
118	8	7350.0	574.75
103	5	4000.0	3000.0
101	17	2250.0	213.75
 */
