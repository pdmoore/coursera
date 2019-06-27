package pdm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

	private static long counter = 0;

	public static long sortPivotFirst(int[] elements) {
		counter = 0;
		sortPivotFirst(elements, 0, elements.length);

		System.out.println(Arrays.toString(elements));
		return counter;
	}

	private static void sortPivotFirst(int[] elements, int left, int right) {
		if ((right - left) <= 1)
			return;

		int pivot = partitionPivotFirst(elements, left, right);

		if (left < pivot - 1) {
			counter += pivot - 1 - left;
			sortPivotFirst(elements, left, pivot - 1);
		}
		if (pivot < right) {
			counter += right - pivot;
			sortPivotFirst(elements, pivot, right);
		}

	}

	private static int partitionPivotFirst(int[] elements, int left, int right) {
		int i = left;
		int tmp;
		int pivotVal = elements[left];

		i = left + 1;
		for (int j = (left + 1); j < right; j++) {
			if (elements[j] < pivotVal) {
				tmp = elements[i];
				elements[i] = elements[j];
				elements[j] = tmp;
				i = i + 1;
			}
		}
		tmp = elements[left];
		elements[left] = elements[i - 1];
		elements[i - 1] = tmp;

		return i;

	}

	private static String dumpEls(int[] elements, int start, int end) {
		StringBuffer buff = new StringBuffer();
		buff.append("[");
		while (start < end) {
			buff.append(elements[start]);
			buff.append(" ");
			start++;
		}
		buff.append("]");
		return buff.toString();
	}

	public static long sortPivotLast(int[] elements) {
		counter = 0;
		sortPivotLast(elements, 0, elements.length);

		System.out.println(Arrays.toString(elements));
		return counter;
	}
	
	private static void sortPivotLast(int[] elements, int left, int right) {
		if ((right - left) <= 1)
			return;

		int pivot = partitionPivotLast(elements, left, right);

		if (left < pivot - 1) {
			counter += pivot - 1 - left;
			sortPivotLast(elements, left, pivot - 1);
		}
		if (pivot < right) {
			counter += right - pivot;
			sortPivotLast(elements, pivot, right);
		}
	}

	private static int partitionPivotLast(int[] elements, int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = elements[right - 1];
		
		//swap pivotal element with first element
		tmp = elements[right - 1];
		elements[right - 1] = elements[left];
		elements[left] = tmp;
			
		i = left + 1;
		for (j = (left + 1); j < right; j++) {
			if (elements[j] < pivot) {
				tmp = elements[i];
				elements[i] = elements[j];
				elements[j] = tmp;
				i = i + 1;
			}
		}
		tmp = elements[left];
		elements[left] = elements[i - 1];
		elements[i - 1] = tmp;

		return i;

	}

	public static long sortPivotMedian(int[] elements) {
		counter = 0;
		System.out.println(Arrays.toString(elements));

		sortPivotMedian(elements, 0, elements.length);

		System.out.println(Arrays.toString(elements));
		return counter;
	}

	private static void sortPivotMedian(int[] elements, int left, int right) {
		if ((right - left) <= 1)
			return;

		int pivot = partitionPivotMedian(elements, left, right);

		 System.out.println("pivot: " + pivot + "  " + dumpEls(elements, left, pivot - 1)
		 + " and " + dumpEls(elements, pivot, right));

		if (left < pivot - 1) {
			counter += pivot - 1 - left;
			sortPivotMedian(elements, left, pivot - 1);
		}
		if (pivot < right) {
			counter += right - pivot;
			sortPivotMedian(elements, pivot, right);
		}
	}

	private static int partitionPivotMedian(int[] elements, int left, int right) {
		int firstIx = left;
		int lastIx = right - 1;
		int middleIx = (((right-1) - left)/2)+left;
		
		int pivotIx = medianOfIx(elements, firstIx, lastIx, middleIx);	
		int pivot = elements[pivotIx];
		
		int tmp = elements[left];
		elements[left] = elements[pivotIx];
		elements[pivotIx] = tmp;
		
		int i, j;
		i = left + 1;
		for (j = (i); j < right; j++) {
			if (elements[j] < pivot) {
				tmp = elements[i];
				elements[i] = elements[j];
				elements[j] = tmp;
				i = i + 1;
			}
		}
		tmp = elements[left];
		elements[left] = elements[i - 1];
		elements[i - 1] = tmp;
	
		return pivot;
	}
	
	
	static int medianOfIx(int[] elements, int firstIx, int lastIx, int middleIx) {
		if ((firstIx +1) == lastIx) return lastIx;
		
		int median = medianOf(elements[firstIx], elements[lastIx], elements[middleIx]);
		if (elements[lastIx] == median) return lastIx;
		if (elements[middleIx] == median) return middleIx;
		if (elements[firstIx] == median) return firstIx;
		
		throw new IllegalArgumentException();
	}	
	
	static int medianOf(int first, int last, int middle) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(first);
		numbers.add(last);
		numbers.add(middle);
		Collections.sort(numbers);
		return numbers.get(1);
	}


}
