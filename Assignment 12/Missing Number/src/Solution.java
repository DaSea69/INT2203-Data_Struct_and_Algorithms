import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> countNumberInArr = new TreeMap<>();

        Arrays.stream(arr).forEach(i -> {
            if (countNumberInArr.containsKey(i)) {
                countNumberInArr.replace(i, countNumberInArr.get(i) + 1);
            } else {
                countNumberInArr.put(i, 1);
            }
        });

        Arrays.stream(brr).forEach(i -> {
            if (countNumberInArr.containsKey(i) && countNumberInArr.get(i) > 0) {
                countNumberInArr.replace(i, countNumberInArr.get(i) - 1);
            } else {
                countNumberInArr.put(i, 1);
            }
        });

        List<Integer> setNumerMissing = new ArrayList<>();
        countNumberInArr.forEach((key, value) -> {
            if (value > 0) {
                setNumerMissing.add(key);
            }
        });

        return setNumerMissing.parallelStream().mapToInt(i -> i).toArray();
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
