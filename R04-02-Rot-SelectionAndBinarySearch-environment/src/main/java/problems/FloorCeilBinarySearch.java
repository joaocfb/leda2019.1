package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int prox = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				return array[i];
			} else if (array[i] < x && array[i] > prox) {
				prox = array[i];
			}
		}
		return prox;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int prox = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				return array[i];
			} else if (array[i] > x) {
				if (array[i - 1] < x) {
					prox = array[i];
				}
			}
		}
		return prox;
	}

}
