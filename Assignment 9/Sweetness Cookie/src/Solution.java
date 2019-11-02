import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int cookies(int k, int[] A) {
        Queue<Integer> minQueue = new PriorityQueue<Integer>(A.length);
        int numberOfOperation = 0;

        for(int x: A) {
            minQueue.add(x);
        }


        while (minQueue.size() > 1) {
            int m1 = minQueue.poll();
            int m2 = minQueue.poll();
            if (m1 < k) {
                numberOfOperation++;
                minQueue.add(m1 + 2 * m2);
            } else {
                return numberOfOperation;
            }
        }
        if (minQueue.size() > 0 && minQueue.peek() >= k) {
            return numberOfOperation;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

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

        System.out.println(result);

        scanner.close();
    }
}
