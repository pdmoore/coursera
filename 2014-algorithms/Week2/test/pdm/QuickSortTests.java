package pdm;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class QuickSortTests {


	@Test
	public void tenElement_PivotOnFirst() {
		int[] elements = new int[10];
		readFile("10.txt", elements);
		long actual = QuickSort.sortPivotFirst(elements);
		assertEquals(25, actual);
	}


	@Test
	public void tenElement_PivotOnLast() {
		int[] elements = new int[10];
		readFile("10.txt", elements);
		long actual = QuickSort.sortPivotLast(elements);
		assertEquals(29, actual);
	}

	@Test
	public void tenElement_PivotOnMedian() {
		int[] elements = new int[10];
		readFile("10.txt", elements);
		long actual = QuickSort.sortPivotMedian(elements);
		assertEquals(21, actual);
	}

	
	
	@Test
	public void hundredElement_PivotOnFirst() {
		int[] elements = new int[100];
		readFile("100.txt", elements);
		long actual = QuickSort.sortPivotFirst(elements);
		assertEquals(615, actual);
	}

	@Test
	public void hundredElement_PivotOnLast() {
		int[] elements = new int[100];
		readFile("100.txt", elements);
		long actual = QuickSort.sortPivotLast(elements);
		assertEquals(587, actual);
	}

	@Test
	public void hundredElement_PivotOnMedian() {
		int[] elements = new int[100];
		readFile("100.txt", elements);
		long actual = QuickSort.sortPivotMedian(elements);
		assertEquals(518, actual);
	}



	@Test
	public void thousandElement_PivotOnFirst() {
		int[] elements = new int[1000];
		readFile("1000.txt", elements);
		long actual = QuickSort.sortPivotFirst(elements);
		assertEquals(10297, actual);
	}

	@Test
	public void thousandElement_PivotOnLast() {
		int[] elements = new int[1000];
		readFile("1000.txt", elements);
		long actual = QuickSort.sortPivotLast(elements);
		assertEquals(10184, actual);
	}

	@Test
	public void thousandElement_PivotOnMedian() {
		int[] elements = new int[1000];
		readFile("1000.txt", elements);
		long actual = QuickSort.sortPivotMedian(elements);
		assertEquals(8921, actual);
	}



	@Test
	public void homework_PivotOnFirst() {
		int[] elements = new int[10000];
		readFile("QuickSort.txt", elements);
		long actual = QuickSort.sortPivotFirst(elements);
		assertEquals(162085, actual);
	}

	@Test
	public void homework_PivotOnLast() {
		int[] elements = new int[10000];
		readFile("QuickSort.txt", elements);
		long actual = QuickSort.sortPivotLast(elements);
		assertEquals(164123, actual);
	}

	@Test
	public void homework_PivotOnMedian() {
		int[] elements = new int[10000];
		readFile("QuickSort.txt", elements);
		long actual = QuickSort.sortPivotMedian(elements);
		assertEquals(138382, actual);
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
			// quietly swallowing exception
		}
	}

}
