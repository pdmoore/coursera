package pdm;

public class BruteForce implements Inversion {

	public long count(int[] elements) {

		return bruteForceCount(elements);
	}

	private long bruteForceCount(int[] elements) {
		long inversionCount = 0;
		for (int i = 0; i < elements.length; i++) {
			for (int j = i; j < elements.length; j++) {
				if (elements[i] > elements[j]) inversionCount++;
			}
		}
		return inversionCount;
	}
}
