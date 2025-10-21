package Q1.Prog1061h;

import java.util.ArrayList;

public class Lang1061hHelper {
    private Node myroot;

    public Lang1061hHelper() {
        myroot=null;
    }

    public void add(String word){
        Node spot = new Node(word);
        if (myroot == null) {
            myroot = spot;
        }
        else if (spot.getWord().compareTo(myroot.getWord()) <= 0) {
            spot.myNext=myroot;
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while (temp.myNext != null) {
                if (spot.getWord().compareTo(temp.getWord()) <= 0) {
                    spot.myNext = temp.myNext;
                    temp.myNext = spot;
                    return;
                }
                temp = temp.myNext;
            }
            temp.myNext = spot;
        }
    }

    public void Print() {
        Node temp = myroot;
        while (temp != null) {
            System.out.println(temp.getWord());
            temp = temp.myNext;
        }
    }

    public void remove(String word) {
        Node temp = myroot;
        if (temp == null) {
            return;
        }

        if (myroot.getWord().equals(word)) {
            myroot = myroot.myNext;
        }
        while (temp.myNext != null) {
            if (temp.myNext.getWord().equals(word)) {
                temp.myNext = temp.myNext.myNext;
            }
            temp = temp.myNext;
        }
    }
}

/*
CONST
IF
LONG



LONG



BREAK
LONG
CONTINUE
SHORT
WHILE
 */