package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.Random;

public class Pig extends Animal {
    private double Worth;

    public double setIncome() {
        return Worth * this.getWeight();
    }

    public Pig() {
        Random rand = new Random();
        Worth = rand.nextDouble(2.25, 2.75);
        super("N/A", Generals.random(250, 300), Generals.random(5, 10), Generals.random(10, 20), Generals.random(25, 50), 0);
        setCost();
        Income = setIncome();
    }
}
