/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/// 2.3.6
public class CompareCount {
    public static void main(String[] args) {
        int[] n = { 100, 1000, 10000 };
        for (int ni : n) {
            Double[] a = new Double[ni];
            for (int i = 0; i < ni; i++)
                a[i] = StdRandom.uniform(0.0, 1.0);
            QuickSort.sort(a);
            StdOut.println("approx: " + (int) (2 * ni * Math.log(1.0 * ni)));
            StdOut.println("actual: " + QuickSort.getCount());

        }

    }
}
