import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int dimension;
    private final int[] board;
    private int blankIndex = 0;
    private int manhattan;

    public Board(int[][] blocks) {
        dimension = blocks[0].length;
        board = new int[(dimension * dimension) + 1];
        int index = 1;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (blocks[i][j] == 0) {
                    blankIndex = index;
                }
                board[index++] = blocks[i][j];
            }
        }
        computeManhattan();
    }

    private Board(int[] neighborBoard, int dimension, int blankIndex) {
        this.board = neighborBoard;
        this.dimension = dimension;
        this.blankIndex = blankIndex;

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
                int rowIndexShouldBeIn = (int) Math.ceil((double) i / dimension);
                int rowValueShouldBeIn = (int) Math.ceil((double) board[i] / dimension);
                int rowOffset = Math.abs(rowValueShouldBeIn - rowIndexShouldBeIn);
                int colOffset = Math.abs(Math.abs(board[i] - i) - (dimension * rowOffset));
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

    @Override
    public boolean equals(Object y) {
        if ((y == null) || (y.getClass() != this.getClass())) return false;

        if (((Board) y).dimension() != dimension()) return false;

        for (int i = 1; i < board.length; i++) {
            if (board[i] != ((Board) y).board[i]) return false;
        }

        return true;
    }

    public Iterable<Board> neighbors() {
        List<Board> boardList = new ArrayList<>();
        swapWithRight(boardList);
        swapWithBelow(boardList);
        swapWithAbove(boardList);
        swapWithLeft(boardList);

        return boardList;
    }

    private void swapWithLeft(List<Board> boardList) {
        if (((blankIndex) % dimension) == 1) return;         // blank is on left edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex - 1;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithAbove(List<Board> boardList) {
        if (blankIndex <= dimension) return;                    // blank is on top edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex - dimension;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithBelow(List<Board> boardList) {
        if (blankIndex + dimension >= board.length) return;      // blank is on bottom edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex + dimension;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithRight(List<Board> boardList) {
        if ((blankIndex % dimension) == 0) return;   // blank is on right edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex + 1;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private int[] makeCopyOfBoard() {
        int[] neighborBoard = new int[board.length];
        System.arraycopy(board, 0, neighborBoard, 0, board.length);
        return neighborBoard;
    }

    public Board twin() {
        int[] twinBoard = makeCopyOfBoard();

        int swapThis = 1;
        if (blankIndex == 1) swapThis++;
        int swapThat = swapThis + 1;
        if (blankIndex == swapThat) swapThat++;

        int temp = twinBoard[swapThis];
        twinBoard[swapThis] = twinBoard[swapThat];
        twinBoard[swapThat] = temp;

        return new Board(twinBoard, dimension, blankIndex);
    }

    public static void main(String[] args) {
        // method required for course
    }
}
