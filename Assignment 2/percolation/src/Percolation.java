import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF sites;
    final private int[] colMove = {1, 0, 0, -1};
    final private int[] rowMove = {0, 1, -1, 0};
    final private int virtualUpperSite, virtualLowerSite;

    private enum Status {
        BLOCKED, OPENED
    }
    private Status[][] status;
    private int n;
    private int numberOfSiteIsOpens;

    public Percolation(int n) {
        if(n <= 0)
            throw new IllegalArgumentException();
        sites = new WeightedQuickUnionUF(n * n + 2);
        status = new Status[n + 1][n + 1];
        numberOfSiteIsOpens = 0;
        this.n = n;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                status[i][j] = Status.BLOCKED;
            }
        }
        virtualLowerSite = n * n;
        virtualUpperSite = n * n + 1;
    }

    private int hashID(int row, int col) {
        return (row - 1) * n + (col - 1);
    }

    public void open(int row, int col) {
        if(row > n || row < 1 || col > n || col < 1)
            throw new IllegalArgumentException("Out of size");
        if (status[row][col] == Status.OPENED) {
            return ;
        }
        if (row == 1) {
            sites.union(virtualUpperSite, hashID(row, col));
        }
        if (row == n) {
            sites.union(virtualLowerSite, hashID(row, col));
        }
        status[row][col] = Status.OPENED;
        numberOfSiteIsOpens++;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + rowMove[i];
            int nextCol = col + colMove[i];
            if(!(nextRow > n || nextRow < 1 || nextCol > n || nextCol < 1)){
                if(status[nextRow][nextCol] == Status.OPENED){
                    sites.union(hashID(nextRow, nextCol), hashID(row, col));
                }
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if(row > n || row < 1 || col > n || col < 1)
            throw new IllegalArgumentException("Out of size");
        return status[row][col] == Status.OPENED;
    }

    public boolean isFull(int row, int col) {
        if(row > n || row < 1 || col > n || col < 1)
            throw new IllegalArgumentException("Out of size");
        if(!isOpen(row, col))
            return false;
        return sites.connected(hashID(row, col), virtualUpperSite);
    }

    public int numberOfOpenSites() {
        return numberOfSiteIsOpens;
    }

    public boolean percolates() {
        return sites.connected(virtualLowerSite, virtualUpperSite);
    }

    public static void main(String[] args) {
    }
}
