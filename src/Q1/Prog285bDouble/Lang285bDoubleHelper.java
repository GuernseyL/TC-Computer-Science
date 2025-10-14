package Q1.Prog285bDouble;

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
        if (myroot == null) {
            return;
        }

        while(myroot.getCom() == 0) {
            myroot = myroot.myNext;
        }
    }
}
