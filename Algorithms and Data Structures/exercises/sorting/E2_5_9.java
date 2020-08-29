/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;
/// 2.5.9

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class E2_5_9 {

    private class DJIA implements Comparable<DJIA> {
        private String date;
        private long volume;

        public DJIA(String d, long v) {
            date = d;
            volume = v;
        }

        public int compareTo(DJIA that) {
            if (this == that) return 0;
            else if (this.volume < that.volume) return -1;
            else if (this.volume > that.volume) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        In input = new In(args[0]);
        ArrayList<DJIA> t = new ArrayList<DJIA>();
        while (!input.isEmpty()) {
            String datestr = input.readString();
            long volume = Long.parseLong(input.readString());
            E2_5_9 e = new E2_5_9();
            DJIA record = e.record(datestr, volume);
            t.add(record);
        }
        DJIA[] transactions = t.toArray(new DJIA[t.size()]);
        MergeSort.sort(transactions);
        for (DJIA tr : transactions) {
            StdOut.println(tr.date + " " + tr.volume);
        }
    }

    private DJIA record(String date, long volume) {
        return new DJIA(date, volume);
    }
}
