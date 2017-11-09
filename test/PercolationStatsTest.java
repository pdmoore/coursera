import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PercolationStatsTest {
    /*  API
    public class PercolationStats {
        public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid
        public double mean()                          // sample mean of percolation threshold
        public double stddev()                        // sample standard deviation of percolation threshold
        public double confidenceLo()                  // low  endpoint of 95% confidence interval
        public double confidenceHi()                  // high endpoint of 95% confidence interval

        public static void main(String[] args)        // test client (described below)
     */

    @Test
    public void constructorValidatesParams() {
        Executable constructorCalledWithInvalidSizeParameter =
                () -> {
                    new PercolationStats(0, 1);
                };
        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidSizeParameter, "ctor should verify n != 0");
        constructorCalledWithInvalidSizeParameter =
                () -> {
                    new PercolationStats(-1, 1);
                };
        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidSizeParameter, "ctor should verify n > 0");

        Executable constructorCalledWithInvalidTrialsParameter =
                () -> {
                    new PercolationStats(2, 0);
                };
        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidTrialsParameter, "ctor should verify trials != 0");

        constructorCalledWithInvalidTrialsParameter =
                () -> {
                    new PercolationStats(2, -1);
                };
        assertThrows(IllegalArgumentException.class, constructorCalledWithInvalidTrialsParameter, "ctor should verify trials > 0");
    }

    @Disabled
    @Test
    public void EnsureMeanIsCalculated() {
        PercolationStats ps = new PercolationStats(2, 100);
        double mean = ps.mean();
        assertTrue(mean > 0.0  && mean < 1.0, "mean should be within a reasonable range");
    }
}
