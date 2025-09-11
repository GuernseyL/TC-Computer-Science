package Q1;
import java.util.*;
import java.io.*;

public class Prog410t {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/survey2.dat"));
        int[][] big = new int[3][50];
        while (file.hasNext()) {
            for (int c = 0; c < 25; ++c ) {
                for (int r = 0; r < 3; ++r ) {
                    int Add = file.nextInt();
                    big[r][c] = Add;
                }
                if (!file.hasNext()) { break; }
            }
        }
        file = new Scanner(new File("langdat/survey.dat"));
        int face = 0;
        for (int s = 0; s < 50; ++s ) {
            if (big[0][s] == 0) {
                    face = s;
                    break;
            }
        }
        while (file.hasNext()) {
            for (int c = face; c < 50; ++c ) {
                for (int r = 0; r < 3; ++r ) {
                    int Add = file.nextInt();
                    big[r][c] = Add;
                }
                if (!file.hasNext()) { break; }
            }
        }

        for (int s = 0; s < 50; ++s ) {
            if (big[0][s] == 0) {
                face = s;
                break;
            }
        }

        int[][] big2 = new int[3][face];
        for (int c = 0; c < face; ++c){
            for (int r = 0; r < 3; ++r){
                big2[r][c] = big[r][c];
            }
        }

        System.out.println("ID     Income   Members");

        for (int c = 0; c < face; ++c ) {
            for (int r = 0; r < 3; ++r ) {
                System.out.print(big2[r][c] + "    ");
            }
            System.out.println();
        }

        double aveInc = 0.0;

        for (int c = 0; c < face; ++c ) {
            aveInc += big[1][c];
        }

        aveInc /= face;

        System.out.printf("\nHouseholds with income exceeding an average income of %.2f\nID     Income   Members\n", aveInc);

        double total = 0;
        double poverty = 0;
        for (int c = 0; c < face; ++c ) {
            if (big2[1][c] > aveInc) {
                System.out.println(big[0][c] + "    " + big[1][c] + "    " + big[2][c]);
            }
            if (big2[1][c] < 3750.00 + (750.00 * (big2[2][c] - 2))) {
                ++poverty;
            }
            ++total;
        }
        System.out.println("\nPercent of households below poverty level = " + poverty / total);
    }
}
/*
ID     Income   Members
1041    12180    4
1062    13240    3
1327    19800    2
1483    22458    8
1900    17000    2
2112    18125    7
2345    15623    2
3210    3200    6
3600    6500    5
3601    11970    2
4725    8900    3
6217    10000    2
9280    6200    1
2497    12500    2
3323    13000    5
4521    18210    4
6789    8000    2
5476    6000    1
4423    16400    3
6587    25000    4
3221    10500    4
5555    15000    2
1085    19700    3
3097    20000    8
4480    23400    5
2065    19700    2
8901    13000    3

Households with income exceeding an average income of 14281.70
ID     Income   Members
1327    19800    2
1483    22458    8
1900    17000    2
2112    18125    7
2345    15623    2
4521    18210    4
4423    16400    3
6587    25000    4
5555    15000    2
1085    19700    3
3097    20000    8
4480    23400    5
2065    19700    2

Percent of households below poverty level = 0.037037037037037035
 */