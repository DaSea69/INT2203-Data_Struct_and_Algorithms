import java.util.Arrays;

import edu.princeton.cs.algs4.*;
public class ThreeSum {

    private ThreeSum() { }

    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    } 


    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        Arrays.sort(a);
        int[] result = new int[a.length];

        for(int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            Arrays.fill(result, 0);
            while (l < r) {
                if (a[l] == a[l - 1]) {
                    result[l] = result[l - 1];
                }
                if (a[i] + a[l] + a[r] == 0) {
                    result[l]++;
                    r = r - 1;
                }
                else if (a[i] + a[l] + a[r] > 0) {
                    r = r - 1;
                }
                else {
                    l = l + 1;
                }
            }
            for(int x : result) {
                count += x;
            }
        }
        return count;
    } 

    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    } 
} 
