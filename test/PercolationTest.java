import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PercolationTest {

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

    @Test
    public void BackwashNotAllowed() {
        Percolation p = new Percolation(3);
        p.open(1,1);
        p.open(2,1);
        p.open(3,1);
        p.open(3,3);
        assertFalse(p.isFull(3, 3), "open site on bottom row should not be Full when not connected");
    }

    @Test
    void Percolates_simpleConnection() {
        Percolation p = new Percolation(2);
        p.open(1,1);
        p.open(2,1);
        assertTrue(p.percolates());
    }

    @Test
    void Percolates_LessSimpleConnection() {
        Percolation p = new Percolation(3);
        p.open(3,3);
        p.open(1,1);
        p.open(2,3);
        p.open(2,1);
        assertFalse(p.percolates(), "connection doesn't exist between bottom and top");
        p.open(2,2);
        assertTrue(p.percolates(), "now percolates when bottom and top are connected");
    }
}