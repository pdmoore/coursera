import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;


public class QuickSortTests {

    private static final String _10_ELEMENTS_TO_SORT = "data/10.txt";


	@Test
    public void tenElement_PivotOnFirst() {
         int[] elements = new int[10];
         readFile(_10_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotFirst(elements);
         assertEquals(25, actual);
    }
    
    @Test
    public void tenElement_PivotOnLast() {
         int[] elements = new int[10];
         readFile(_10_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotLast(elements);
         assertEquals(29, actual);
    }


    private void readFile(String filename, int[] elements) {
        Scanner scanner;
        try {
             scanner = new Scanner(new File(filename));
             int i = 0;
             while (scanner.hasNextInt()) {
                  elements[i++] = scanner.nextInt();
             }
        } catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + e.getMessage());
        }
   }
}
