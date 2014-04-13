/*
 * Outro codigo a testar: http://www.youtube.com/watch?v=W81Qzuz4qH0
 * 
 */
public class Principal {

	public static void main(String[] args) {
		//Algoritmos algoritmo = new Algoritmos();
		int[] vetorInteiros = {9,2,8,1,10,4,3,6,5,7,11,-1,-6,0};
		HeapSort.heapSort(vetorInteiros);
		
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
		System.out.println("#### Algoritmo Selection Sort ####");
		
	}

}
