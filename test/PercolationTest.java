import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
    public void ConstructorFailsWhenPassedZero() {
        Executable closureContainingCodeToTest =
                () -> { new Percolation(0); };

        assertThrows(IllegalArgumentException.class, closureContainingCodeToTest, "");
    }
}
