/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_5;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {

    public static double timetrial(int[] inp) {
        Stopwatch timer = new Stopwatch();
        QuickFindUnionFind qf = new QuickFindUnionFind(inp.length);
        for (int i = 2; i < inp.length; i++)
            qf.union(i - 1, i);
        for (int i = 2; i < inp.length; i++)
            qf.connected(i, i - 1);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prevTime = 1.0;
        //Drawing utilities - a standard and a log graph
        // Print table of running times and draw plot
        Queue<Double> times = new Queue<Double>();
        Draw standard = new Draw();
        Draw lg = new Draw();
        standard.setPenColor(StdDraw.BOOK_RED);
        lg.setPenColor(StdDraw.BOOK_BLUE);
        standard.setPenRadius(0.01);
        lg.setPenRadius(0.01);

        for (int i = 5000; i <= 80000; i *= 2) {
            In in = new In("./e1_5/" + Integer.toString(i) + "Node.txt");
            int[] input = in.readAllInts();
            double time = timetrial(input);
            StdOut.print(i + " : " + time + "s");
            if (i > 5000)
                StdOut.print(" 2^b: " + time / prevTime);
            StdOut.println();
            prevTime = time;
            // drawing
            times.enqueue(time);
            standard.clear();
            lg.clear();
            lg.setXscale(0.0, 1.1 * Math.log(i));
            lg.setYscale(-5.0, 1.1 * Math.log(time));
            standard.setXscale(0.0, 1.1 * i);
            standard.setYscale(0.0, 1.1 * time);
            int j = 5000;
            for (double t : times) {
                lg.point(Math.log(j), Math.log(t));
                standard.point(j, t);
                j *= 2;
            }
        }

    }
}
