/* *****************************************************************************
 *  Name:              Batsirai Swiswa
 *  Coursera User ID:  123456
 *  Last modified:     7/11/2020
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class e1_1 {
    private static double[][] arr;
    private static boolean initialized;
    private static int count;
    
    public static void main(String[] args) {
        // 1.1.1 b.
        //System.out.println(2.0e-6 * 100000000.1);

        // 1.1.6
        /*
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
        */

        // 1.1.7
        // a.
        /* double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
         */
        // b.
        /*
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
        */
        // c.
        /*
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
        */
        // 1.1.9
        /*
        System.out.print("Enter a number: ");
        int n = StdIn.readInt();
        System.out.printf("%d\t", n);
        StringBuilder s = new StringBuilder();
        do {
            if (n % 2 == 1)
                s.insert(0, "1");
            else
                s.insert(0, "0");
            n = n / 2;
        } while (n != 0);
        System.out.printf("%s\n", s);
        */
        //System.out.println(1 + 2 + "3");
        // 1.1.27
        /*
        StdOut.println(binomial(100, 50, 0.25));
        StdOut.println(count);
        */
        int[] a = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 7 };
        int[] uniq = getUnique(a);
        StdOut.println(Arrays.toString(uniq));
    }

    public static int[] getUnique(int[] a) {
        int[] temp = new int[a.length];
        int uniqueIndex = 0;
        temp[uniqueIndex] = a[0];
        for (int i = 0; i < a.length; i++) {
            if (temp[uniqueIndex] != a[i]) {
                uniqueIndex++;
                temp[uniqueIndex] = a[i];
            }
        }
        int uniqueCount = uniqueIndex + 1;
        int[] uniq = new int[uniqueCount];
        System.arraycopy(temp, 0, uniq, 0, uniqueCount);
        return uniq;
    }

    public static double binomial(int n, int k, double p) {
        count++;
        if (!initialized) {
            arr = new double[n + 1][k + 1];
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[0].length; j++)
                    arr[i][j] = -1;

            initialized = true;
        }

        if ((n == 0) && (k == 0)) return 1.0;
        if ((n < 0) || (k < 0)) return 0.0;
        if (arr[n][k] == -1)
            arr[n][k] = (1 - p) * binomial(n - 1, k, p) + p * binomial(n - 1, k - 1, p);

        return arr[n][k];
    }
}
