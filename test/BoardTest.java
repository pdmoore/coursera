import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void Dimension_3by3() {
        int[][] blocks = new int[][] { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} };
        Board b = new Board(blocks);
        assertEquals(3, b.dimension());
    }

    @Test
    public void Dimension_2by2() {
        int[][] blocks = new int[][] { {0, 1,}, {2, 3,}, {4, 5} };
        Board b = new Board(blocks);
        assertEquals(2, b.dimension());
    }

    @Test
    public void ToString() {
        int[][] blocks = new int[][] { {1, 2}, {3, 4}, {5, 0} };
        Board b = new Board(blocks);
        assertEquals("2\n 1 2\n 3 4\n", b.toString());
    }

    @Test
    public void Hamming_NoneInWrongPosition_NoMoves() {
        int[][] blocks = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 0} };
        Board b = new Board(blocks);
        assertEquals(0, b.hamming(), "all blocks are in final position, hamming score is 0" );
    }

    @Test
    public void Hamming_SomeBlocksInWrongPosition_NoMoves() {
        int[][] blocks = new int[][] { {8, 1, 3}, {4, 0, 2}, {7, 6, 5} };
        Board b = new Board(blocks);
        assertEquals(5, b.hamming(), "Blocks in wrong positions: 8, 1, 0, 2, 5, 6: hamming score is 5" );
    }
}
