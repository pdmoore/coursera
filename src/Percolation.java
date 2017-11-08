public class Percolation {


    private int openSiteCount;
    private int gridWidth;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        gridWidth = n;
    }

    public int numberOfOpenSites() {
        return openSiteCount;
    }

    public void open(int row, int col) {
        if ((row <= 0) || (row > gridWidth)) throw new IllegalArgumentException();
        if ((col <= 0) || (col > gridWidth)) throw new IllegalArgumentException();

        openSiteCount++;
    }

    public static void main(String[] args) {
    }

}
