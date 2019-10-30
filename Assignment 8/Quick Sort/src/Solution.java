import java.io.*;
import java.util.*;

public class Solution {

    public static void printArr(int[] arr) {
        for(int x: arr) {
            System.out.printf("%d ", x);
        }
        System.out.println();
    }

    public static void exchange(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    protected static int partion(int[] arr, int lo, int  hi) {
        if (lo >= hi) {
            return lo;
        }
        int p = arr[hi];
        int i = lo;
        for(int j = lo; j <= hi - 1; j++) {
            if (arr[j] <= p) {
                exchange(arr, i, j);
                i++;
            }
        }
        exchange(arr, i, hi);
        printArr(arr);
        return i;
    }

    public static void quickSort(int arr[], int lo, int hi) {
        // arr[lo...hi]
        if (lo < hi) {
            int p = partion(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElement = scanner.nextInt();
        int[] arr = new int[numberOfElement];
        for(int i = 0; i < numberOfElement; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(arr, 0, numberOfElement - 1);
        scanner.close();
    }
}

