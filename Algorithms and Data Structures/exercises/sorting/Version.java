/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Pattern;

public class Version implements Comparable<Version> {
    private String v;

    public Version(String version) {
        v = version;
    }

    public String version() {
        return v;
    }

    public int compareTo(Version that) {
        String[] thisVersion = v.split(Pattern.quote("."));
        String[] thatVersion = that.v.split(Pattern.quote("."));
        int n = thisVersion.length;
        if (n > thatVersion.length) n = thatVersion.length;
        int i = 0;
        while (i < n && thisVersion[i].equals(thatVersion[i])) i++;
        if (i == n) {
            if (thisVersion.length == thatVersion.length) return 0;
            else if (thisVersion.length < thatVersion.length) return -1;
            else return 1;
        }
        else return Integer
                .compare(Integer.parseInt(thisVersion[i]), Integer.parseInt(thatVersion[i]));
    }

    public static void main(String[] args) {
        Version[] v = new Version[args.length];
        for (int i = 0; i < args.length; i++)
            v[i] = new Version(args[i]);
        Selection.sort(v);
        for (int i = 0; i < v.length; i++)
            StdOut.println(v[i].v);


    }
}
