package Q1.BIgLinkedList;

public class BLLHelper {
    private Node myroot;



    public void addFront(int num) {
        Node spot = new Node(num);
        if (myroot == null){
            myroot = spot;
        }
        else {
            spot.mynext = myroot;
            myroot = spot;
        }
    }

    public void addLast(int num){
        Node spot = new Node(num);
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

    public void getCount() {
        int count = 0;
        Node temp = myroot;
        while (temp != null) {
            count++;
            temp = temp.mynext;
        }
        System.out.println(count);
    }

    public void add(int num1, int num2) {
        Node spot = new Node(num1);
        Node temp = myroot;
        while (num2 != 0) {
            temp = temp.mynext;
            --num2;
        }
        spot.mynext = temp.mynext.mynext;
        temp.mynext = spot;
    }

    public boolean isEmpty() {
        return myroot == null;
    }

    public boolean isThere(int num) {
        Node temp = myroot;
        while (temp != null) {
            if (temp.getVal() == num) {
                return true;
            }
            temp = temp.mynext;
        }
        return false;
    }

    public int getFirst() {
        if (!isEmpty()){
            return myroot.getVal();
        }
        return -1;
    }

    public int getLast() {
        if (!isEmpty()){
            Node temp = myroot;
            while (temp.mynext!=null){
                temp = temp.mynext;
            }
            return temp.getVal();
        }
        return -1;
    }

    public int getSpot(int spot) {
        if (!isEmpty()){
            Node temp = myroot;
            while (spot != 0) {
                temp = temp.mynext;
                --spot;
            }
            return temp.getVal();
        }
        return -1;
    }

    public void removeFirst() {
        myroot = myroot.mynext;
    }

    public void removeLast() {
        Node temp = myroot;
        while (temp.mynext!=null){
            temp = temp.mynext;
        }
        temp = null;
    }

    public int countLess10() {
        int count = 0;
        Node temp = myroot;
        while (temp != null) {
            if (temp.getVal() < 10) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public Node getPrevious() {



        return dan;
    }

    public void removeSpot(int spot) {
        if (!isEmpty()){
            Node temp = myroot;
            while (spot != 1) {
                temp = temp.mynext;
            }
            temp.mynext = temp.mynext.mynext;
        }
    }

    public void clear() {
        myroot = null;
    }



    public void print() {
        Node temp = myroot;
        while (temp != null) {
            System.out.println(myroot.getVal());
            temp = temp.mynext;
        }
    }
}
