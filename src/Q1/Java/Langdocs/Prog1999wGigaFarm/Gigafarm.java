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
    private Double MilkCost;
    private Map<Integer, Cow> CowMap;

    public Gigafarm() {
        Random rand = new Random();
        CornCobs = Generals.random(10000, 15000);
        HayBales = Generals.random(2000, 3000);
        Beans = Generals.random(750, 1000);
        Oats = Generals.random(1750, 2500);
        MilkCost = rand.nextDouble(.20, .24);
        int Cows = Generals.random(12, 15);
        Set<Integer> CowIDs = new HashSet<>(Cows);
        while (CowIDs.size() < Cows) {
            CowIDs.add(Generals.random(1000, 9999));
        }
        for (Integer ID : CowIDs) {
            CowMap.put(ID, new Cow(ID, MilkCost));
        }
        int TurkMax = Generals.random(10, 20);
        Set<Turkey> Turkeys = new HashSet<>(TurkMax);
        while (Turkeys.size() < TurkMax) {

        }
    }
}
