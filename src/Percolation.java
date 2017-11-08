public class Percolation {


    private int openSiteCount;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();


    }

    public int numberOfOpenSites() {
        return openSiteCount;
    }

    public void open(int row, int col) {
        openSiteCount++;
    }

    public static void main(String[] args) {
    }

}
