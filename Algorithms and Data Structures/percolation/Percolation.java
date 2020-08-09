/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private boolean[] open;
    private int n, openCount;

    // create n by n grid with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Grid size should be 1 or more");
        this.n = n;
        grid = new WeightedQuickUnionUF(n * n);
        open = new boolean[n * n];
        openCount = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = getIndex(row, col);
        validate(index);
        if (open[index]) return;
        open[index] = true;
        openCount++;
        // connect to top component
        if (row > 1 && open[index - n]) connect(index, index - n);
        // connect to bottom component
        if (row < n && open[index + n]) connect(index, index + n);
        // connect to left component
        if (col > 1 && open[index - 1]) connect(index, index - 1);
        // connect to right component
        if (col < n && open[index + 1]) connect(index, index + 1);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = getIndex(row, col);
        validate(index);
        return open[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = getIndex(row, col);
        validate(index);
        if (open[index])
            for (int i = 0; i < n; i++)
                if (grid.find(index) == grid.find(i)) return true;
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        int max = n * n;
        for (int i = max - n; i < max; i++)
            for (int j = 0; j < n; j++)
                if (grid.find(i) == grid.find(j)) return true;
        return false;
    }

    private void validate(int m) {
        if (m < 0 || m >= n * n)
            throw new IllegalArgumentException("Incorrect location supplied");
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + col - 1;
    }

    private void connect(int p, int q) {
        grid.union(p, q);
    }

    // test client
    public static void main(String[] args) {
        Percolation p = new Percolation(4);
        StdOut.println("isOpen(1, 1): " + Boolean.toString(p.isOpen(1, 1)));
        StdOut.println("isFull(1, 1): " + Boolean.toString(p.isFull(1, 1)));
        StdOut.println("isOpen(4, 1): " + Boolean.toString(p.isOpen(4, 1)));
        StdOut.println("isFull(4, 1): " + Boolean.toString(p.isFull(4, 1)));
        StdOut.println("Number of open sites: " + p.numberOfOpenSites());
        StdOut.println("open (1,1) and (4,1)");
        p.open(1, 1);
        p.open(4, 1);
        StdOut.println("isOpen(1, 1): " + Boolean.toString(p.isOpen(1, 1)));
        StdOut.println("isFull(1, 1): " + Boolean.toString(p.isFull(1, 1)));
        StdOut.println("isOpen(4, 1): " + Boolean.toString(p.isOpen(4, 1)));
        StdOut.println("isFull(4, 1): " + Boolean.toString(p.isFull(4, 1)));
        StdOut.println("Number of open sites: " + p.numberOfOpenSites());

    }
}
