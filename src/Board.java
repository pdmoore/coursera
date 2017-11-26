public class Board {
    private final int dimension;
    private final int[] board;
    private int manhattan;

    public Board(int[][] blocks) {
        dimension = blocks[0].length;
        board = new int[(dimension * dimension) + 1];
        int index = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[index++] = blocks[i][j];
            }
        }
        computeManhattan();
    }

    public int dimension() {
        return dimension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dimension);
        sb.append(System.lineSeparator());
        for (int i = 1; i < board.length; i++) {
            sb.append(" ");
            sb.append(board[i]);
            if (i % dimension == 0) sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int hamming() {

        int hamming = 0;
        for (int i = 1; i < board.length; i++) {
            if (board[i] != 0 && board[i] != i) hamming++;
        }
        return hamming;
    }

    public int manhattan() {
        return manhattan;
    }

    private void computeManhattan() {
        for (int i = 1; i < board.length; i++) {
            if (board[i] != 0 && board[i] != i) {
                int rowOffset = Math.abs((board[i] - i) / dimension);
                int colOffset = Math.abs(board[i] - i) - (dimension * rowOffset);
                manhattan += rowOffset + colOffset;
            }
        }
    }


    public boolean isGoal() {
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i] != i) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
