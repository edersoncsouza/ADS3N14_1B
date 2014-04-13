/*
 * Classe Principal
 * Chama os metodos estaticos e mensagens de comparacao.
 * 
 * @author Ederson Souza
 */
public class Principal {

	public static void main(String[] args) {

		int[] vetorInteirosHeapSort = {14,-2,9,8,1,-3,10,-4,4,0,13,-5,15,6,5,7,11,-1,2,3,12};
		int[] vetorInteirosSelectionSort = {14,-2,9,8,1,-3,10,-4,4,0,13,-5,15,6,5,7,11,-1,2,3,12};
		HeapSort.heapSort(vetorInteirosHeapSort);
		
		System.out.println();System.out.println();
		System.out.println("#### COMPARACAO ENTRE ALGORITMOS ####");
		System.out.println();
		System.out.println("Dado um vetor: [9,2,8,1,10,4,3,6,5,7]");
		System.out.println();
		System.out.println("#### Algoritmo Heap Sort ####");
		System.out.println("Numero de trocas preparatorias(HeapMax): "+ HeapSort.getHeapifyCounter());
		System.out.println("Numero de comparacoes: "+ HeapSort.getComparisonsCounter());
		System.out.println("Numero de trocas: "+ HeapSort.getChangesCounter());
		System.out.println();
		

		
		SelectionSort.selectionSort(vetorInteirosSelectionSort);
		System.out.println("#### Algoritmo Selection Sort ####");
		System.out.println("Numero de comparacoes: "+ SelectionSort.getSelectionSortComparisonsCounter());
		System.out.println("Numero de trocas: "+ SelectionSort.getSelectionSortChangesCounter());
	}

}
