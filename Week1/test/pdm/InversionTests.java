package pdm;

import static org.junit.Assert.*;

import org.junit.Test;

public class InversionTests {

	@Test
	public void singleElementArray_hasNoInversion() {
		int[] elements = new int[] { 5 };
		long actual = Inversion.count(elements);
		assertEquals(0, actual);
	}
	
	@Test
	public void twoElementArray_hasNoInversion() throws Exception {
		int[] elements = new int[] { 1, 2 };
		long actual = Inversion.count(elements);
		assertEquals(0, actual);
	}

	@Test
	public void twoElementArray_withOneInversion() throws Exception {
		int[] elements = new int[] { 2, 1 };
		long actual = Inversion.count(elements);
		assertEquals(1, actual);
	}

}
