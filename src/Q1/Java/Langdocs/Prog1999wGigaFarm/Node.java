package Q1.Java.Langdocs.Prog1999wGigaFarm;

public class Node {
    public  Node       myPrev;
    private Horse      myHorse;
    public  Node       myNext;

    public Node() {
        myPrev  = null;
        myHorse = new Horse();
        myNext  = null;
    }

    public Horse getHorse() {
        return myHorse;
    }
}
