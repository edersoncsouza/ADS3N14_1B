/*
 * Classe SelectionSort
 * Implementa os metodos para aplicar o algoritmo SelectionSort a um vetor de inteiros.
 * 
 * @author Ederson Souza
 */

public class SelectionSort {
	private static int SelectionSortChangesCounter = 0,
			SelectionSortComparisonsCounter = 0;

	/*
	 * Metodo selectionSort: Executa os testes e chama o metodo para trocar
	 * os elementos de lugar quando necessario.
	 * 
	 * @param vetor: um array de inteiros.
	 */
	public static void selectionSort(int[] vetor) {
		int i, j;
		int menor;

		for (j = 0; j < vetor.length - 1; j++) {
			menor = j;// define como menor o primeiro elemento lido
			
			// segue testando a partir do elemento lido em J
			for (i = j + 1; i < vetor.length; i++) {
				if (vetor[i] < vetor[menor])// caso o elemento seja menor que o menor definido
					menor = i;// define como menor o elemento lido
				SelectionSortComparisonsCounter++;// incrementa o contador de comparacoes
			}

			if (menor != j) {
				swap(vetor, j, menor);
				SelectionSortChangesCounter++;
			}
		}// fim do for J

	}//fim do metodo selectionSort

	/*
	 * Metodo swap: Efetua a troca de lugar dos elementos para ordena-los.
	 * 
	 * @param v: vetor de inteiros
	 * @param j: elemento anteriormente definido como menor, a ser trocado
	 * @param menor: elemento menor detectado
	 * 
	 */
	public static void swap(int[] v, int j, int aposJ) {
		int aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
		System.out.println("Vetor Swapeando:");
		HeapSort.imprimeVetor(v, j, aposJ);
		SelectionSortChangesCounter++;// incrementa o conta trocas
	}

	public static int getSelectionSortChangesCounter() {
		return SelectionSortChangesCounter;
	}

	public static int getSelectionSortComparisonsCounter() {
		return SelectionSortComparisonsCounter;
	}
	
	
	
}
