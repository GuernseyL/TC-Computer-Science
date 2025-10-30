package Q1.Java.Langdocs.Prog1061h;

public class Node {
    private String myWord;
    public Node myNext;

    public Node(String word) {
        myWord = word;
        myNext = null;
    }

    public char getFirst() {
        return myWord.charAt(0);
    }

    public String getWord() {
        return myWord;
    }
}
