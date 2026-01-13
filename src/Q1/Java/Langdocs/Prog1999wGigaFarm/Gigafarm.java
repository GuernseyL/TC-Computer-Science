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
    private Map<String, Cow> CowMap = new HashMap<>();
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
            CornCobs.add(Cob);
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
            Node node = new Node();
            Horses.addfront(node);
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
            turkey.setIncome();
        }
        for (Pig pig : Pigs) {
            if (pig != null) {
                TotalCornCobs += pig.getCornCobs();
                TotalBeans += pig.getBeans();
                TotalOats += pig.getOats();
                pig.addWeight();
                pig.setIncome();
            }
        }
        TotalHayBales += Horses.getHay();
        TotalCornCobs += Horses.getCobs();
        TotalBeans += Horses.getBeans();
        TotalOats += Horses.getOats();
        Horses.addWeight();

        while (TotalHayBales > HayBales.getLast()) {
            int Bale = HayBales.pop();
            TotalHayBales -= Bale;
        }
        int LastBale = HayBales.pop() - TotalHayBales;
        HayBales.push(TotalHayBales);
        while (TotalCornCobs > CornCobs.peek()) {
            int Cob = CornCobs.poll();
            TotalCornCobs -= Cob;
        }
        int LastCob = CornCobs.poll() - TotalCornCobs;
        CornCobs.add(LastCob);
        Beans -= TotalBeans;
        Oats -= TotalOats;
    }

    public double getCowCost() {
        double Cost = 0;
        for (String cow :  CowMap.keySet()) {
            Cost += CowMap.get(cow).getCost();
        }
        return Cost;
    }

    public double getPigCost() {
        double Cost = 0;
        for (Pig pig : Pigs) {
            if (pig != null) {
                Cost += pig.getCost();
            }
        }
        return Cost;
    }

    public double getTurkeyCost() {
        double Cost = 0;
        for (Turkey turkey : Turkeys) {
            Cost += turkey.getCost();
        }
        return Cost;
    }

    public double getHorseCost() {
        return Horses.getCost();
    }

    public double getCost() {
        double TotalCost = 0;
        TotalCost += getCowCost();
        TotalCost += getPigCost();
        TotalCost += getTurkeyCost();
        TotalCost += Horses.getCost();
        return TotalCost;
    }

    public double getCowIncome() {
        double Income = 0;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                for (String cow : CowMap.keySet()) {
                    Income += CowMap.get(cow).getIncome();
                }
            }
        }
        return Income;
    }

    public double getPigIncome() {
        double Income = 0;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                for (Pig pig : Pigs) {
                    if (pig != null) {
                        Income += pig.getIncome();
                    }
                }
            }
        }
        return Income;
    }

    public double getTurkeyIncome() {
        double Income = 0;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                for (Turkey turkey : Turkeys) {
                    Income += turkey.getIncome();
                }
            }
        }
        return Income;
    }

    public double getHorseIncome() {
        return Horses.getIncome(Month);
    }

    public double getIncome() {
        double TotalIncome = 0;
        Gigafarm GF = this;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                GF.Feed();
            }
        }
        TotalIncome += GF.getCowIncome();
        TotalIncome += GF.getPigIncome();
        TotalIncome += GF.getTurkeyIncome();
        TotalIncome += GF.Horses.getIncome(Month);
        return TotalIncome;
    }

    public double getProft() {
        return getIncome() - getCost();
    }

    public void getWorthless() {
        Gigafarm GF = this;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                Feed();
            }
        }

        double CowProfit = getCowIncome() - getCowCost();
        double PigProfit = getPigIncome() - getPigCost();
        double TurkeyProfit = getTurkeyIncome() - getTurkeyCost();
        double HorseProfit = Horses.getIncome(Month) - Horses.getCost();

        double LeastProfit = Math.min(CowProfit, PigProfit);
        LeastProfit = Math.min(LeastProfit, TurkeyProfit);
        LeastProfit = Math.min(LeastProfit, HorseProfit);

        if (LeastProfit == CowProfit) {
            System.out.println("Cows produce the least amount of profit on this farm");
        }

        else if (LeastProfit == PigProfit) {
            System.out.println("Pigs produce the least amount of profit on this farm");
        }

        else if (LeastProfit == TurkeyProfit) {
            System.out.println("Turkeys produce the least amount of profit on this farm");
        }

        else if (LeastProfit == HorseProfit) {
            System.out.println("Horses produce the least amount of profit on this farm");
        }
    }

    public Prog1999wHorseLinkedList getHorses() {
        return Horses;
    }
}
