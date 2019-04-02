 package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex,middleIndex);
			sort(array, middleIndex + 1, rightIndex);
			mergeSort(array, leftIndex, middleIndex, rightIndex);
		}
		
	}

	private void mergeSort(T[] array, int firstIndex, int middleIndex, int lastIndex) {
		@SuppressWarnings("unchecked")
		T[] array_aux = (T[]) new Comparable[array.length];
		
		for (int i = firstIndex; i <= lastIndex; i++) {
			array_aux[i] = array[i];
		}
		
		int x = firstIndex;
		int y = middleIndex + 1;
		
		for (int i = firstIndex; i <= lastIndex; i++) {
			if (x > middleIndex) {
				//util.Util.swap(array, i, y++);
				array[i] = array_aux[y++];
			} else if (y > lastIndex) {
				//util.Util.swap(array, i, x++);
				array[i] = array_aux[x++];
			} else if (array_aux[x].compareTo(array_aux[y]) == -1) {
				//util.Util.swap(array, i, x++);
				array[i] = array_aux[x++];
			} else {
				//util.Util.swap(array, i, y++);
				array[i] = array_aux[y++];
			}
		}
		
	}

}
