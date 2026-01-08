package Q1.Java.Langdocs.Prog1999wGigaFarm;

public class Node {
    public  Node       myPrev;
    private Horse      Horse;
    public  Node       myNext;

    public Node(Horse Horse) {
        myPrev  = null;
        Horse = new Horse();
        myNext  = null;
    }

    public Horse getHorse() {
        return Horse;
    }
}
