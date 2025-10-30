package Q1.Java.Langdocs.Prog285b;

public class Node {
    private Com myperson;
    public Node mynext;

    public Node(Com peop){
        myperson=peop;
        mynext=null;
    }

    public Com getCom() {
        return myperson;
    }
}
