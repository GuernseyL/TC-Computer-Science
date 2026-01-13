package Q1.Java.Langdocs.Prog1999wGigaFarm;

import java.util.Arrays;

public class Prog1999wHorseLinkedList {
    private Node myroot;

    public Prog1999wHorseLinkedList() {
        myroot = null;
    }

    public void addfront(Node node) {
        if (myroot == null) {
            myroot = node;
            myroot.myNext = myroot;
            myroot.myPrev = myroot;
        } else {
            node.myNext = myroot;
            myroot.myPrev = node;
            Node temp = myroot.myNext;
            while (temp.myNext != myroot) {
                temp = temp.myNext;
            }
            temp.myNext = node;
            temp.myNext.myPrev = temp;
        }
    }

    public void print() {
        System.out.println(myroot);
        Node temp = myroot.myNext;
        while (temp != myroot) {
            System.out.println(temp);
            temp = temp.myNext;
        }
    }

    public int getHay() {
        int Hay = 0;
        Node temp = myroot.myNext;
        while (temp != myroot) {
            Hay += temp.getHorse().getHay();
            temp = temp.myNext;
        }
        Hay += temp.getHorse().getHay();
        return Hay;
    }

    public int getOats() {
        int Oats = 0;
        Node temp = myroot.myNext;
        while (temp != myroot) {
            Oats += temp.getHorse().getOats();
            temp = temp.myNext;
        }
        Oats += temp.getHorse().getOats();
        return Oats;
    }

    public int getBeans() {
        int Beans = 0;
        Node temp = myroot.myNext;
        while (temp != myroot) {
            Beans += temp.getHorse().getBeans();
            temp = temp.myNext;
        }
        Beans += temp.getHorse().getBeans();
        return Beans;
    }

    public int getCobs() {
        int Cobs = 0;
        Node temp = myroot.myNext;
        while (temp != myroot) {
            Cobs += temp.getHorse().getCornCobs();
            temp = temp.myNext;
        }
        Cobs += temp.getHorse().getCornCobs();
        return Cobs;
    }

    public void addWeight() {
        Node temp = myroot.myNext;
        while (temp != myroot) {
            temp.getHorse().addWeight();
            temp = temp.myNext;
        }
        temp.getHorse().addWeight();
    }

    public double getCost() {
        Node temp = myroot.myNext;
        double Cost = 0;
        while (temp != myroot) {
            Cost += temp.getHorse().getCost();
            temp = temp.myNext;
        }
        Cost += temp.getHorse().getCost();
        return Cost;
    }

    public double getIncome(int[][] month) {
        double TotIncome = 0;
        for (int lcvA = 0; lcvA < month.length; lcvA++) {
            for (int lcvB = 0; lcvB < month[lcvA].length; lcvB++) {
                Node temp = myroot;
                while (month[lcvA][lcvB] > 0) {
                    TotIncome += temp.getHorse().getIncome();
                    month[lcvA][lcvB]--;
                    temp = temp.myNext;
                }
            }
        }
        return TotIncome;
    }

    public void getNames() {
        Node temp = myroot.myNext;
        while (temp != myroot) {
            System.out.println(temp.getHorse().getName());
            temp = temp.myNext;
        }
    }

    public void printIncomes() {
        Node temp = myroot.myNext;
        while (temp != myroot) {
            System.out.println(temp.getHorse().getIncome());
            temp = temp.myNext;
        }
    }
}

