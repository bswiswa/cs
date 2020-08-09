/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private int[] id;
    private int count, cost;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        count = n;
        cost = 0;
    }

    public String toString() {
        String s = "";
        for (int i : id)
            s = s.concat(Integer.toString(i)).concat(" ");
        return s;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        cost++;
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pcomponent = find(p);
        int qcomponent = find(q);
        if (pcomponent == qcomponent) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pcomponent) {
                id[i] = qcomponent;
                cost++;
            }
            cost++;
        }
        count--;
    }

    public int cost() {
        return cost;
    }

    public void resetCost() {
        cost = 0;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(uf);
            StdOut.println("Cost: " + uf.cost());
            uf.resetCost();
            //StdOut.println("union: " + p + " : " + q);
        }
        StdOut.println("Number of components: " + uf.count());
    }
}
