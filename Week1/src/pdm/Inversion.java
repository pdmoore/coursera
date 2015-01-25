package pdm;

public class Inversion {

	public static long count(int[] elements) {

		return bruteForceCount(elements);

	}

	private static long bruteForceCount(int[] elements) {
		long inversionCount = 0;
		for (int i = 0; i < elements.length; i++) {
			for (int j = i; j < elements.length; j++) {
				if (elements[i] > elements[j]) inversionCount++;
			}
		}
		return inversionCount;
	}

}
