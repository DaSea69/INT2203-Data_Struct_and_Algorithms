import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class UFClient {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF unionUF = new WeightedQuickUnionUF(n);
        /* Two variables  */
        int q, p;
        int countCouple = 0;
        while (!StdIn.isEmpty()) {

            q = StdIn.readInt();
            p = StdIn.readInt();
            countCouple++;

            if (!unionUF.connected(p, q)) {
                unionUF.union(p, q);
            }

            if (unionUF.count() == 1) {
                StdOut.println(countCouple);
                return ;
            }
        }
        StdOut.println("FAILED");
    }
}