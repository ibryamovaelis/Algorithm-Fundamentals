package BinomialCoefficientIterative;

import java.util.Scanner;

public class Main {
    public static long[][] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1][k + 1];

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= Math.min(row, k); col++) {
                if (col == 0 || col == row) {
                    memory[row][col] = 1;
                } else {
                    memory[row][col] = memory[row - 1][col] +  memory[row - 1][col - 1];
                }
            }
        }
        System.out.println(memory[n][k]);
    }
}
