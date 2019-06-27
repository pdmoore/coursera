package pdm;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.TreeSet;

import org.junit.Test;

public class UniqueIntegers {

	@Test
	public void OnlyUniqueIntegersAreRetained() {
		String[] input = new String[] {"-10001", "1", "2", "-10001", "9999" };

		Collection<Integer> result = populateInput(input);
		
		assertEquals(4, result.size());
	}

	private Collection<Integer> populateInput(String[] input) {
		TreeSet<Integer> ints = new TreeSet<Integer>();

		for (String string : input) {
			ints.add(Integer.parseInt(string));
		}
			
		return ints;
	}

}
