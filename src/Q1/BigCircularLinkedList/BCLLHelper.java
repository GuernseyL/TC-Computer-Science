package Q1.BigCircularLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class BCLLHelper {
    private Node head;

    public void addFront(int num) {
        Node spot = new Node(num);
        if (head == null){
            head = spot;
            head.mynext = spot;
            head.myprev = spot;
        }
        else {
            Node temp = head;
            spot.mynext = head;
            head.myprev = spot;
            while(temp.mynext != head) {
                temp = temp.mynext;
            }
            temp.mynext = spot;
            spot.myprev = temp;
        }
    }

    public void addLast(int num){
        Node spot = new Node(num);
        if (head == null) {
            head = spot;
            head.mynext = spot;
            head.myprev = spot;
        }
        else {
            Node temp = head;
            while(temp.mynext!=head){
                temp = temp.mynext;
            }
            temp.mynext = spot;
            spot.myprev = temp;
        }
    }

    public int getCount() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.mynext;
        }
        return count;
    }

    public void add(int num1, int num2) {
        Node spot = new Node(num1);
        Node temp = head;
        while (num2 != 0) {
            temp = temp.mynext;
            --num2;
        }
        spot.mynext = temp.mynext.mynext;
        temp.mynext = spot;
        spot.myprev = temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isThere(int num) {
        Node temp = head;
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
            return head.getVal();
        }
        return -1;
    }

    public int getLast() {
        if (!isEmpty()){
            Node temp = head;
            while (temp.mynext!=null){
                temp = temp.mynext;
            }
            return temp.getVal();
        }
        return -1;
    }

    public int getSpot(int spot) {
        if (!isEmpty()){
            Node temp = head;
            while (spot > 0) {
                temp = temp.mynext;
                --spot;
            }
            return temp.getVal();
        }
        return -1;
    }

    public void removeFirst() {
        head = head.mynext;
    }

    public void removeLast() {
        Node temp = head;
        while (temp.mynext!=null){
            temp = temp.mynext;
        }
        temp = null;
    }

    public int countLess10() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.getVal() < 10) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void removeSpot(int spot) {
        if (!isEmpty()){
            Node temp = head;
            while (spot > 0 && temp.mynext!=null) {
                temp = temp.mynext;
                --spot;
            }
            if (temp.mynext == null){
                temp = null;
                return;
            }
            temp.mynext = temp.mynext.mynext;
            temp.mynext.myprev = temp;
        }
    }

    public void clear() {
        while (head.mynext != null) {
            Node temp = head;
            while (temp.mynext.mynext != null) {
                temp = temp.mynext;
            }
            temp.mynext = null;
            head = head.mynext;
        }
        head = null;
    }

    public boolean checkForNum(int num) {
        Node temp = head;
        while (temp != null) {
            if (temp.getVal() == num) { return true; }
            temp = temp.mynext;
        }
        return false;
    }

    public int getNum(int pos) {
        Node temp = head;
        while (pos != 0) {
            temp = temp.mynext;
            --pos;
            if (temp == null) { return -1; }
        }
        return temp.getVal();
    }

    public BCLLHelper getReverse() {
        BCLLHelper temp = new BCLLHelper();
        int[] data = new int[getCount()];
        int reverse = 0;
        for (int i = getCount() - 1; i >= 0; --i) {
            data[reverse] = getNum(i);
            ++reverse;
        }
        for (int i = 0; i < getCount() - 1; ++i) {
            temp.addLast(data[i]);
        }
        return temp;
    }

    public Iterator<Integer> iterator() {
        ArrayList<Integer> stuff = new ArrayList<Integer>();
        Node temp = head;
        while (temp!= null) {
            stuff.add(temp.getVal());
            temp = temp.mynext;
        }
        return stuff.iterator();
    }

    public double avg() {
        Node temp = head;
        double total = 0.0;
        while (temp != null) {
            total += temp.getVal();
            temp = temp.mynext;
        }
        return total / (double)getCount();
    }

    public int getMax() {
        Node temp = head;
        int max = 0;
        while (temp != null) {
            if (temp.getVal() > max) { max = temp.getVal(); }
            temp = temp.mynext;
        }
        return max;
    }

    public int getMin() {
        Node temp = head;
        int min = temp.getVal();
        while (temp != null) {
            if (temp.getVal() < min) { min = temp.getVal(); }
            temp = temp.mynext;
        }
        return min;
    }

    public int findSlotMaxFirst() {
        Node temp = head;
        int data = this.getMax();
        int pos = 0;
        while (temp != null) {
            if (temp.getVal() == data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return -1;
    }

    public int findSlotMaxLast() {
        Node temp = head;
        int data = this.getMin();
        int pos = 0;
        int last = pos;
        while (temp != null) {
            ++pos;
            if (temp.getVal() == data) { last = pos; }
            temp = temp.mynext;
        }
        return last;
    }

    public int findSlotMinFirst() {
        Node temp = head;
        int data = this.getMin();
        int pos = 0;
        while (temp != null) {
            if (temp.getVal() < data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return 0;
    }

    public BCLLHelper sort() {
        int[] data = new int[getCount()];
        for (int i = 0; i < getCount(); ++i) {
            data[i] = getNum(i);
        }
        for (int i = 0; i < data.length; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        BCLLHelper temp = new BCLLHelper();
        for (int i = 0; i < data.length; i++) {
            temp.addLast(data[i]);
        }
        return temp;
    }

    public int lose58() {
        Node temp = head;
        int count = 0;
        while (temp.mynext != null) {
            if (temp.mynext.getVal() == 58) {
                temp.mynext = temp.mynext.mynext;
                temp.mynext.myprev = temp;
                ++count;
            }
            else { temp = temp.mynext; }
        }
        return count;
    }

    public int getEvenCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.getVal() % 2 == 0) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void killOdds() {
        Node temp = head;
        while (temp.mynext != null) {
            if (temp.mynext.getVal() % 2 == 1) {
                temp.mynext = temp.mynext.mynext;
                temp.mynext.myprev = temp;
            }
            else { temp = temp.mynext; }
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getVal());
            temp = temp.mynext;
        }
    }
}