package Q1.Java.Langdocs.Prog1999wGigaFarm;

public class Prog1999wHorseLinkedList {
    private Node myroot;

    public Prog1999wHorseLinkedList() {
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
}

