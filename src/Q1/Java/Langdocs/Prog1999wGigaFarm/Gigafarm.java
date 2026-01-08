package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Gigafarm {
    private int CornCobs;
    private int HayBales;
    private int Beans;
    private int Oats;
    private int[][] Month = new int[3][7];
    private Double MilkCost;
    private Map<String, Cow> CowMap;
    private Set<Turkey> Turkeys;
    private Pig[] Pigs = new Pig[20];
    private Prog1999wHorseLinkedList Horses;

    public Gigafarm() {
        Random rand = new Random();
        CornCobs = Generals.random(10000, 15000);
        HayBales = Generals.random(2000, 3000);
        Beans = Generals.random(750, 1000);
        Oats = Generals.random(1750, 2500);
        MilkCost = rand.nextDouble(.20, .24);
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                if (D <= 4) {
                    Month[W][D] = Generals.random(1, 5);
                }
                else if (D <= 5) {
                    Month[W][D] = Generals.random(5, 10);
                }
                else if (D <= 6) {
                    Month[W][D] = Generals.random(3, 7);
                }
            }
        }
        int Cows = Generals.random(12, 15);
        Set<String> CowIDs = new HashSet<>(Cows);
        while (CowIDs.size() < Cows) {
            int CowIDA = (Generals.random(1000, 9999));
            String CowIDB;
            if (CowIDA < 10) {
                CowIDB = "000" +  CowIDA;
            }
            else if (CowIDA < 100) {
                CowIDB = "00" +  CowIDA;
            }
            else if (CowIDA < 1000) {
                CowIDB = "0" +  CowIDA;
            }
            else {
                CowIDB = "" +  CowIDA;
            }
            CowIDs.add(CowIDB);
        }
        for (String ID : CowIDs) {
            CowMap.put(ID, new Cow(ID, MilkCost));
        }
        int TurkMax = Generals.random(10, 20);
        Turkeys = new HashSet<>(TurkMax);
        while (Turkeys.size() < TurkMax) {
            int TurkeyIDA = (Generals.random(1000, 9999));
            String TurkeyIDB;
            if (TurkeyIDA < 10) {
                TurkeyIDB = "000" + TurkeyIDA;
            }
            else if (TurkeyIDA < 100) {
                TurkeyIDB = "00" + TurkeyIDA;
            }
            else if (TurkeyIDA < 1000) {
                TurkeyIDB = "0" + TurkeyIDA;
            }
            else {
                TurkeyIDB = "" + TurkeyIDA;
            }
            Turkeys.add(new Turkey(TurkeyIDB));
        }
        int PigMax = Generals.random(12, 20);
        for (int i = 0; i < PigMax; ++i) {
            Pigs[i] = new Pig();
        }

        int HorseMax = Generals.random(8, 10);
        for (int i = 0; i < HorseMax; ++i) {
            Horses.addfront(Horse);
        }
    }
}
