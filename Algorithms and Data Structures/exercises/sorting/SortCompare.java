/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection"))
            SelectionSort.sort(a);
        if (alg.equals("Insertion"))
            InsertionSort.sort(a);
        if (alg.equals("Shell"))
            ShellSort.sort(a);
        if (alg.equals("Merge"))
            MergeSort.sort(a);
        if (alg.equals("MergeBU"))
            MergeBUSort.sort(a);
        if (alg.equals("Quick"))
            QuickSort.sort(a);
        if (alg.equals("Quick3Way"))
            QuickSort3Way.sort(a);
        if (alg.equals("Heap"))
            HeapSort.sort(a);
        return timer.elapsedTime();
    }

    public static double runRandomInputTrials(String alg, int n, int trials) {
        double time = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < trials; i++) {
            for (int j = 0; j < n; j++)
                a[j] = StdRandom.uniform(0.0, 1.0);
            time += time(alg, a);
        }
        return time;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[2]);
        int trials = Integer.parseInt(args[3]);
        double time1 = runRandomInputTrials(args[0], n, trials);
        double time2 = runRandomInputTrials(args[1], n, trials);
        StdOut.println("Comparison: ");
        StdOut.println("1. " + args[0] + ": " + time1);
        StdOut.println("2. " + args[1] + ": " + time2);
        StdOut.println("Ratio (1/2): " + time1 / time2);

    }
}
