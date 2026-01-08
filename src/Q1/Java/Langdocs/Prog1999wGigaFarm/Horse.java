package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.Random;

public class Horse extends Animal {
    private String Name;
    private Double RiderCost;

    public double setIncome() {
        return 0.0;
    }

    public double setIncome(int Riders) {
        return RiderCost * Riders;
    }

    public Horse(String N) {
        String[] Const = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
        String[] Vowls =
        Random rand = new Random();
        Name = N;
        RiderCost = rand.nextDouble(7, 10.50);
        super("N/A", Generals.random(1500, 2000), Generals.random(2, 4), Generals.random(1, 4), Generals.random(2, 5), Generals.random(2, 3));
        setCost();
        Income = 0;
    }
}
