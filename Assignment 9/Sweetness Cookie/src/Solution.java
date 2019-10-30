import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        Queue<Integer> minQueue = new PriorityQueue<Integer>(A.length);
        int numberOfOperation = 1;

        for(int x: A) {
            minQueue.add(x);
        }


        while (minQueue.size() > 1) {
            int m1 = minQueue.poll();
            int m2 = minQueue.poll();
            if (m1 + 2 * m2 < k) {
                numberOfOperation++;
                minQueue.add(m1 + 2 * m2);
            } else {
                return numberOfOperation;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
