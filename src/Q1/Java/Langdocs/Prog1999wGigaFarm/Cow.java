package Q1.Java.Langdocs.Prog1999wGigaFarm;
import Q1.Java.General.Generals;

public class Cow extends Animal {
    private int ID;
    private int Milk;

    public void setIncome() {
        return;
    }

    public double setIncome(Double Cost) {
        return Milk * Cost;
    }

    public Cow(String ID, Double FarmCost) {
        super(ID, Generals.random(1000, 1500), Generals.random(5, 8), Generals.random(1, 3), Generals.random(2, 5), Generals.random(1, 4));
        Milk = Generals.random(20, 100);
        setCost();
        Income = setIncome(FarmCost);
    }

    public int getID() { return ID; }
    public int getMilk() { return Milk; }
}
