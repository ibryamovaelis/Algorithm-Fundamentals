package Shuffling;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = {13, 15, 12, 24, 59};

        Arrays.sort(arr);

        for (int rand : arr) {
            System.out.print(rand + " ");
        }
    }

    private static void getAsRand(int[] arr) {
        int[] result = new int[arr.length];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, random.nextInt(arr.length));
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
