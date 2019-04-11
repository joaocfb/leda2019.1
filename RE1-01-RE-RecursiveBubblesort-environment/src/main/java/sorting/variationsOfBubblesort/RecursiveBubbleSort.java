package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */


public class RecursiveBubbleSort<T extends Comparable<T>> {

    public static void sort(int[] array, int leftIndex, int rightIndex) {
        if (rightIndex == 1) return;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        sort(array, leftIndex,rightIndex -1);

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int[] arr;
        arr = new int[] {64, 34, 25, 12, 22, 11, 90};
        sort(arr, 0, arr.length);

        System.out.println("Sorted array : ");
        System.out.println(arr);
    }

}
