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
		countingSort(array, leftIndex, rightIndex);
		
	}
	
	private void countingSort(Integer[] array, int leftIndex, int rightIndex) {
		
		// Sets váriaveis auxiliares
		Integer[] novoArray = new Integer[array.length];
		int maiorNum =0;
		
		// Achando o maior número presente no array
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(maiorNum) == 1)
				maiorNum = array[i];
		}
		
		// Set contador no lenght do máximo inteiro presente no array
		Integer[] contador = new Integer[maiorNum];
		
		for (int i = 0; i < array.length; i++) {
			contador[array[i]] += 1;
		}
		
		// Soma acumulativa
		for (int j = 1; j <= contador.length; j++) {
			contador[j] = contador[j] + contador[j -1];
		}
		
		// Setar no novo array
		for (int k = 0; k < contador.length; k++) {
			
		}
		
	}

}
