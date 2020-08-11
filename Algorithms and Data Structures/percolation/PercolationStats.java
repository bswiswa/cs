/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private int T;
    private double x;
    private Queue<Double> xval;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        xval = new Queue<Double>();
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates())
                p.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            double estimate = ((double) p.numberOfOpenSites()) / (n * n);
            xval.enqueue(estimate);
            x = (x * T + estimate) / (++T);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return x;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double ssq = 0.0;
        for (double d : xval)
            ssq += Math.pow(d - x, 2);
        return Math.sqrt(ssq / (T - 1));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return x - (1.96 * stddev() / Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return x + (1.96 * stddev() / Math.sqrt(T));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException(
                    "n must be greater than 0, trials must be greater than 1");
        }

        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.println("mean\t\t\t\t " + ps.mean());
        StdOut.println("stdev\t\t\t\t " + ps.stddev());
        StdOut.println("95% confidence interval\t\t [" + ps.confidenceLo() +
                               ", " + ps.confidenceHi() + "]");
    }
}
