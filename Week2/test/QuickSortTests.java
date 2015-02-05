import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;


public class QuickSortTests {

    @Test
    public void tenElement_PivotOnFirst() {
         int[] elements = new int[10];
         readFile("data/10.txt", elements);
         long actual = QuickSort.sortPivotFirst(elements);
         assertEquals(25, actual);
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
