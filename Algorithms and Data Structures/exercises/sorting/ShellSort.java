/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        // estimate h using an arbitrary increments of 3 so 1, 4, 7, 10, 13, 16 ...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        // sort every h-th sequence where h decreases to 1.
        // sorting for large h allows us to make big jumps in moving items
        // as opposed to the one by one swapping done by insertion sort (where h = 1)
        // shell sort is fast because by the time h = 1, array is partially sorted
        while (h >= 1) {
            for (int i = h; i < n; i++)
                for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h)
                    exchange(a, j, j - h);
            h = h / 3;
        }
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean sorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        StdOut.print("Enter the integer size of array to sort: ");
        int n = StdIn.readInt();
        if (n <= 0) throw new IllegalArgumentException("Array size must be at least 1");
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.0, 1.0);
        ShellSort.sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
