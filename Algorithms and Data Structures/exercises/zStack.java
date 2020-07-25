/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class zStack<Item> implements Iterable<Item> {
    private Node first;
    private int n;

    public void push(Item i) {
        Node oldfirst = first;
        first = new Node();
        first.item = i;
        if (n > 0) first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (size() > 0) {
            Item i = first.item;
            first = first.next;
            n--;
            return i;
        }
        else throw new NoSuchElementException();
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<Item> iterator() {
        return new zStackIterator();
    }

    private class zStackIterator implements Iterator<Item> {
        private Node current;
        private int i;

        public zStackIterator() {
            current = first;
        }

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
        zStack<String> s = new zStack<String>();
        StdOut.println("size =" + s.size());
        StdOut.println("pushing 1 item");
        s.push("Batsi");
        StdOut.println("size =" + s.size());
        StdOut.println("popping 1 item");
        StdOut.println(s.pop());
        StdOut.println("size =" + s.size());
        StdOut.println("pushing 2 items");
        s.push("Ruva");
        s.push("Swene");
        StdOut.println("empty? " + s.isEmpty());
        StdOut.println("size =" + s.size());
        StdOut.println("pushing 2 more items");
        s.push("Mene");
        s.push("Batsi");
        StdOut.println("iterating");
        for (String str : s) {
            StdOut.println(str);
        }
        StdOut.println("size =" + s.size());
        for (int i = 0; i < 2; i++) {
            s.pop();
            StdOut.println("size =" + s.size());
        }
    }
}
