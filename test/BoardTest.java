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
}
