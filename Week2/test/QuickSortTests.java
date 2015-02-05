import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;


public class QuickSortTests {

    private static final String _10_ELEMENTS_TO_SORT = "data/10.txt";
    private static final String _100_ELEMENTS_TO_SORT = "data/100.txt";
    private static final String _1000_ELEMENTS_TO_SORT = "data/1000.txt";


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

    @Test
    public void tenElement_PivotOnMedian() {
         int[] elements = new int[10];
         readFile(_10_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotMedian(elements);
         assertEquals(21, actual);
    }

    @Test
    public void hundredElement_PivotOnFirst() {
         int[] elements = new int[100];
         readFile(_100_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotFirst(elements);
         assertEquals(615, actual);
    }

    @Test
    public void hundredElement_PivotOnLast() {
         int[] elements = new int[100];
         readFile(_100_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotLast(elements);
         assertEquals(587, actual);
    }

    @Test
    public void hundredElement_PivotOnMedian() {
         int[] elements = new int[100];
         readFile(_100_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotMedian(elements);
         assertEquals(518, actual);
    }

    @Test
    public void thousandElement_PivotOnFirst() {
         int[] elements = new int[1000];
         readFile(_1000_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotFirst(elements);
         assertEquals(10297, actual);
    }

    @Test
    public void thousandElement_PivotOnLast() {
         int[] elements = new int[1000];
         readFile(_1000_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotLast(elements);
         assertEquals(10184, actual);
    }

    @Test
    public void thousandElement_PivotOnMedian() {
         int[] elements = new int[1000];
         readFile(_1000_ELEMENTS_TO_SORT, elements);
         long actual = QuickSort.sortPivotMedian(elements);
         assertEquals(8921, actual);
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
