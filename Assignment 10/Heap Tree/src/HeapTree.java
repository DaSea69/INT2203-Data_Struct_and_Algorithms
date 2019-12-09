/**
 * HeapTree
 */
public class HeapTree {
    private final int sizeMax;
    private int n;
    private final int[] nodes;

    public HeapTree(int sizeMax) {
        this.sizeMax = sizeMax;
        this.n = 1;
        nodes = new int[sizeMax + 1];
        
    }

    private void exch(int[] nodes, int i, int j) {
        int tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    private void upHeap(int k) {
        while (k > 1) {
            if (nodes[k] > nodes[k / 2]) {
                exch(nodes, k, k / 2);
            }
            k /= 2;
        }
    }

    private void downHeap(int k) {
        while (2 * k < n) {
            int j = k * 2;
            if (nodes[j] < nodes[j + 1]) j++;
            if (nodes[k] < nodes[j]) {
                exch(nodes, k, j);
            }
            k *= 2;
        }
    }

    public void put(int value) {
        nodes[++n] = value;
        upHeap(n);

    }

    public int pop() {
        int maxValue = getMax();
        exch(nodes, n--, 1);
        downHeap(1);
        return maxValue;
    }

    public int getMax() {
        return nodes[1];
    }

    public int getSize() {
        return n - 1;
    }
    
    public static void main(String[] args) {
        HeapTree heap = new HeapTree(10000);
        heap.put(2);
        heap.put(3);
        heap.put(4);

        System.out.println(heap.pop());
        System.out.println(heap.pop());

        heap.put(6);
        heap.put(5);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}
