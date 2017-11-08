import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int openSiteCount;
    private int gridWidth;

    private boolean openSites[][];
    private static final boolean OPEN   = true;
    private static final boolean CLOSED = false;

    private WeightedQuickUnionUF unionFindFull;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        gridWidth = n;
        openSites = new boolean[gridWidth + 1][gridWidth + 1];

        unionFindFull = new WeightedQuickUnionUF((gridWidth * gridWidth) + 1);
    }

    public int numberOfOpenSites() {
        return openSiteCount;
    }

    private void validateParameters(int row, int col) {
        if ((row <= 0) || (row > gridWidth)) throw new IllegalArgumentException();
        if ((col <= 0) || (col > gridWidth)) throw new IllegalArgumentException();
    }

    public void open(int row, int col) {
        validateParameters(row, col);

        if (openSites[row][col] == CLOSED) {
            openSites[row][col] = OPEN;
            openSiteCount++;

            if (row == 1) {
                unionFindFull.union(0, siteIndex(row, col));
            } else {
                if (isOpen(row - 1, col)) {
                    unionFindFull.union(siteIndex(row, col), siteIndex(row - 1, col));
                }
            }

            if (row < gridWidth) {
                if (isOpen(row + 1, col)) {
                    unionFindFull.union(siteIndex(row, col), siteIndex(row + 1, col));
                }
            }

            if (col > 1) {
                if (isOpen(row, col - 1)) {
                    unionFindFull.union(siteIndex(row, col), siteIndex(row, col - 1));
                }
            }

            if (col < gridWidth) {
                if (isOpen(row, col + 1)) {
                    unionFindFull.union(siteIndex(row, col), siteIndex(row, col + 1));
                }
            }
        }
    }

    private int siteIndex(int row, int col) {
        return ((row - 1) * gridWidth) + col;
    }

    public boolean isOpen(int row, int col) {
        validateParameters(row, col);

        return openSites[row][col];
    }

    public boolean isFull(int row, int col) {
        validateParameters(row, col);

        return unionFindFull.connected(0, siteIndex(row, col));
    }

    public static void main(String[] args) {
    }

}
