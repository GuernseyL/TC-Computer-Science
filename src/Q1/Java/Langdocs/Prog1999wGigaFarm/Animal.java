package Q1.Java.Langdocs.Prog1999wGigaFarm;

public abstract class Animal {
    private double Cost;
    protected double Income;
    private int ID;
    private int Weight;
    private int CornCobs;
    private int Oats;
    private int Beans;
    private int Hay;


    public Animal(String ID, int W, int C, int O, int B, int H) {
        Weight = W;
        CornCobs = C;
        Oats = O;
        Beans = B;
        Hay = H;
    }

    public void setCost() {
        Cost = (2.25 * Hay) + (.19 * CornCobs) + (0.07 + Beans) + (0.04 * Oats);
    }

    public void addWeight() {
        Weight += Hay + CornCobs + Beans + Oats;
    }

    public abstract void setIncome();

    public int getID() { return ID; }
    public int getWeight() { return Weight; }
    public int getCornCobs() { return CornCobs; }
    public int getOats() { return Oats; }
    public int getBeans() { return Beans; }
    public int getHay() { return Hay; }

    public double getCost() { return Cost; }
    public double getIncome() { return Income; }
    public double getProfit() { return getCost() - getIncome(); }
}
