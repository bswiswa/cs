/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */
/// 2.5.8

package sorting;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Frequency {

    public static void main(String[] args) {
        int n = args.length;
        MinPQ<String> pq = new MinPQ<String>(n);
        for (int i = 0; i < n; i++) pq.insert(args[i]);
        int count = 0;
        String prev = pq.min();
        while (!pq.isEmpty()) {
            String current = pq.delMin();
            if (prev.equals(current)) {
                count++;
            }
            else {
                StdOut.println(prev + " : " + count);
                count = 1;
                prev = current;
            }
            if (pq.isEmpty()) StdOut.println(prev + " : " + count);
        }
    }
}
