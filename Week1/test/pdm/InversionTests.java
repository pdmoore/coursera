package pdm;

import static org.junit.Assert.*;

import org.junit.Test;

public class InversionTests {

	@Test
	public void singleElementArray_hasNoInversions() {
		int[] elements = new int[] { 5 };
		long actual = Inversion.count(elements);
		assertEquals(0, actual);
	}

}
