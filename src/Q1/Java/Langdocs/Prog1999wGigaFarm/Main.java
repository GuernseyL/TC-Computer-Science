package Q1.Java.Langdocs.Prog1999wGigaFarm;

public class Main {
    public static void main(String[] args) {
        Gigafarm[] GigaFarms = new Gigafarm[5];
        for (int Gigafarm = 0; Gigafarm <= 4; ++Gigafarm){
            GigaFarms[Gigafarm] = new Gigafarm();
        }
        int x = 1;
        for (Gigafarm GigaFarm : GigaFarms) {
            System.out.println("On farm " + x + ":");
            GigaFarm.getWorthless();
            System.out.println(GigaFarm.getHorseIncome());
            ++x;
            GigaFarm.getHorses().printIncomes();
        }
    }
}