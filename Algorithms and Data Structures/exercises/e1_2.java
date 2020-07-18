/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Coursera User ID:  123456
 *  Last modified:     2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class e1_2 {
    /// 1.2.1
    /* write a Point2D client that takes an integer value n from the command line, generates
    n random points in the unit square and computes the distance separating the closest pair of
    points
     */
    /*
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++)
            points[i] = new Point2D(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
        // calculate shortest distance between any two randomly generated points
        double min = 2.0; // longest distance in our plane is sqrt(2)
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                double d = points[i].distanceTo(points[j]);
                if (d < min) min = d;
                System.out.println(points[i] + " " + points[j] + " d: " + d + " min: " + min);
            }
        System.out.println("min = " + min);
    }

     */

    /// 1.2.2
        /*
        Write an Interval1D client that takes an int value n as command-line argument,
        reads n invervals (each defined by a pair of double values) from standard input,
        and prints all pairs that intersect
         */
    /*
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        In input = new In();
        Out output = new Out();
        Interval1D[] intervals = new Interval1D[n];
        for (int i = 0; i < n; i++) {
            double min = input.readDouble();
            double max = input.readDouble();
            output.println();
            intervals[i] = new Interval1D(min, max);
        }
        output.println("Intersecting segments: ");
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    output.println(intervals[i] + "---" + intervals[j]);
            }
    }

    */

    /* 1.2.3 Write an Interval2D client that takes command-line arguments n, min and max and
     * generates n random 2D intervals whose width and height are uniformly distributed between min and
     * max in the unit square. Draw them on StdDraw and print the number of pairs of intervals
     * that intersect and the number of intervals that are contained in one another */
    /*
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval1D[] x1d = new Interval1D[n];
        Interval1D[] y1d = new Interval1D[n];
        Interval2D[] intervals2d = new Interval2D[n];
        for (int i = 0; i < n; i++) {
            double xmin = StdRandom.uniform(min, max);
            x1d[i] = new Interval1D(xmin, StdRandom.uniform(xmin, max));
            double ymin = StdRandom.uniform(min, max);
            y1d[i] = new Interval1D(ymin, StdRandom.uniform(ymin, max));
            intervals2d[i] = new Interval2D(x1d[i], y1d[i]);
            // draw
            intervals2d[i].draw();
        }

        int intersectionCount = 0, containedCount = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (intervals2d[i].intersects(intervals2d[j])) {
                    intersectionCount++;
                    if (
                            (intervals2d[i].contains(new Point2D(x1d[j].min(), y1d[j].min()))
                                    && intervals2d[i]
                                    .contains(new Point2D(x1d[j].max(), y1d[j].max())))
                                    || (
                                    intervals2d[j].contains(new Point2D(x1d[i].min(), y1d[i].min()))
                                            && intervals2d[j]
                                            .contains(new Point2D(x1d[i].max(), y1d[i].max())))
                    )
                        containedCount++;
                }
            }
        StdOut.println("Intersections: " + intersectionCount + " Contained: " + containedCount);
    }
     */
    /// 1.2.4 -> what is the output of the following?
    /*
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }

     */
    /// 1.2.6
    public static boolean isCircular(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) return false;
        StringBuilder comp = new StringBuilder(s1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                comp.setCharAt(((i + j) % len), s1.charAt(j));
            }
            if (comp.toString().equals(s2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StdOut.println(args[0] + " is circular shift of " + args[1] + "? : " + isCircular(args[0],
                                                                                          args[1]));
    }
}
