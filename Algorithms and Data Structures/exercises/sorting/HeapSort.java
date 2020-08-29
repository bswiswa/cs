/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class HeapSort {

    public static void sort(Comparable[] a) {
        // build binary heap
        int n = a.length;
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n);
        // sort the array by placing the larger items to the right
        while (n > 1) {
            exchange(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, i, j)) break;
            exchange(a, i, j);
            i = j;
        }
    }

    // binary heap array implementation starts at a[1] so sink and exchange need to
    // decrement array indices before operating
    private static void exchange(Comparable[] a, int i, int j) {
        i--;
        j--;
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Comparable[] a, int i, int j) {
        i--;
        j--;
        return a[i].compareTo(a[j]) < 0;
    }

    public static boolean sorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        StdOut.print("Enter the integer size of array to sort: ");
        int n = StdIn.readInt();
        if (n <= 0) throw new IllegalArgumentException("Array size must be at least 1");
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(0.0, 1.0);
        sort(a);
        assert sorted(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
