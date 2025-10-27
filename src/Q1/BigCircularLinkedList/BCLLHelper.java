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
            spot.mynext = head;
            head.myprev = spot;
        }
    }

    public int getCount() {
        int count = 1;
        Node temp = head.mynext;
        while (temp != head) {
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
        spot.mynext = temp;
        temp.myprev.mynext = spot;
        spot.myprev = temp.myprev;
        temp.myprev = spot;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isThere(int num) {
        Node temp = head;
        if (temp.getVal() == num) {
            return true;
        }
        temp = temp.mynext;
        while (temp != head) {
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
            while (temp.mynext != head){
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
        head.myprev.mynext = head.mynext;
        head.mynext.myprev = head.myprev;
        head = head.mynext;
    }

    public void removeLast() {
        Node temp = head;
        while (temp.mynext!=head){
            temp = temp.mynext;
        }
        head.myprev = temp.myprev;
        temp.myprev.mynext = head;
        temp = temp.mynext;
    }

    public int countLess10() {
        int count = 0;
        Node temp = head;
        if (temp.getVal() < 10) {
            ++count;
        }
        while (temp != head) {
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
            while (spot > 0) {
                temp = temp.mynext;
                --spot;
            }
            temp.myprev.mynext = temp.mynext;
            temp.mynext.myprev = temp.myprev;
            temp = temp.mynext;
        }
    }

    public void clear() {
        while (head.mynext != null) {
            head = head.mynext;
            head.myprev = null;
        }
        head = null;
    }

    public boolean checkForNum(int num) {
        Node temp = head;
        if (temp.getVal() == num) { return true; }
        temp = temp.mynext;
        while (temp != head) {
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
        }
        return temp.getVal();
    }

    public BCLLHelper getReverse() {
        BCLLHelper temp = new BCLLHelper();
        Node temp2 = head.myprev;
        while (temp2 != head) {
            temp.addFront(temp2.getVal());
            temp2 = temp2.myprev;
        }
        temp.addFront(temp2.getVal());
        return temp;
    }

    public Iterator<Integer> iterator() {
        ArrayList<Integer> stuff = new ArrayList<Integer>();
        Node temp = head;
        stuff.add(temp.getVal());
        temp = temp.mynext;
        while (temp != head) {
            stuff.add(temp.getVal());
            temp = temp.mynext;
        }
        return stuff.iterator();
    }

    public double avg() {
        Node temp = head;
        double total = 0.0;
        total += temp.getVal();
        temp = temp.mynext;
        while (temp != head) {
            total += temp.getVal();
            temp = temp.mynext;
        }
        return total / (double)getCount();
    }

    public int getMax() {
        Node temp = head;
        int max = 0;
        if (temp.getVal() > max) { max = temp.getVal(); }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() > max) { max = temp.getVal(); }
            temp = temp.mynext;
        }
        return max;
    }

    public int getMin() {
        Node temp = head;
        int min = temp.getVal();
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() < min) { min = temp.getVal(); }
            temp = temp.mynext;
        }
        return min;
    }

    public int findSlotMaxFirst() {
        Node temp = head;
        int data = this.getMax();
        int pos = 0;
        if (temp.getVal() == data) { return pos; }
        temp = temp.mynext;
        ++pos;
        while (temp != head) {
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
        temp = temp.mynext;
        ++pos;
        while (temp != head) {
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
        int count = 0;
        while (head.getVal() == 58) {
            head.mynext.myprev = head.myprev;
            head.myprev.mynext = head.mynext;
            head = head.mynext;
            ++count;
        }
        Node temp = head.mynext;
        while (temp != head) {
            if (temp.getVal() == 58) {
                temp.mynext.myprev = temp.myprev;
                temp.myprev.mynext = temp.mynext;
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public int getEvenCount() {
        Node temp = head;
        int count = 0;
        if (temp.getVal() % 2 == 0) {
            ++count;
        }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() % 2 == 0) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    //fix
    public void killOdds() {
        while (head.getVal() % 2 == 1) {
            head.mynext.myprev = head.myprev;
            head.myprev.mynext = head.mynext;
            head = head.mynext;
        }
        Node temp = head.mynext;
        while (temp != head) {
            if (temp.mynext.getVal() % 2 == 1) {
                temp.mynext.myprev = temp.myprev;
                temp.myprev.mynext = temp.mynext;
            }
            temp = temp.mynext;
        }
    }

    public void print() {
        System.out.println(head.getVal());
        Node temp = head.mynext;
        while (temp != head) {
            System.out.println(temp.getVal());
            temp = temp.mynext;
        }
    }
}