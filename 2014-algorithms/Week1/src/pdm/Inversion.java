package pdm;

import java.util.Arrays;

public class Inversion {

	public static long count(int[] elements) {
		
//		return bruteForce(elements);
		
		return recursiveCount(elements, elements.length);
		
	}

	private static long recursiveCount(int[] elements, int length) {
		if (length == 1) return 0;
		
		int pivotIndex = length / 2;
		int[] leftHalf  = Arrays.copyOfRange(elements, 0, pivotIndex);
		int[] rightHalf = Arrays.copyOfRange(elements, pivotIndex, elements.length);
		long x = recursiveCount(leftHalf, leftHalf.length);
		long y = recursiveCount(rightHalf, rightHalf.length);
		Arrays.sort(leftHalf);
		Arrays.sort(rightHalf);;
		long z = countSplitInversions(leftHalf, rightHalf);
		
		return x+y+z;

	}


	private static long countSplitInversions(int[] leftHalf, int[] rightHalf) {
		int length = leftHalf.length + rightHalf.length;
		int i = 0;
		int j = 0;
		long inversions = 0;
		for (int k = 0; k < length; k++) {
			if (i < leftHalf.length) { 
				if ((j >= rightHalf.length) || (leftHalf[i] < rightHalf[j])) {
					i++;
				} else if (j < rightHalf.length) {
					inversions += leftHalf.length - i;
					j++;
				}
			}
		}
		
		return inversions;
	}

	private static long bruteForce(int[] elements) {
		long inversion = 0;
		for (int i = 0; i < elements.length; i++) {
			for (int j = i; j < elements.length; j++) {
				if (elements[i] > elements[j]) inversion++;
			}
		}
		return inversion;
	}

	

}
