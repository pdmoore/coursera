import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PercolationTest {

    /* API to implement

    public class Percolation {
      public Percolation(int n)                // create n-by-n grid, with all sites blocked
      public    void open(int row, int col)    // open site (row, col) if it is not open already
      public boolean isOpen(int row, int col)  // is site (row, col) open?
      public boolean isFull(int row, int col)  // is site (row, col) full?
      public     int numberOfOpenSites()       // number of open sites
      public boolean percolates()              // does the system percolate?

      public static void main(String[] args)   // test client (optional)
}


     */

    @Test
    public void ConstructorFailsWhenParamZeroOrLess() {
        Executable closureContainingCodeToTest =
                () -> { new Percolation(0); };

        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "");

        closureContainingCodeToTest =
                () -> { new Percolation(-1); };

        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "");
    }

    @Test
    public void NumberOfOpenSitesZeroOnConstruction() {
        Percolation p = new Percolation(2);
        assertEquals(0, p.numberOfOpenSites());
    }

    @Test
    public void TrackNumberOfOpenSites() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        assertEquals(1, p.numberOfOpenSites());
    }
}
