package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int menorIndex = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			for (int j = i; j <= rightIndex; j++) {
				if (array[j].compareTo(array[menorIndex]) == -1) {
				menorIndex = i;
				}
			}
			util.Util.swap(array, menorIndex,i);
		}



	}
}
