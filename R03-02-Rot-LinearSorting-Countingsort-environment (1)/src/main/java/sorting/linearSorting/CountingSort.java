package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 1) 
			countingSort(array, leftIndex, rightIndex);
		
	}
	
	private void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[getIndiceDoMaiorElemento(array, leftIndex, rightIndex)];
		Integer[] contador = new Integer[maior + 1];
		Integer[] arrayOrdenado = new Integer[array.length];
		for (int i = 0; i < contador.length; i++) {
			contador[i] = 0;
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			contador[array[i]]++;
		}
		for(int i = 1; i < contador.length; i++){
			contador[i] += contador[i - 1];
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			arrayOrdenado[--contador[array[i]]] = array[i];
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayOrdenado[i - leftIndex];
		}		
		
	}

	private int getIndiceDoMaiorElemento(Integer[] array, int leftIndex, int rightIndex) {
		int maiorIndex = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[maiorIndex] < array[i]) {
				maiorIndex = i;
			}
		}
		return maiorIndex;
	}

	

}
