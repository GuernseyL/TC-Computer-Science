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
        Node temp = myroot;
        while (temp != null) {
            Hay += temp.getHorse().getHay();
        }
        return Hay;
    }

    public int getOats() {
        int Oats = 0;
        Node temp = myroot;
        while (temp != null) {
            Oats += temp.getHorse().getOats();
            temp = temp.myNext;
        }
        return Oats;
    }

    public int getBeans() {
        int Beans = 0;
        Node temp = myroot;
        while (temp != null) {
            Beans += temp.getHorse().getBeans();
            temp = temp.myNext;
        }
        return Beans;
    }

    public int getCobs() {
        int Cobs = 0;
        Node temp = myroot;
        while (temp != null) {
            Cobs += temp.getHorse().getCornCobs();
            temp = temp.myNext;
        }
        return Cobs;
    }

    public void addWeight() {
        Node temp = myroot;
        while (temp != null) {
            temp.getHorse().addWeight();
            temp = temp.myNext;
        }
    }

    public double getCost() {
        Node temp = myroot;
        double Cost = 0;
        while (temp != null) {
            Cost += temp.getHorse().getCost();
            temp = temp.myNext;
        }
        return Cost;
    }

    public double getIncome(int[][] month) {
        double Income = 0;
        int[][] monthB = Arrays.copyOf(month, month.length);
        for (int lcvA = 0; lcvA < month.length; lcvA++) {
            for (int lcvB = 0; lcvB < month[lcvA].length; lcvB++) {
                Node temp = myroot;
                while (monthB[lcvA][lcvB] > 0) {
                    Income += temp.getHorse().getIncome();
                    monthB[lcvA][lcvB]--;
                    temp = temp.myNext;
                }
            }
        }
        return Income;
    }
}

