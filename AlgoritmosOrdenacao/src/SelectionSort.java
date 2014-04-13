public class SelectionSort {
	private static int SelectionSortChangesCounter = 0,
			SelectionSortComparisonsCounter = 0;

	public static void selectionSort(int[] vetor) {
		int i, j;
		int menor;

		for (j = 0; j < vetor.length - 1; j++) {
			menor = j;// define como menor o primeiro elemento lido

			for (i = j + 1; i < vetor.length; i++) {// segue testando a partir
													// do elemento lido em J
				if (vetor[i] < vetor[menor])
					menor = i;
				SelectionSortComparisonsCounter++;
			}

			if (menor != j) {
				swap(vetor, j, menor);
				SelectionSortChangesCounter++;
			}
		}// fim do for J

	}//fim do metodo selectionSort

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
