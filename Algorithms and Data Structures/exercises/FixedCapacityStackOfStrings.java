/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] arr;
    private int n;

    public FixedCapacityStackOfStrings(int capacity) {
        arr = new String[capacity];
    }

    public void push(String s) {
        arr[n++] = s;
    }

    public String pop() {
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

    public Iterator<String> iterator() {
        return new FixedCapacityStackOfStringsIterator();
    }

    private class FixedCapacityStackOfStringsIterator implements Iterator<String> {
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (i >= n) throw new NoSuchElementException();
            return arr[i--];
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(4);
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
        StdOut.println("iteration");
        for (String str : s)
            StdOut.println(str);
    }
}
