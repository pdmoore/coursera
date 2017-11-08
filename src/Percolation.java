public class Percolation {

    private int openSiteCount;
    private int gridWidth;

    private boolean openSites[][];
    private static final boolean OPEN   = true;
    private static final boolean CLOSED = false;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        gridWidth = n;
        openSites = new boolean[gridWidth + 1][gridWidth + 1];
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
        }
    }

    public boolean isOpen(int row, int col) {
        validateParameters(row, col);

        return openSites[row][col];
    }

    public static void main(String[] args) {
    }
}
