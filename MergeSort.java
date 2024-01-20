import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + arrayToString(array));

        mergeSort(array);

        System.out.println("Sorted array: " + arrayToString(array));
    }

    public static void mergeSort(int[] array) {
        int n = array.length;

        if (n > 1) {
            int mid = n / 2;

            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            // Copy elements to leftArray
            for (int i = 0; i < mid; i++) {
                leftArray[i] = array[i];
            }

            // Copy elements to rightArray
            for (int i = mid; i < n; i++) {
                rightArray[i - mid] = array[i];
            }

            // Recursively sort the two halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(array, leftArray, rightArray);
        }
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
