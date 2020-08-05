/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_4;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    public static double timeTrial(int n) {
        // Time ThreeSum.count() for n random 6 digit ints
        int MAX = 1000000, count;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        // Print table of running times and draw plot
        Queue<Double> times = new Queue<Double>();
        Draw standard = new Draw();
        Draw lg = new Draw();
        standard.setPenColor(StdDraw.BOOK_RED);
        lg.setPenColor(StdDraw.BOOK_BLUE);
        standard.setPenRadius(0.01);
        lg.setPenRadius(0.01);
        for (int n = 250; true; n *= 2) {
            // Print time for problem size n

            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);
            times.enqueue(time);
            standard.clear();
            lg.clear();
            lg.setXscale(0.0, 1.1 * Math.log(n));
            lg.setYscale(-5.0, 1.1 * Math.log(time));
            standard.setXscale(0.0, 1.1 * n);
            standard.setYscale(0.0, 1.1 * time);
            int i = 250;
            for (double t : times) {
                lg.point(Math.log(i), Math.log(t));
                standard.point(i, t);
                i *= 2;
            }
        }
    }
}
