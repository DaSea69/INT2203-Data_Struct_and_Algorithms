public class UnionFind {
    private int[] parent;
    private int[] size;
    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 0;
        }
    }

    private int root(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (size[i] < size[j]) {
            parent[i] = j;
            size[i] += size[j];
        }
        else {
            parent[j] = i;
            size[i] += size[j];
        }
    }
    public static void main(String[] args) {

    }
}