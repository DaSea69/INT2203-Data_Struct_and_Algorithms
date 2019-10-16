import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int[] sumOfStack1 = new int[h1.length + 1];
        int[] sumOfStack2 = new int[h2.length + 1];
        int[] sumOfStack3 = new int[h3.length + 1];

        sumOfStack1[0] = 0;
        sumOfStack2[0] = 0;
        sumOfStack3[0] = 0;
        
        for(int i = 1; i <= h1.length; i++) {
            //sum[i] = sum[i - 1] + a[i]
            sumOfStack1[i] = sumOfStack1[i - 1] + h1[h1.length - (i - 1) - 1];
        }
        for(int i = 1; i <= h2.length; i++) {
            sumOfStack2[i] = sumOfStack2[i - 1] + h2[h2.length - (i - 1) - 1];
        }
        for(int i = 1; i <= h3.length; i++) {
            sumOfStack3[i] = sumOfStack3[i - 1] + h3[h3.length - (i - 1) - 1]; 
        }

        int i = sumOfStack1.length - 1;
        int j = sumOfStack2.length - 1;
        int k = sumOfStack3.length - 1;
        while (i > 0) {
            while(j > 0 && sumOfStack2[j] > sumOfStack1[i]) {
                j--;
            } 
            while(k > 0 && sumOfStack3[k] > sumOfStack1[i]) {
                k--;
            }
            if (sumOfStack1[i] == sumOfStack2[j] && sumOfStack1[i] == sumOfStack3[k]) {
                return sumOfStack1[i];
            }
            else {
                i--;
            }
        }
        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
