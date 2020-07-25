/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class zBag<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    public void add(Item i) {
        Node oldfirst = first;
        first = new Node();
        first.item = i;
        if (size() > 0) first.next = oldfirst;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<Item> iterator() {
        return new zBagIterator();
    }

    private class zBagIterator implements Iterator<Item> {
        private Node current = first;
        private int i;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (i == n) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }

        public void remove() {
        }
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public static void main(String[] args) {
        zBag<String> s = new zBag<String>();
        StdOut.println("size =" + s.size());
        StdOut.println("adding 1 item");
        s.add("Batsi");
        StdOut.println("size =" + s.size());
        StdOut.println("adding 2 items");
        s.add("Ruva");
        s.add("Swene");
        StdOut.println("empty? " + s.isEmpty());
        StdOut.println("size =" + s.size());
        StdOut.println("adding 2 more items");
        s.add("Mene");
        s.add("Batsi");
        StdOut.println("iterating");
        for (String str : s) {
            StdOut.println(str);
        }
    }
}
