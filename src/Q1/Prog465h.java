package Q1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Prog465h {
    public static void main(String[] args) throws IOException {
        Scanner File = new Scanner(new File("langdat/prog465h.dat"));
            while (File.hasNextLine()) {
                int[][] big = new int[File.nextInt()][File.nextInt()];
                int total = 0;
                for (int r = 0; r < big.length; ++r) {
                    for (int c = 0; c < big[0].length; ++c) {
                        big[r][c] = File.nextInt();
                        if (big[r][c] > 0) {
                            ++total;
                        }
                    }
                }

                int[][] compressed = new int[total][3];

                System.out.println("Original Matrix");
                for (int r = 0; r < big.length; ++r) {
                    for (int c = 0; c < big[0].length; ++c) {
                        System.out.print(big[r][c] + " ");
                    }
                    System.out.println();
                }

                if (total * 3 > big.length * big[0].length) {
                    System.out.println("The Original Matrix is Abundant");
                }

                int comRow = 0;
                for (int r = 0; r < big.length; ++r) {
                    for (int c = 0; c < big[0].length; ++c) {
                        if (big[r][c] > 0) {
                            compressed[comRow][0] = r + 1;
                            compressed[comRow][1] = c + 1;
                            compressed[comRow][2] = big[r][c];
                            ++comRow;
                        }
                    }
                }

                for (int r = 0; r < compressed.length; ++r) {
                    for (int c = 0; c < compressed[0].length; ++c) {
                        System.out.print(compressed[r][c] + " ");
                    }
                    System.out.println();
                }

                if (total * 3 < big.length * big[0].length) {
                    System.out.println("The Original Matrix is Sparse");
                } else if (total * 3 == big.length * big[0].length) {
                    System.out.println("The Original Matrix and the Sparse Matrix " +
                            "Equally Efficient");
                }
            }
    }
}


/*
Original Matrix
0 0 7 0 0 0
0 0 0 0 -8 0
0 0 0 0 0 0
2 0 0 0 0 0
0 0 0 0 0 0
1 3 7
4 1 2
The Original Matrix is Sparse
Original Matrix
0 2 0 3 0 1
8 0 4 0 1 0
0 3 0 1 0 -7
5 0 9 0 6 0
0 2 0 -1 0 7
The Original Matrix is Abundant
1 2 2
1 4 3
1 6 1
2 1 8
2 3 4
2 5 1
3 2 3
3 4 1
4 1 5
4 3 9
4 5 6
5 2 2
5 6 7
Original Matrix
0 0 1 0 0 2
3 0 0 4 0 0
0 0 5 0 0 6
7 0 0 8 0 0
0 0 9 0 0 1
1 3 1
1 6 2
2 1 3
2 4 4
3 3 5
3 6 6
4 1 7
4 4 8
5 3 9
5 6 1
The Original Matrix and the Sparse Matrix Equally Efficient
 */
