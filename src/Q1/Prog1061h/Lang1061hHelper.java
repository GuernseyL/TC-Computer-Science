package Q1.Prog1061h;

import java.util.ArrayList;

public class Lang1061hHelper {
    private Node myroot;

    public Lang1061hHelper(){
        myroot=null;
    }

    public void add(String word){
        Node spot = new Node(word);
        if (myroot == null) {
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while (temp.myNext != null) {
                if (spot.getWord().charAt(0) <= (temp.myNext.getWord().charAt(0))) {
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
        while (temp.myNext != null) {
            if (temp.myNext.getWord().equals(word)) {
                temp.myNext = temp.myNext.myNext;
            }
            temp = temp.myNext;
        }
    }

    public Lang1061hHelper sort(){
        if (myroot == null) {
            return this;
        }
        Node temp = myroot;
        ArrayList<String> words = new ArrayList<String>();
        while (temp != null) {
            words.add(temp.getWord());
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).compareTo(words.get(j)) <= 0) {
                    String beta = words.get(j);
                }
            }
        }

        return Lang1061hHelper;
    }
}
