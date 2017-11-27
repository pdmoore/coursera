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

    @Override
    public boolean equals(Object y) {
        if (y == null) return false;

        for (int i = 1; i < board.length; i++) {
            if (board[i] != ((Board)y).board[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }

    public Iterable<Board> neighbors() {
        List boardList = new ArrayList<Board>();
        swapWithRight(boardList);
        swapWithBelow(boardList);
        swapWithAbove(boardList);
        swapWithLeft(boardList);


        return boardList;
    }

    private void swapWithLeft(List boardList) {
        if (((blankIndex) % dimension) == 1) return;         // blank is on left edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex - 1;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithAbove(List boardList) {
        if (blankIndex <= dimension) return;                    // blank is on top edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex - dimension;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithBelow(List boardList) {
        if (blankIndex + dimension > board.length) return;      // blank is on bottom edge, no swap

        int[] neighborBoard = makeCopyOfBoard();
        int newBlankIndex = blankIndex + dimension;
        neighborBoard[blankIndex] = neighborBoard[newBlankIndex];
        neighborBoard[newBlankIndex] = 0;

        Board neighbor = new Board(neighborBoard, dimension, newBlankIndex);
        boardList.add(neighbor);
    }

    private void swapWithRight(List boardList) {
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
        // stub for now
        return null;
    }
}
