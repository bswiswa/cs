/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] arr;
    private int n;

    public FixedCapacityStack(
            int capacity) {
        arr = (Item[]) new Object[capacity];
    }

    public void push(Item s) {
        arr[n++] = s;
    }

    public Item pop() {
        return arr[--n];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == arr.length;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new FixedCapacityStackIterator();
    }

    private class FixedCapacityStackIterator implements Iterator<Item> {
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (i == n) throw new NoSuchElementException();
            return arr[i--];
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(4);
        s.push("Batsi");
        StdOut.println(s.pop());
        StdOut.println(s.isEmpty());
        s.push("Ruva");
        s.push("Swene");
        StdOut.println("empty? " + s.isEmpty());
        StdOut.println("full? " + s.isFull());
        StdOut.println("size: " + s.size());
        s.push("Mene");
        s.push("Batsi");
        StdOut.println("full? " + s.isFull());
        for (String str : s) {
            StdOut.println(str);
        }
    }
}
