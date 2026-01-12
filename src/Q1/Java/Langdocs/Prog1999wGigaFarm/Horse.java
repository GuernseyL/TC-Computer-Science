package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.Random;

public class Horse extends Animal {
    private String Name;
    private Double RiderCost;

    public void setIncome() {
        Income = RiderCost;
    }

    public Horse() {
        Random rand = new Random();
        String[] Const = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
        String[] Vowels = {"a", "e", "i", "o", "u", "y"};
        RiderCost = rand.nextDouble(7, 10.50);
        super("N/A", Generals.random(1500, 2000), Generals.random(2, 4), Generals.random(1, 4), Generals.random(2, 5), Generals.random(2, 3));
        setCost();
        setIncome();
        for (int i = 1; i <= 4; i++) {
            if (i == 1) {
                Name = Const[rand.nextInt(Const.length)];
            }
            else if (i == 3) {
                Name += Vowels[rand.nextInt(Vowels.length)];
            }
            else {
                String Letter = Const[rand.nextInt(Const.length)];
                while (Name.contains(Letter)) {
                    Letter = Const[rand.nextInt(Const.length)];
                }
                Name += Letter;
            }
        }
        Income = 0;
    }
}
