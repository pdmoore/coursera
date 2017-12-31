package week1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PercolationStatsTest {
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

    @Test
    public void EnsureMeanIsCalculated() {
        // really should probably inject a mock week1.Percolation but that would change public interface of PS class
        PercolationStats ps = new PercolationStats(2, 100);
        double mean = ps.mean();
        assertTrue(mean > 0.5  && mean < 0.7, "mean should be within a reasonable range");
    }
}
