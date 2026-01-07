package Q1.Java.Langdocs.Prog1999wGigaFarm;
import Q1.Java.General.Generals;

public class Cow extends Animal {
    private int ID;
    private int Milk;

    public Cow(int ID) {
        this.ID = ID;
        super(Generals.random(1000, 1500), Generals.random(5, 8), Generals.random(1, 3), Generals.random(2, 5), Generals.random(1, 4));
        Milk = Generals.random(20, 100);
    }

    public int getID() { return ID; }
    public int getMilk() { return Milk; }
}
