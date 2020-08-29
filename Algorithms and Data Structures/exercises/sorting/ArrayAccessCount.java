/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

/// 2.2.6

package sorting;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayAccessCount {
    public static void main(String[] args) {
        StdDraw.setXscale(0.0, 513.0);
        StdDraw.setYscale(0.0, 6 * 512 * Math.log(512.0) / Math.log(2.0));

        for (int i = 1; i <= 512; i++) {
            Double[] a = new Double[i];
            Double[] b = new Double[i];
            for (int j = 0; j < i; j++) {
                double r = StdRandom.uniform(0.0, 1.0);
                a[j] = r;
                b[j] = r;
            }
            MergeSort.sort(a);
            MergeBUSort.sort(b);
            int merge = MergeSort.count();
            int mergebu = MergeBUSort.count();
            int upper = (int) (6 * i * Math.log(1.0 * i) / Math.log(2.0));
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.filledCircle(1.0 * i, 1.0 * merge, 2.0);
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.filledSquare(1.0 * i, 1.0 * mergebu, 0.5);
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.line(i - 0.2, 1.0 * upper, i + 0.2, 1.0 * upper);
            StdOut.println(i + " " + upper + " " + merge + " " + mergebu);
        }

    }
}
