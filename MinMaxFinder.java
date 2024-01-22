import java.util.Scanner;

public class MinMaxFinder {

    static class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static Pair findMinMax(int[] arr, int low, int high) {
        if (low == high) {
            // Base case: Only one element in the array
            return new Pair(arr[low], arr[low]);
        } else if (high - low == 1) {
            // Base case: Two elements in the array
            int min = Math.min(arr[low], arr[high]);
            int max = Math.max(arr[low], arr[high]);
            return new Pair(min, max);
        } else {
            // Divide the array into two halves
            int mid = (low + high) / 2;

            // Recursively find the min and max in each half
            Pair leftPair = findMinMax(arr, low, mid);
            Pair rightPair = findMinMax(arr, mid + 1, high);

            // Combine the results of the two halves
            int overallMin = Math.min(leftPair.min, rightPair.min);
            int overallMax = Math.max(leftPair.max, rightPair.max);

            return new Pair(overallMin, overallMax);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Pair result = findMinMax(arr, 0, n - 1);

        System.out.println("Minimum element: " + result.min);
        System.out.println("Maximum element: " + result.max);

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
