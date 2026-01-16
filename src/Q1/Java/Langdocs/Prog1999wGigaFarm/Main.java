package Q1.Java.Langdocs.Prog1999wGigaFarm;

import java.util.ArrayList;
import java.util.Map;
import Q1.Java.General.Generals;

public class Main {
    public static void main(String[] args) {
        Generals General = new Generals();
        Gigafarm[] GigaFarms = new Gigafarm[5];
        for (int Gigafarm = 0; Gigafarm <= 4; ++Gigafarm){
            GigaFarms[Gigafarm] = new Gigafarm();
        }
        int x = 1;
        for (Gigafarm GigaFarm : GigaFarms) {
            System.out.println("On farm " + x + ":");
            GigaFarm.getBest();

            System.out.println();

            GigaFarm.getMilkPounds();

            System.out.println();

            GigaFarm.getTurkeyWeight();

            System.out.println();

            GigaFarm.getExpensiveCrop();

            System.out.println();

            GigaFarm.CostForFeedOneDay();

            System.out.println();

            System.out.println("Total Income: " + GigaFarm.TotalIncome());

            System.out.println();

            GigaFarm.Profit();

            System.out.println("\n\n");
            ++x;
        }
        Cow[] Cows = new Cow[5];
        x = 0;
        for (Gigafarm GigaFarm : GigaFarms) {
            Cows[x] = GigaFarm.LeastProfitableCow();
            ++x;
        }

        int deleted = 0;
        Boolean AllDeleted = false;
        Boolean[] Bools = new Boolean[5];
        for (int i = 0; i < 5; ++i) {
            Bools[i] = AllDeleted;
        }
        while (deleted < 7 && !AllDeleted) {
            if (deleted >= 7) {
                for (int i = 0; i < 5; ++i) {
                    AllDeleted = true;
                    if (!Bools[i]) {
                        AllDeleted = false;
                        GigaFarms[i].RemoveCow(Cows[i]);
                    }
                }
            }
            Cow wow = getLowestCow(Cows);
            int Index = IndexOfCow(Cows, wow);
            Bools[Index] = true;
            GigaFarms[Index].RemoveCow(Cows[Index]);
            Cows[Index] = GigaFarms[Index].LeastProfitableCow();
            ++deleted;
            AllDeleted = true;
            for (int i = 0; i < 5; ++i) {
                if (!Bools[i]) {
                    AllDeleted = false;
                }
            }
        }
    }

    public static Cow getLowestCow(Cow[] array) {
        Cow wow = array[0];
        for (Cow cow : array) {
            if (cow.getProfit() < wow.getProfit()) {
                wow = cow;
            }
        }
        return wow;
    }

    public static int IndexOfCow(Cow[] array, Cow wow) {
        int index = 0;
        for (Cow cow : array) {
            ++index;
            if (cow == wow) {
                return index;
            }
        }
        return -1;
    }
}