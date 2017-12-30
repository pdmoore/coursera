import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;

    private final int gridWidth;
    private final int trials;

    private final double[] thresholdResults;
    private double mean;
    private double stddev;

    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException();
        if (trials <= 0) throw new IllegalArgumentException();

        gridWidth = n;
        this.trials = trials;

        thresholdResults = new double[trials];

        runExperiments();
    }

    private void runExperiments() {
        for (int i = 0; i < trials; i++) {
            int numSites = runExperiment();
            double threshold = (double) numSites/(gridWidth * gridWidth);
            thresholdResults[i] = threshold;
        }

        mean   = StdStats.mean(thresholdResults);
        stddev = StdStats.stddev(thresholdResults);
    }

    private int runExperiment() {
        Percolation p = new Percolation(gridWidth);

        while (!p.percolates()) {
            int randRow = StdRandom.uniform(gridWidth) + 1;
            int randCol = StdRandom.uniform(gridWidth) + 1;
            p.open(randRow, randCol);
        }

        return p.numberOfOpenSites();
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(trials));
    }

    private void showResults() {
        System.out.println("mean                    = " + mean());
        System.out.println("stddev                  = " + stddev());
        System.out.println("95% confidence interval = [" +
                confidenceLo() + ", " + confidenceHi() + "]");
    }

    public static void main(String[] args) {
        int gridWidth = Integer.parseInt(args[0]);
        int trials    = Integer.parseInt(args[1]);

        PercolationStats pStats = new PercolationStats(gridWidth, trials);
        pStats.showResults();
    }
}
