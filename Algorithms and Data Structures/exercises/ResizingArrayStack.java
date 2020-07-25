/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] arr;
    private int n;

    public ResizingArrayStack() {
        arr = (Item[]) new Object[1];
    }

    private void resize(int s) {
        Item[] tmp = (Item[]) new Object[s];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    public void push(Item s) {
        if (isFull()) resize(2 * arr.length);
        arr[n++] = s;
    }

    public Item pop() {
        if (n == 0)
            throw new IndexOutOfBoundsException();
        if ((n - 1) == (arr.length / 4)) resize(arr.length / 2);
        return arr[--n];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n + 1 == arr.length;
    }

    public int size() {
        return n;
    }

    public int capacity() {
        return arr.length;
    }

    public Iterator<Item> iterator() {
        return new ResizingArrayStackIterator();
    }

    private class ResizingArrayStackIterator implements Iterator<Item> {
        private int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (i == n) throw new NoSuchElementException();
            return arr[i--];
        }

    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        /// 1.3.8
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");


        StdOut.println("size =" + s.size());
        StdOut.println("capacity =" + s.capacity());
        StdOut.println("pushing 1 item");
        s.push("Batsi");
        StdOut.println("size =" + s.size());
        StdOut.println("capacity =" + s.capacity());
        StdOut.println("popping 1 item");
        StdOut.println(s.pop());
        StdOut.println("size =" + s.size());
        StdOut.println("capacity =" + s.capacity());
        StdOut.println("pushing 2 items");
        s.push("Ruva");
        s.push("Swene");
        StdOut.println("empty? " + s.isEmpty());
        StdOut.println("size =" + s.size());
        StdOut.println("capacity =" + s.capacity());
        StdOut.println("pushing 2 more items");
        s.push("Mene");
        s.push("Batsi");
        StdOut.println("iterating");
        for (String str : s) {
            StdOut.println(str);
        }
        StdOut.println("size =" + s.size());
        StdOut.println("capacity =" + s.capacity());
        for (int i = 0; i < 2; i++) {
            s.pop();
            StdOut.println("size =" + s.size());
            StdOut.println("capacity =" + s.capacity());
        }

    }
}
