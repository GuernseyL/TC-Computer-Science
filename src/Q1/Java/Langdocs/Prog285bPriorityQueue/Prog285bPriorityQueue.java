package Q1.Java.Langdocs.Prog285bPriorityQueue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

import java.util.Scanner;

public class Prog285bPriorityQueue {
    public static void main(String[] args) throws IOException {
        Scanner FILE = new Scanner(new File("langdat/Prog285b.txt"));
        ArrayDeque<Com>[] ArrayDeque = new ArrayDeque[20];
        for (int i = 0; i < ArrayDeque.length; i++) {
            ArrayDeque[i] = new ArrayDeque();
        }
        while (FILE.hasNextLine()) {
            Com data = new Com(FILE.nextInt(), FILE.nextInt(), FILE.nextDouble());
            ArrayDeque[data.getmyCode()].add(data);
        }
        for (int i = 0; i < ArrayDeque.length; i++) {
            for (Com data : ArrayDeque[i]) {
                data.calc();
                if (data.getmycommission() != 0) {
                    System.out.print(data.toString());
                    System.out.println();
                }
            }
        }

    }
}
/*
103	5	4000.0	3000.0
125	5	6500.0	502.5
218	5	5000.0	3750.0
235	5	5250.0	396.25
118	8	7350.0	574.75
192	8	8125.0	640.625
203	8	3250.0	2437.5
101	17	2250.0	213.75
138	17	6375.0	605.625
264	17	4150.0	394.25
291	17	750.0	71.25
 */
