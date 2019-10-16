import java.util.Stack;

class Pair {
    final int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class QuickSort {
    private static void exchange(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void sort(int[] arr) {
        
        Stack<Pair> segmentToSort = new Stack<Pair>();
        segmentToSort.push(new Pair(0, arr.length - 1));
        while (!segmentToSort.isEmpty()) {
            Pair segment = segmentToSort.pop();
            int lo = segment.first;
            int hi = segment.second;

            int i = lo;
            int j = hi;

            do {
                int midValue = arr[(lo + hi) / 2];
                while (arr[i] < midValue) {
                    i++;
                }
                while (arr[j] > midValue) {
                    j--;
                }
                if (i <= j) {
                    exchange(arr, i, j);
                    i++;
                    j--;
                }
            } while (i <= j);

            if (lo < j) {
                segmentToSort.push(new Pair(lo, j));
            }
            if (hi > i) {
                segmentToSort.push(new Pair(i, hi));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 9, 8, 2, 1 };
        sort(arr);
        for (int x : arr) {
            System.out.printf("%d ", x);
        }
    }
}