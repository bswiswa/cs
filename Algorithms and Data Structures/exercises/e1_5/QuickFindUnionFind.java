/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUnionFind {
    private int[] id;
    private int count;

    public QuickFindUnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        count = n;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pcomponent = find(p);
        int qcomponent = find(q);
        if (pcomponent == qcomponent) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pcomponent) id[i] = qcomponent;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUnionFind uf = new QuickFindUnionFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println("union: " + p + " : " + q);
        }
        StdOut.println("Number of components: " + uf.count());
    }
}
