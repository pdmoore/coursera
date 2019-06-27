package pdm;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TwoSumTests {

	@Test
	public void test() {
		TreeSet<Integer> ints = new TreeSet<Integer>();
		ints.add(-10001);
		ints.add(1);
		ints.add(2);
		ints.add(9999);

		int result = toSum(ints);
	
		assertEquals(5, result);
	}

	private int toSum(TreeSet<Integer> ints) {
		TreeSet<Integer> found = new TreeSet<Integer>();
		
		for (int t = -10000; t <= 10000; t++) {
			for (Iterator<Integer> iterator = ints.iterator(); iterator.hasNext();) {
				Integer a = (Integer) iterator.next();
				int target = t - a.intValue();
				if ((target != a) && ints.contains(target)) {
					found.add(t);
					break;
				}
			}
		}
		
		return found.size();
	}

}
