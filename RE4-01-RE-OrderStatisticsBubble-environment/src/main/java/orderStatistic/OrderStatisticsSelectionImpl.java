package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim poraplciar sucessivas selecoes.
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getEstatisticaOrdem(T[] array, int k) {
		return estatisticaOrdem(array, k - 1);
	}

	private T estatisticaOrdem(T[] array, int k) {
		T estatistica = null;
		if (k == 0) {
			int menor = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i].compareTo(array[menor]) < 0) {
					menor = i;
				}
			}
			estatistica = array[menor];
		} else {
			T menorAnterior = estatisticaOrdem(array, k - 1);
			int menor;
			if (array[0].equals(menorAnterior)) {
				menor = 1;
			} else {
				menor = 0;
			}
			for (int i = 0; i < array.length; i++) {
				if (array[i].compareTo(array[menor]) < 0 && menorAnterior.compareTo(array[i]) < 0) {
					menor = i;
				}
			}
			estatistica = array[menor];
		}
		return estatistica;

	}

}
