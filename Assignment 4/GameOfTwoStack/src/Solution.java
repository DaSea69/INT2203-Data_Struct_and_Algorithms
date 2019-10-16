import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int twoStacks(int x, int[] a, int[] b) {
        int sumOfA[] = new int[a.length + 1];
        int sumOfB[] = new int[b.length + 1];

        sumOfA[0] = 0;
        sumOfB[0] = 0;

        int result = 0;

        for(int i = 1; i <= a.length; i++) {
            /*map : i -> i + 1 */
            sumOfA[i] = sumOfA[i - 1] + a[i - 1];
        }
        for(int i = 1; i <= b.length; i++) {
            sumOfB[i] = sumOfB[i - 1] + b[i - 1];
        }

        int i = 1;
        int j = sumOfB.length - 1;

        while (i < sumOfA.length) {
            while (j > 0 && sumOfA[i] + sumOfB[j] > x) {
                j--;
            }
            int value = sumOfA[i] + sumOfB[j];
            if (value <= x && value > result) {
                result = value;
            }
            i++;
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
