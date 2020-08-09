/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

package e1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    public int[] id;
    public int[] sz;
    public int count, cost;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        cost = 0;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
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
        int proot = find(p);
        int qroot = find(q);
        if (proot == qroot) return;
        if (sz[proot] <= sz[qroot]) {
            id[proot] = qroot;
            sz[qroot] += sz[proot];
        }
        else {
            id[qroot] = proot;
            sz[proot] += sz[qroot];
        }
        cost += 4;
        count--;
    }

    public void resetCost() {
        cost = 0;
    }

    public String toString() {
        String s = "id[]: ";
        for (int i : id)
            s = s.concat(Integer.toString(i).concat(" "));
        s = s.concat("\nsz[]: ");
        for (int i : sz)
            s = s.concat(Integer.toString(i).concat(" "));

        return s;
    }

    public int cost() {
        return cost;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
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
        StdOut.println("Number of components: " + uf.count());
    }
}
