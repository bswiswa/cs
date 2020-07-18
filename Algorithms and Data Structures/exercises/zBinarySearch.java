/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */
/// 1.2.9

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class zBinarySearch {

    public static int indexOf(Counter counter, int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // key is in a[lo..hi] or not present
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
                counter.increment();
            }
            else if (key > a[mid]) {
                lo = mid + 1;
                counter.increment();
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Counter counter = new Counter("searchCount");
        // array MUST be sorted for binary search
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            // Read key, print if not in whitelist
            int key = StdIn.readInt();
            if (indexOf(counter, whitelist, key) == -1)
                StdOut.println(key);
        }
        StdOut.println("Total keys examined: " + counter.tally());
    }
}
