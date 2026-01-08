package Q1.Java.Langdocs.Prog1999wGigaFarm;

import Q1.Java.General.Generals;

import java.util.*;

public class Gigafarm {
    private Queue<Integer> CornCobs = new ArrayDeque<>();
    private Stack<Integer> HayBales = new Stack<>();
    private int Beans;
    private int Oats;
    private int[][] Month = new int[3][7];
    private Double MilkCost;
    private Map<String, Cow> CowMap;
    private Set<Turkey> Turkeys;
    private Pig[] Pigs = new Pig[20];
    private Prog1999wHorseLinkedList Horses = new Prog1999wHorseLinkedList();

    public Gigafarm() {
        Random rand = new Random();
        int StartingHayBales = Generals.random(2000, 3000);
        int StartingCornCobs = Generals.random(10000, 15000);
        while (TotalBales() < StartingHayBales) {
            int Bale = Generals.random(75, 100);
            if (Bale + TotalBales() > StartingHayBales) {
                Bale = StartingHayBales -  TotalBales();
            }
            HayBales.push(Bale);
        }
        while (TotalCobs() < StartingCornCobs) {
            int Cob = Generals.random(1000, 1250);
            if (Cob + TotalCobs() > StartingCornCobs) {
                Cob = StartingCornCobs - TotalBales();
            }
            HayBales.push(Cob);
        }
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
            Horses.addfront(new Node(new Horse()));
        }
    }

    public int TotalBales() {
        int Sum = 0;
        for (Integer i : HayBales) {
            Sum += i;
        }
        return Sum;
    }

    public int TotalCobs() {
        int Sum = 0;
        for (Integer i : CornCobs) {
            Sum += i;
        }
        return Sum;
    }

    public void Feed() {
        int TotalHayBales = 0;
        int TotalCornCobs = 0;
        int TotalBeans = 0;
        int TotalOats = 0;
        for (String cow : CowMap.keySet()) {
            TotalHayBales += CowMap.get(cow).getHay();
            TotalCornCobs += CowMap.get(cow).getCornCobs();
            TotalBeans += CowMap.get(cow).getBeans();
            TotalOats += CowMap.get(cow).getOats();
            CowMap.get(cow).addWeight();
        }
        for (Turkey turkey : Turkeys) {
            TotalHayBales += turkey.getHay();
            TotalCornCobs += turkey.getCornCobs();
            turkey.addWeight();
        }
        for (Pig pig : Pigs) {
            if (pig != null) {
                TotalCornCobs += pig.getCornCobs();
                TotalBeans += pig.getBeans();
                TotalOats += pig.getOats();
                pig.addWeight();
            }
        }
        TotalHayBales += Horses.getHay();
        TotalCornCobs += Horses.getCobs();
        TotalBeans += Horses.getBeans();
        TotalOats += Horses.getOats();
    }
}
