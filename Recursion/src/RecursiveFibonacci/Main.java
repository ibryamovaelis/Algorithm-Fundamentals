package RecursiveFibonacci;

import java.util.Scanner;

public class Main {
    public static long fibArray[] = new long[51];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        fibArray[0] = 1;
        fibArray[1] = 1;

        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        long fibValue = 0;
        if (n <= 1) {
            return 1;
        } else if (fibArray[n] != 0) {
            return fibArray[n];
        } else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            fibArray[n] = fibValue;
            return fibValue;
        }
    }
}
