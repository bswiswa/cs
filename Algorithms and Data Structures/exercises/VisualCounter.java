/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Coursera User ID:  123456
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class VisualCounter {
    private int count, maxCount, op, maxOp;
    private Draw draw;

    public VisualCounter(int n, int max) {
        count = 0;
        op = 0;
        maxCount = max;
        maxOp = n;
        draw = new Draw();
        draw.setXscale(0.0, 1.0 * maxOp);
        draw.setYscale(0.0, 1.0 * maxCount);
    }

    public void increment() {
        if (op < maxOp && count < maxCount) {
            count++;
            op++;
            draw.filledCircle(op, count, 0.1);
        }
    }

    public void decrement() {
        if (op < maxOp) {
            count--;
            op++;
            draw.filledCircle(op, count, 0.1);
        }
    }

    public int tally() {
        return count;
    }

    public static void main(String[] args) {
        VisualCounter mycounter = new VisualCounter(5, 4);
        for (int i = 0; i < 10; i++) {
            int u = StdIn.readInt();
            if (u == 1) mycounter.increment();
            else mycounter.decrement();
        }
        StdOut.println("Final value: " + mycounter.tally());
    }
}
