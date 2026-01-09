package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.Random;

public class Turkey extends Animal {
    private double Worth;

    public void setIncome() {
        Income = Worth * this.getWeight();
    }

    public Turkey(String ID) {
        Random rand = new Random();
        Worth = rand.nextDouble(.75, .99);
        super(ID, Generals.random(25, 35), Generals.random(1, 3), Generals.random(2, 4), 0, 0);
        setCost();
        setIncome();
    }
}
