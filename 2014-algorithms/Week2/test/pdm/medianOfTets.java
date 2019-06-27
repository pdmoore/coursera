package pdm;

import org.junit.Assert;
import org.junit.Test;

public class medianOfTets {

	@Test
	public void testFirstIsMedian() {
		int actual = QuickSort.medianOf(1, 0, 2);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void testSecondIsMedian() {
		int actual = QuickSort.medianOf(1, 5, 10);
		Assert.assertEquals(5, actual);
	}

	@Test
	public void testThirdIsMedian() {
		int actual = QuickSort.medianOf(1, 5, 3);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void testDescending() {
		int actual = QuickSort.medianOf(7, 5, 6);
		Assert.assertEquals(6, actual);
	}

	@Test
	public void testSameLow() {
		int actual = QuickSort.medianOf(1, 2, 1);
		Assert.assertEquals(1, actual);
	}
	
	@Test
	public void testSameHigh() {
		int actual = QuickSort.medianOf(6, 5, 6);
		Assert.assertEquals(6, actual);
	}
	

}
