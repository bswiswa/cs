/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */
/// 1.4.2 Modify ThreeSum to work properly when the int values
// are so large that adding them might cause overflow

package e1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumModified {
    public static int count(int[] a) {
        // Count triples that sum to 0
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (a[i] + a[j] + a[k] == 0) {
                        if ((long) a[i] + (long) a[j] + (long) a[k] == 0)
                            count++;
                    }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Stopwatch timer = new Stopwatch();
        StdOut.println(count(a));
        StdOut.println("Elapsed time: " + timer.elapsedTime() + "s");
    }
}
