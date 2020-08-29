/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class E2_5_4 {
    public static String[] dedups(String[] a) {
        int n = a.length;
        MinPQ<String> pq = new MinPQ<String>(n);
        for (int i = 0; i < n; i++) pq.insert(a[i]);
        ArrayList<String> arrayList = new ArrayList<String>();
        String prev = "";
        while (pq.size() > 0) {
            String val = pq.delMin();
            if (val.equals(prev)) continue;
            arrayList.add(val);
            prev = val;
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static void main(String[] args) {
        String[] result = E2_5_4.dedups(args);
        for (String s : result) StdOut.println(s);
    }
}
