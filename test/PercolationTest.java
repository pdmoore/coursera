import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PercolationTest {

    /* API to implement

    public class Percolation {
xx      public Percolation(int n)                // create n-by-n grid, with all sites blocked
xx      public    void open(int row, int col)    // open site (row, col) if it is not open already
xx      public boolean isOpen(int row, int col)  // is site (row, col) open?
      public boolean isFull(int row, int col)  // is site (row, col) full?
xx      public     int numberOfOpenSites()       // number of open sites
      public boolean percolates()              // does the system percolate?

      public static void main(String[] args)   // test client (optional)
     */

    @Test
    public void ConstructorFailsWhenParamZeroOrLess() {
        Executable constructorCalledWithInvalidParameter =
                () -> {
                    new Percolation(0);
                };

        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidParameter, "");

        constructorCalledWithInvalidParameter =
                () -> {
                    new Percolation(-1);
                };

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
    public void SiteCanOnlyBeOpenedOnce() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(1, 1);
        assertEquals(1, p.numberOfOpenSites());
    }

    @Test
    public void OpenFailsWhenParamZeroOrLess() {
        Percolation p = new Percolation(2);

        Executable openWithInvalidRowParam =
                () -> {
                    p.open(0, 1);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

        openWithInvalidRowParam =
                () -> {
                    p.open(-1, 1);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

        Executable openWithInvalidColParam =
                () -> {
                    p.open(1, 0);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");

        openWithInvalidColParam =
                () -> {
                    p.open(1, -1);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");
    }

    @Test
    public void OpenFailsWhenParamExceedsGridWidth() {
        Percolation p = new Percolation(2);

        Executable openWithInvalidRowParam =
                () -> {
                    p.open(3, 1);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidRowParam, "");

        Executable openWithInvalidColParam =
                () -> {
                    p.open(1, 3);
                };
        assertThrows(IllegalArgumentException.class, openWithInvalidColParam, "");
    }

    @Test
    public void CanAskIfSiteIsOpen() {
        Percolation p = new Percolation(2);
        assertFalse(p.isOpen(1, 1), "site should be Closed on construction");
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
    }

    @Test
    public void IsOpenWhenParamZeroOrLess() {
        Percolation p = new Percolation(2);

        Executable isOpenWithInvalidRowParam =
                () -> {
                    p.isOpen(0, 1);
                };
        assertThrows(IllegalArgumentException.class, isOpenWithInvalidRowParam, "");

        isOpenWithInvalidRowParam =
                () -> {
                    p.isOpen(-1, 1);
                };
        assertThrows(IllegalArgumentException.class, isOpenWithInvalidRowParam, "");

        Executable isOpenWithInvalidColParam =
                () -> {
                    p.isOpen(1, 0);
                };
        assertThrows(IllegalArgumentException.class, isOpenWithInvalidColParam, "");

        isOpenWithInvalidColParam =
                () -> {
                    p.isOpen(1, -1);
                };
        assertThrows(IllegalArgumentException.class, isOpenWithInvalidColParam, "");
    }

    @Test
    public void SiteThatIsOpenAndConnectedToTopRowIsFull() {
        Percolation p = new Percolation(2);
        assertFalse(p.isFull(1,1), "site is not full to start with");
        p.open(1, 1);
        assertTrue(p.isFull(1,1), "site is full when open and connected to top");
    }

    @Test
    public void SiteThatIsOpenAndNotConnectedToTopRowIsNotFull() {
        Percolation p = new Percolation(2);
        p.open(2, 1);
        assertFalse(p.isFull(1,1), "site is open but not connected to top, so not full");
    }

    @Test
    public void connectSiteAbove() {
        Percolation p = new Percolation(2);
        p.open(1, 1);
        p.open(2, 1);
        assertTrue(p.isFull(2, 1), " second row site should be open since it connects to above");
    }

    @Test
    public void connectSiteBelow() {
        Percolation p = new Percolation(2);
        p.open(2,1);
        p.open(1,1);
        assertTrue(p.isFull(2, 1), "opening a full site above an open site should then make site below full");
    }

    @Test
    public void connectSiteToRight() {
        Percolation p = new Percolation(2);
        p.open(1,1);
        p.open(2,1);
        p.open(2,2);
        assertTrue(p.isFull(2, 2), "site to the right of an open & full site should be full");
    }

    @Test
    public void connectSiteToLeft() {
        Percolation p = new Percolation(2);
        p.open(1,2);
        p.open(2,2);
        p.open(1,2);
        assertTrue(p.isFull(1,2), "site to left of an open & full site should be full");
    }

    @Test
    public void IsFullWhenParamZeroOrLess() {
        Percolation p = new Percolation(2);

        Executable isFullWithInvalidRowParam =
                () -> {
                    p.isFull(0, 1);
                };
        assertThrows(IllegalArgumentException.class, isFullWithInvalidRowParam, "");

        isFullWithInvalidRowParam =
                () -> {
                    p.isFull(-1, 1);
                };
        assertThrows(IllegalArgumentException.class, isFullWithInvalidRowParam, "");

        Executable isFullWithInvalidColParam =
                () -> {
                    p.isFull(1, 0);
                };
        assertThrows(IllegalArgumentException.class, isFullWithInvalidColParam, "");

        isFullWithInvalidColParam =
                () -> {
                    p.isFull(1, -1);
                };
        assertThrows(IllegalArgumentException.class, isFullWithInvalidColParam, "");
    }


    // percolates with virtual top and virtual bottom - need another UF object to check. mirror ufFull
    // backwash case for isFull


}