/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package sorting;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E2_5_2 {
    public static void main(String[] args) {
        QuickSort.sort(args);
        int n = args.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                String word = args[i].concat(args[j]);
                if (Arrays.binarySearch(args, word) > 0) {
                    StdOut.println(word);
                    break;
                }
            }

    }
}
