import java.util.Arrays;
import java.util.Scanner;

public class PermutationsWithRepetitionOptimisationInternet {
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");
        Arrays.sort(elements);

        permute(0, elements);
    }

    private static void permute(int start, String[] arr) {
        if (start >= arr.length - 1) {
            print(arr);
            return;
        }

        String prev = "*";

        for (int left = start; left < arr.length ; left++) {
            String[] temp = arr;

            if (left > start && temp[start].equals(temp[left])) {
                continue;
            }
            if (!prev.equals("*") && prev.equals(arr[left])) {
                continue;
            }

            temp = swap(temp, start, left);
            prev = arr[left];

            permute(start + 1, temp);
        }
    }

    private static String[] swap(String[] arr, int first, int second) {
        String firstElement = arr[first];
        arr[first] = arr[second];
        arr[second] = firstElement;
        return arr;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
