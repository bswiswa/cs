/* *****************************************************************************
 *  Name:              Batsirai Swiswa
 *  Coursera User ID:  123456
 *  Last modified:     7/9/2020
 **************************************************************************** */

public class Percolation {
    private int[] grid;
    private int n, nn, openCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        nn = (n * n) + 1;
        grid = new int[nn];
        for (int i = 0; i < nn; i++) {
            grid[i] = i;
        }
    }

    public void checkObj() {
        for (int i = 0; i < nn; i++) {
            System.out.printf("%d %d\n", i, grid[i]);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = n * (row - 1) + col, top, right, bottom, left;
        if (grid[index] < 1) return;
        openCount++;
        if (row == 1) {
            grid[index] = grid[0];
            return;
        }
        else {
            // check if connected to a full site
            top = index - n;
            if (grid[top] == grid[0]) {
                grid[index] = grid[0];
                return;
            }
            if (col < n) {
                right = index + 1;
                if (grid[right] == grid[0]) {
                    grid[index] = grid[0];
                    return;
                }
            }
            if (col > 1) {
                left = index - 1;
                if (grid[left] == grid[0]) {
                    grid[index] = grid[0];
                    return;
                }
            }
            if (row < n) {
                bottom = index + n;
                if (grid[bottom] == grid[0]) {
                    grid[index] = grid[0];
                    return;
                }
            }
            grid[index] = -1; // open site
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = n * (row - 1) + col;
        return grid[index] == -1;
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = n * (row - 1) + col;
        return grid[index] == grid[0];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = nn - n - 1; i < nn; i++) {
            if (grid[i] == grid[0]) return true;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(2, 1);
        p.open(2, 2);
        p.open(2, 3);
        p.open(2, 4);
        p.open(2, 5);
        p.open(3, 5);
        p.open(3, 4);
        p.open(3, 3);
        p.open(3, 2);
        p.open(4, 2);
        p.open(4, 1);
        p.open(5, 1);
        System.out
                .printf("Open count: %d\nPercolates? %b\n", p.numberOfOpenSites(), p.percolates());
    }
}
