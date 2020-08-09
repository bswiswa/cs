/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int[] id;
    private int count, cost;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        count = n;
        cost = 0;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int node) {
        while (node != id[node]) {
            node = id[node];
            cost += 2;
        }
        cost++;
        return node;
    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq) return;
        id[rootp] = rootq;
        cost++;
        count--;
    }

    public int count() {
        return count;
    }

    public String toString() {
        String s = "";
        for (int i : id)
            s = s.concat(Integer.toString(i)).concat(" ");
        return s;
    }

    public int cost() {
        return cost;
    }

    public void resetCost() {
        cost = 0;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                uf.resetCost();
                continue;
            }
            uf.union(p, q);
            StdOut.println(uf);
            StdOut.println("Cost: " + uf.cost());
            uf.resetCost();
        }
        StdOut.println("number of components: " + uf.count());
    }
}
