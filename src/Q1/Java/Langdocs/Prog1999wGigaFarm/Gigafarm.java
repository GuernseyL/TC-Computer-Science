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

    public Map<String, Cow> getCowMap() {
        return CowMap;
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

    public int getHay() {
        int TotalHay = 0;
        for (String Cow : CowMap.keySet()) {
            TotalHay += CowMap.get(Cow).getHay();
        }
        TotalHay += Horses.getHay();
        return TotalHay;
    }

    public int getCorn() {
        int TotalCorn = 0;
        for (String Cow : CowMap.keySet()) {
            TotalCorn += CowMap.get(Cow).getCornCobs();
        }
        for (Turkey Turkey : Turkeys) {
            TotalCorn += Turkey.getCornCobs();
        }
        for (Pig Pig : Pigs) {
            if (Pig != null) {
                TotalCorn += Pig.getCornCobs();
            }
        }
        TotalCorn += Horses.getCobs();
        return TotalCorn;
    }

    public int getBeans() {
        int TotalBeans = 0;
        for (String Cow : CowMap.keySet()) {
            TotalBeans += CowMap.get(Cow).getBeans();
        }
        for (Pig Pig : Pigs) {
            if (Pig != null) {
                TotalBeans += Pig.getBeans();
            }
        }
        TotalBeans += Horses.getBeans();
        return TotalBeans;
    }

    public int getOats() {
        int TotalOats = 0;
        for (String Cow : CowMap.keySet()) {
            TotalOats += CowMap.get(Cow).getOats();
        }
        for (Turkey Turkey : Turkeys) {
            TotalOats += Turkey.getOats();
        }
        for (Pig Pig : Pigs) {
            if (Pig != null) {
                TotalOats += Pig.getOats();
            }
        }
        TotalOats += Horses.getOats();
        return TotalOats;
    }

    public void Feed() {
        int TotalHayBales = 0;
        int TotalCornCobs = 0;
        int TotalBeans = 0;
        int TotalOats = 0;

        TotalHayBales = getHay();
        TotalCornCobs = getCorn();
        TotalBeans = getBeans();
        TotalOats = getOats();
        for (String cow : CowMap.keySet()) {
            //CowMap.get(cow).addWeight();
        }
        for (Turkey turkey : Turkeys) {
            //turkey.addWeight();
            turkey.setIncome();
        }
        for (Pig pig : Pigs) {
            if (pig != null) {
                //pig.addWeight();
                pig.setIncome();
            }
        }
        //Horses.addWeight();

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

    public int getCowWeight() {
        int Weight = 0;
        for (String Cow : CowMap.keySet()) {
            Weight += CowMap.get(Cow).getWeight();
        }
        return Weight;
    }

    public int getPigWeight() {
        int Weight = 0;
        for (Pig pig : Pigs) {
            if (pig != null) {
                Weight += pig.getWeight();
            }
        }
        return Weight;
    }

    public int getTurkeyWeight() {
        int Weight = 0;
        for (Turkey turkey : Turkeys) {
            Weight += turkey.getWeight();
        }
        return Weight;
    }

    public int getHorsesWeight() {
        return Horses.getWeights();
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

    public void getBest() {
        Gigafarm GF = this;
        for (int W = 0; W < Month.length; ++W) {
            for (int D = 0; D < Month[W].length; ++D) {
                Feed();
            }
        }

        double CowProfit = getCowIncome() - getCowCost();
        double PigProfit = getPigIncome() - getPigCost();
        double TurkeyProfit = getTurkeyIncome() - getTurkeyCost();
        double x = Horses.getIncome(Month);
        double HorseProfit = x - Horses.getCost();

        double BestProfit = Math.max(CowProfit, PigProfit);
        BestProfit = Math.max(BestProfit, TurkeyProfit);
        BestProfit = Math.max(BestProfit, HorseProfit);

        if (BestProfit == CowProfit) {
            System.out.println("Cows produce the most amount of profit on this farm");
        }

        else if (BestProfit == PigProfit) {
            System.out.println("Pigs produce the most amount of profit on this farm");
        }

        else if (BestProfit == TurkeyProfit) {
            System.out.println("Turkeys produce the most amount of profit on this farm");
        }

        else if (BestProfit == HorseProfit) {
            System.out.println("Horses produce the most amount of profit on this farm");
        }
    }

    public void getMilkPounds() {
        int milk = 0;
        for (String Cow : CowMap.keySet()) {
            milk += CowMap.get(Cow).getMilk() * 21;
        }
        System.out.println("Cows produce " + milk + " pounds of milk on this farm");
    }

    public void getTurkeyWeightPrint() {
        System.out.println("Turkeys weigh a total of " + getTurkeyWeight() + " pounds on this farm");
    }

    public void getExpensiveCrop() {
        double CornCost = getCorn() * .19;
        double HayCost = getHay() * 2.25;
        double BeanCost = getBeans() * .07;
        double OatCost = getOats() * .04;
        double BigCost = Math.max(CornCost, HayCost);
        BigCost = Math.max(BigCost, BeanCost);
        BigCost = Math.max(BigCost, OatCost);

        if (BigCost == CornCost) {
            System.out.println("CornCobs are the most expensive on this farm");
        }
        else if (BigCost == HayCost) {
            System.out.println("HayBales are the most expensive on this farm");
        }
        else if (BigCost == BeanCost) {
            System.out.println("Beans are the most expensive on this farm");
        }
        else if (BigCost == OatCost) {
            System.out.println("Oats are the most expensive on this farm");
        }
    }

    public void CostForFeedOneDay() {
        double cost = 0;
        cost += getCorn() * .19;
        cost += getHay() * 2.25;
        cost += getBeans() * .07;
        cost += getOats() * .04;

        System.out.println("Cost for feeding one day: " + cost);
    }

    public double TotalIncome() {
        double Income = 0;
        Income += getCowIncome();
        Income += getPigIncome();
        Income += getTurkeyIncome();
        Income += getHorseIncome();

        return Income;
    }

    public double TotalCost() {
        double cost = 0;
        for (int D = 1; D <= 21; ++D) {
            cost += getCorn() * .19;
            cost += getHay() * 2.25;
            cost += getBeans() * .07;
            cost += getOats() * .04;
        }

        return cost;
    }

    public void Profit() {
        System.out.println("Profit: " + (TotalIncome()-TotalCost()));
    }

    public Cow LeastProfitableCow() {
        String key = CowMap.keySet().iterator().next();
        Cow wow = CowMap.get(key);
        for (String keys : CowMap.keySet()) {
            if (wow.getProfit() > CowMap.get(keys).getProfit()) {
                wow = CowMap.get(keys);
            }
        }
        return wow;
    }

    public void RemoveCow(Cow cow) {
        String key = "";
        for (String keys : CowMap.keySet()) {
            if (cow == CowMap.get(keys)) {
                key = keys;
            }
        }
        CowMap.remove(key);
    }

    public void RemovePigs(int LeftOver) {
        int count = 0;
        int index = 0;
        while (!(count == LeftOver)) {
            count = 0;
            for (int lcv = 0; lcv < Pigs.length; ++lcv) {
                if (Pigs[lcv] != null) {
                    ++count;
                    index = lcv;
                }
            }
            Pig pig = Pigs[index];
            for (int lcv = 0; lcv < Pigs.length; ++lcv) {
                if (Pigs[lcv] != null) {
                    if (Pigs[lcv].getProfit() < pig.getProfit()) {
                        pig = Pigs[lcv];
                        index = lcv;
                    }
                }
            }
            Pigs[index] = null;
        }
    }

    public Turkey getWorstTurkey() {
        Turkey Worst = null;
        for (Turkey Turkey : Turkeys) {
            if (Worst == null) {
                Worst = Turkey;
            }
            else {
                if (Worst.getProfit() > Turkey.getProfit()) {
                    Worst = Turkey;
                }
            }
        }
        return Worst;
    }

    public void TurkeySellWorsts() {
        int Size = (Turkeys.size()/2) + 1;
        while (Turkeys.size() != Size) {
            Turkeys.remove(getWorstTurkey());
        }
    }

    public void TotalWeight() {
        System.out.println("The animals weigh a total of " + getCowWeight() + getPigWeight() + getTurkeyWeight() + getHorsesWeight() + " pounds.");
    }

    public void RemoveTwoHeavyCows() {
        String HeavyKeyA = "";
        String HeavyKeyB = "";
        for (String keys : CowMap.keySet()) {
            if (HeavyKeyA.equals("")) {
                HeavyKeyA = keys;
            }
            else if (HeavyKeyB.equals("")) {
                HeavyKeyB = keys;
                if (CowMap.get(HeavyKeyA).getWeight() < CowMap.get(HeavyKeyB).getWeight()) {
                    String temp = HeavyKeyA;
                    HeavyKeyA = HeavyKeyB;
                    HeavyKeyB = temp;
                }
            }
            else {
                if (CowMap.get(keys).getWeight() > CowMap.get(HeavyKeyA).getWeight()) {
                    HeavyKeyB = HeavyKeyA;
                    HeavyKeyA = keys;
                }
            }
        }
        CowMap.remove(HeavyKeyA);
        CowMap.remove(HeavyKeyB);
    }

    public Prog1999wHorseLinkedList getHorses() {
        return Horses;
    }
}
