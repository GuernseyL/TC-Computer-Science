package Q1.Java.Langdocs.Prog285bCircular;

public class Lang285bDoubleHelper {
    private Node myroot;

    public Lang285bDoubleHelper() {
        myroot = null;
    }

    public void addfront(Node node) {
        if (myroot == null) {
            myroot = node;
            node.myNext = myroot;
            node.myPrev = myroot;
        }
        else {
            node.myNext = myroot;
            myroot.myPrev = node;
            Node temp = myroot.myNext;
            while (temp.myNext != myroot) {
                temp = temp.myNext;
            }
            temp.myNext = node;
            temp.myNext.myPrev = node;
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
        if (myroot != null && myroot.getCom() == 0.0) {
            myroot = myroot.myNext;
        }

        Node temp = myroot;

        while(temp != null) {
            if (temp.getCom() == 0.0) {
                temp.myPrev.myNext = temp.myNext;
            }
            temp = temp.myNext;
        }
    }
}
