import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static class Vertex {
        private int i;
        private int j;

        public Vertex(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return String.format("(%d %d)", this.i, this.j);
        }
    }

    static int findSizeOfRegion(int n, int m, int[][] matrix, Vertex vertex) {
        int countCellConnected = 0;
        Queue<Vertex> vertexNotMarked =  new ArrayDeque<>();

        vertexNotMarked.add(vertex);
        countCellConnected++;
        matrix[vertex.i][vertex.j] = 0;

        while (!vertexNotMarked.isEmpty()) {
            Vertex currentVertex = vertexNotMarked.remove();
            for (int i = -1; i <= 1 ; i++) {
                for (int j = -1; j <= 1; j++) {
                    final int nextI = currentVertex.i + i;
                    final int nextJ = currentVertex.j + j;
                    if (nextI >= 0 && nextI < n
                    && nextJ >= 0 && nextJ < m
                    && matrix[nextI][nextJ] == 1) {
                        countCellConnected++;
                        vertexNotMarked.add(new Vertex(nextI, nextJ));
                        matrix[nextI][nextJ] = 0;
                    }
                }
            }
        }
        return countCellConnected;
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sizeRegionMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    sizeRegionMax = Math.max(sizeRegionMax, findSizeOfRegion(n, m, matrix, new Vertex(i, j)));
                }
            }
        }
        return sizeRegionMax;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        int result = connectedCell(matrix);

        System.out.println(result);

        scanner.close();
    }
}
