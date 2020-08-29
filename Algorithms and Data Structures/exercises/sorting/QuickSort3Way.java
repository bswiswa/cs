/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort3Way {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        //int j = partition(a, lo, hi); // does not use the 2 way partitioning of regular quick sort
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++); // move a[i] into lt section
            else if (cmp > 0) exchange(a, i, gt--); // move a[i] into gt section
            else i++; // keep a[i] in place (middle section)
        }
        sort(a, lo, lt - 1); // sort lt section
        sort(a, gt + 1, hi); // sort gt section
        // middle section is composed of duplicates and needs no sorting
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
        QuickSort3Way.sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
