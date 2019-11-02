import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        double[] result = new double[a.length];
        Queue<Integer> queueMin = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        Queue<Integer> queueMax = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        });


        queueMax.add(a[0]);
        result[0] = a[0];
        queueMax.add(a[1]);
        queueMin.add(queueMax.remove());
        result[1] = (double) (a[0] + a[1]) / 2;
        for(int i = 2; i < a.length; i++) {
            if (i % 2 == 0) {
                if (a[i] > queueMin.peek()) {
                    queueMax.add(queueMin.remove());
                    queueMin.add(a[i]);
                } else {
                    queueMax.add(a[i]);
                }
                result[i] = queueMin.peek();
            } else {
                if (a[i] < queueMax.peek()) {
                    queueMin.add(queueMax.remove());
                    queueMax.add(a[i]);
                } else {
                    queueMin.add(a[i]);
                }
                result[i] = (double) (queueMin.peek() + queueMax.peek()) / 2;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
