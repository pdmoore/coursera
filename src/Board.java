public class Board {
    private final int dimension;

    public Board(int[][] blocks) {
        dimension = blocks[0].length;
    }

    public int dimension() {
        return dimension;
    }
}
