/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class zQueue<Item> implements Iterable<Item> {
    private Node first, last;
    private int n;

    public void enqueue(Item i) {
        Node oldlast = last;
        last = new Node();
        last.item = i;
        if (size() > 0) oldlast.next = last;
        else first = last;
        n++;
    }

    public Item dequeue() {
        if (size() > 0) {
            Item i = first.item;
            first = first.next;
            n--;
            if (isEmpty()) last = null;
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
        return new zQueueIterator();
    }

    private class zQueueIterator implements Iterator<Item> {
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
        zQueue<String> s = new zQueue<String>();
        StdOut.println("size =" + s.size());
        StdOut.println("enqueueing 1 item");
        s.enqueue("Batsi");
        StdOut.println("size =" + s.size());
        StdOut.println("dequeueing 1 item");
        StdOut.println(s.dequeue());
        StdOut.println("size =" + s.size());
        StdOut.println("enqueueing 2 items");
        s.enqueue("Ruva");
        s.enqueue("Swene");
        StdOut.println("empty? " + s.isEmpty());
        StdOut.println("size =" + s.size());
        StdOut.println("enqueueing 2 more items");
        s.enqueue("Mene");
        s.enqueue("Batsi");
        StdOut.println("iterating");
        for (String str : s) {
            StdOut.println(str);
        }
        StdOut.println("size =" + s.size());
        for (int i = 0; i < 2; i++) {
            StdOut.println("dequeueing 1 item");
            s.dequeue();
            StdOut.println("size =" + s.size());
        }
    }
}
