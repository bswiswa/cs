/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/// MergeBU (bottom up) uses iteration instead of recursion in regular MergeSort (top down)
public class MergeBUSort {
    private static Comparable[] aux;
    private static int count; // count is for 2.2.6

    public static void sort(Comparable[] a) {
        int n = a.length;
        count = 0;
        aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len)
                merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 2.2.5 StdOut.print((hi - lo + 1) + ",");
        // copy into a[lo..hi] to aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            count += 2;
        }
        // merge back to a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
            count += 2;
           /* 2.2.3
            for (int z = 0; z < a.length; z++)
                StdOut.print(a[z]);
            StdOut.println();

            */
        }

    }

    private static boolean less(Comparable a, Comparable b) {
        count += 2;
        return a.compareTo(b) < 0;
    }

    public static boolean sorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static int count() {
        return count;
    }

    public static void main(String[] args) {
        StdOut.print("Enter the integer size of array to sort: ");
        int n = StdIn.readInt();
        if (n <= 0) throw new IllegalArgumentException("Array size must be at least 1");
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.0, 1.0);
        /*2.2.3
        String s = StdIn.readLine();
        int n = s.length();
        Character[] a = new Character[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
        */
        MergeBUSort.sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
        StdOut.println("Count = " + MergeBUSort.count());
    }
}
