import java.util.Arrays;


public class QuickSort {

    private static long counter = 0;
    
	public static long sortPivotFirst(int[] elements) {
        counter = 0;
        sortPivotFirst(elements, 0, elements.length);

//        System.out.println(Arrays.toString(elements));
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
}
