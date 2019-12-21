import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Set {
    private int root[];
    private int size[];
    private int count;
    
    public Set(int N) {
        this.count = 0;
        root = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
        Arrays.fill(size, 0);
    }

    public int count() {
        return this.count;
    }

    private int findRoot(int p) {
        while (p != root[p]) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int rootOfP = findRoot(p);
        int rootOfQ = findRoot(q);

        if (rootOfP == rootOfQ) {
            return ;
        }

        if (size[rootOfP] < size[rootOfQ]) {
            root[rootOfP] = rootOfQ;
            size[rootOfQ] += size[rootOfP];
        } else {
            root[rootOfQ] = rootOfP;
            size[rootOfP] += size[rootOfQ]; 
        }
    }

    public static void main(String[] args) {
        Set set = new Set(10);

        set.union(1, 2);
        set.union(2, 3);

        System.out.println(set.connected(1, 2));
        System.out.println(set.connected(1, 4));
    }
}

class Edge implements Comparable<Edge> {
    final int u;
    final int v;
    final int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge that) {
        return this.weight - that.weight;
    }
} 

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    static int result;
    static int numberEdge;
    public static int kruskals(int gNodes, List<Edge> egdes) {
        Set set = new Set(gNodes);
        result = 0;
        numberEdge = 0;
        egdes.stream().sorted().forEach(egde -> {
            if (numberEdge < gNodes - 1) {
                if (!set.connected(egde.u, egde.v)) {
                    result += egde.weight;
                    numberEdge++;
                    set.union(egde.u, egde.v);
                }
            }
        });

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(null));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Edge> egdes = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int u = Integer.parseInt(gFromToWeight[0]);
                int v = Integer.parseInt(gFromToWeight[1]);
                int weight = Integer.parseInt(gFromToWeight[2]);

                egdes.add(new Edge(u, v, weight));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, egdes);

        // Write your code here.

        System.out.println(res);

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
