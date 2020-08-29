/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    /* 2.3.6, 2.3.7  */
    private static int count;

    public static void sort(Comparable[] a) {
        /* 2.3.6, 2.3.7  */
        count = 0;
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int len = hi - lo + 1;
        if (len <= 2) count++;

        if (hi <= lo) {
            /* 2.3.2 for (Comparable c : a)
                StdOut.print(c);
            StdOut.println();
             */
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1); // sort left
        sort(a, j + 1, hi); // sort right
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..j-1], a[j], a[j+1..hi] and return j
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // scan from left to right, stop if a[i] > v
            while (less(a[++i], v)) if (i == hi) break;
            // scan from right to left, stop if v > a[j]
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j); // put partitioning item into a[j]
        return j; // now array contains a[lo..j-1] <= a[j] <= a[j+1..hi]
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable a, Comparable b) {
        /* 2.3.6 count++; */
        return a.compareTo(b) < 0;
    }

    public static boolean sorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    /* 2.3.6, 2.3.7

     */
    public static int getCount() {
        return count;
    }

    public static void main(String[] args) {
        StdOut.print("Enter the integer size of array to sort: ");
        int n = StdIn.readInt();
        if (n <= 0) throw new IllegalArgumentException("Array size must be at least 1");
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.0, 1.0);
        /* 2.3.2
        String s = StdIn.readLine();
        int n = s.length();
        Character[] a = new Character[n];
        for (int i = 0; i < n; i++)
            a[i] = s.charAt(i);

         */
        QuickSort.sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
        //StdOut.println("N: " + n + " subarrays with length <= 2: " + QuickSort.getCount());
    }
}
