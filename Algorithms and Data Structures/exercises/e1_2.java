/* *****************************************************************************
 *  Name:              Batsi Swiswa
 *  Coursera User ID:  123456
 *  Last modified:     2020
 **************************************************************************** */

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

    public static void main(String[] args) {
        
    }

}
