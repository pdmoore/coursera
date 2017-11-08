import jdk.nashorn.internal.ir.annotations.Ignore;
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
        Executable constructorCalledWithInvalidParameter =
                () -> { new Percolation(0); };

        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidParameter, "");

        constructorCalledWithInvalidParameter =
                () -> { new Percolation(-1); };

        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidParameter, "");
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
        p.open(2, 2);
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void OpenFailsWhenParamZeroOrLess() {
        Percolation p = new Percolation(2);

        Executable openWithInvalidRowParam =
                () -> { p.open(0, 1); };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

        openWithInvalidRowParam =
                () -> { p.open(-1, 1); };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

        Executable openWithInvalidColParam =
                () -> { p.open(1, 0); };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");

        openWithInvalidColParam =
                () -> { p.open(1, -1); };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");
    }

    @Test
    public void OpenFailsWhenParamExceedsGridWidth() {
        Percolation p = new Percolation(2);

        Executable openWithInvalidRowParam =
                () -> { p.open(3, 1); };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

       Executable openWithInvalidColParam =
                () -> { p.open(1, 3); };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");
    }

    @Test
    public void SiteCanOnlyBeOpenedOnce() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(1, 1);
        assertEquals(1, p.numberOfOpenSites());
    }


    // open more than one site
    // check if a site is open

}
