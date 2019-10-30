import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void exchange(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static int partion(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1;
        int j = hi;
        do 
        {
            while (arr[i] < pivot) i++;
            while (pivot < arr[j]) j--;
            if (i <= j) {
                exchange(arr, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        exchange(arr, lo, j);
        return j;
    }
    // Complete the findMedian function below.
    static int findMedian(int[] arr) {
        int n = arr.length / 2;
        int lo = 0;
        int hi = arr.length - 1;
        int mid;
        do
        {
            mid = partion(arr, lo, hi);
            if (mid < n) {

            } else if (mid > n) {

            }

        } while (mid != n);
        return mid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
