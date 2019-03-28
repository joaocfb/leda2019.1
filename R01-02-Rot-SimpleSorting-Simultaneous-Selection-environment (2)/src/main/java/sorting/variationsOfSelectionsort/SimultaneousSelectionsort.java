package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int menorIndex = leftIndex;
		int maiorIndex = rightIndex;

		for (int i = leftIndex; i <= rightIndex; i++) {
			for (int j = i; j <= rightIndex; j++) {
				if (array[j].compareTo(array[menorIndex]) == -1) {
					menorIndex = j;
				}
			}
			util.Util.swap(array, menorIndex, i);
		}
		for (int k = rightIndex; k < leftIndex; k--) {
			for (int l = k; l >= leftIndex; l--) {
				if (array[l].compareTo(array[maiorIndex]) == 1) {
					maiorIndex = l;
				}
			}
			util.Util.swap(array, maiorIndex, k);
		}
	}
}