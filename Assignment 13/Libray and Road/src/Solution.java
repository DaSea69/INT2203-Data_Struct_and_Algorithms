import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {
    static boolean[] marked;

    static long buildCity(int n, int c_lib, int c_road, List<Integer>[] cities, int u) {
        Queue<Integer> citiesBulding = new ArrayDeque<>();
        int countCites = 0;

        citiesBulding.add(u);
        marked[u] = true;
        countCites++;

        while (!citiesBulding.isEmpty()) {
            int city = citiesBulding.poll();

            for(Integer v: cities[city]) {
                if (!marked[v]) {
                    citiesBulding.add(v);
                    marked[v] = true;
                    countCites++;
                }
            }
        }
        if (c_lib > c_road) {
            return c_lib + c_road * (countCites - 1);
        } else {
            return c_lib * countCites;
        }
    }

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, List<Integer>[] cities) {
        long cost = 0;
        marked = new boolean[n + 1];
        Arrays.fill(marked, false);

        for (int i = 1; i <= n; i++) {
            if (!marked[i]) {
                cost += buildCity(n, c_lib, c_road, cities, i);
            }
        }
        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            List<Integer>[] cities = (List<Integer>[]) new LinkedList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                cities[i] = new LinkedList<>();
            }

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                // for (int j = 0; j < 2; j++) {
                //     int citiesItem = Integer.parseInt(citiesRowItems[j]);
                //     cities[i][j] = citiesItem;
                // }
                int u = Integer.parseInt(citiesRowItems[0]);
                int v = Integer.parseInt(citiesRowItems[1]);

                cities[u].add(v);
                cities[v].add(u);
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
