package Q1.Java.Langdocs.Prog1999wGigaFarm;

public abstract class Animal {
    private double Cost;
    private double Income;
    private int Weight;
    private int CornCobs;
    private int Oats;
    private int Beans;
    private int Hay;


    public Animal(int W, int C, int O, int B, int H) {
        Weight = W;
        CornCobs = C;
        Oats = O;
        Beans = B;
        Hay = H;
    }

    public int getWeight() { return Weight; }
    public int getCornCobs() { return CornCobs; }
    public int getOats() { return Oats; }
    public int getBeans() { return Beans; }
    public int getHay() { return Hay; }

    public double getCost() { return Cost; }
    public double getIncome() { return Income; }
    public double getProfit() { return getCost() - getIncome(); }
}
