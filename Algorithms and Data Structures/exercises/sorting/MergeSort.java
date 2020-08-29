/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSort {
    private static Comparable[] aux;
    private static int count;

    public static void sort(Comparable[] a) {
        int n = a.length;
        count = 0;
        aux = new Comparable[n];
        sort(a, 0, n - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // conditions
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // sort left
        sort(a, mid + 1, hi); // sort right
        merge(a, lo, mid, hi); // merge
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 2.2.5 StdOut.print(hi - lo + 1 + ",");
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
        }

        /* 2.2.1
        StdOut.print("merge(a," + lo + "," + mid + "," + hi + ") ");
        for (int y = 0; y < a.length; y++) {
            StdOut.print(a[y]);
        }
        StdOut.println();
         */
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

        /* 2.2.1
        String s = StdIn.readLine();
        int n = s.length();
        Character[] a = new Character[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);
         */
        MergeSort.sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
        StdOut.println("Array accesses = " + MergeSort.count());
    }
}
