import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private int n;
    private int trials;
    private Percolation percolation;
    private double[] result;
    private double s;
    private double x;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if(n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        this.trials = trials;
        percolation = null;
        this.result = new double[trials];
        getResult();
        x = StdStats.mean(result);
        s = StdStats.stddev(result);
    }

    private double testPercolation() {
        percolation = new Percolation(n);
        int[] randomSite = StdRandom.permutation(n * n);
        for(int i = 0; i < n * n; i++) {
            int row = (randomSite[i] / n) + 1;
            int col = (randomSite[i] % n) + 1;
            percolation.open(row, col);
            if(percolation.percolates())
                break;
        }
        //System.out.printf("%d / %d \n", percolation.numberOfOpenSites(), n * n);
        return (double) percolation.numberOfOpenSites()/(n * n);
    }

    private void getResult() {
        for(int i = 0; i < trials; i++) {
            result[i] = testPercolation();
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return x;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return s;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return this.mean() - 1.96 * this.stddev() / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + 1.96 * this.stddev() / Math.sqrt(trials);
    }

    // test client (see below)
    public static void main(String[] args) {
            /*PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]));
            PercolationStats percolationStats = new PercolationStats(200, 100);
            System.out.println(percolationStats.mean());
            System.out.println(percolationStats.stddev());
            System.out.printf("[%f - %f]", percolationStats.confidenceLo(), percolationStats.confidenceHi()); */
    }

}
