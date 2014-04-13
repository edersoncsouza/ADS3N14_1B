/*
 * Classe HeapSort
 * Implementa os metodos para aplicar o algoritmo HeapSort a um vetor de inteiros.
 * 
 * @author Ederson Souza
 */

public class HeapSort {
	private static int changesCounter=0, comparisonsCounter=0, heapifyCounter = 0;;
	
	public static void heapSort(int[] v){
		System.out.println("##### ALGORITMO HEAP SORT #####");
		System.out.println("Vetor Original:");
		imprimeVetor(v,0,v.length-1);
		
		buildMaxHeap(v);// transforma o vetor recebido em um MaxHeap
		
		System.out.println("########## Vetor Heapficado ##########");
		imprimeVetor(v,0,v.length-1);
		System.out.println("######################################");
		
		int n = v.length;// infere o tamanho do vetor

		for (int i = v.length - 1; i > 0; i--) {
			swap(v, i, 0);
			maxHeapify(v, 0, --n);
		}
	}

	/*
	 * Metodo builMaxHeap
	 * Transforma o vetor recebido em uma arvore com a regra MaxHeap
	 * 
	 * @param v: vetor de inteiros
	 */
	private static void buildMaxHeap(int[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--){
			maxHeapify(v, i, v.length);
		heapifyCounter++;
		}
	}

	/*
	 * Metodo maxHeapify
	 * Corrige o vetor alterado recebido para mante-lo com a regra MaxHeap
	 * 
	 * @param v: vetor de inteiros
	 * @param pos: elemento lido
	 * @param n: tamanho do vetor
	 */
	
	private static void maxHeapify(int[] v, int pos, int n) {
		int maxi;
		int l = 2 * pos + 1;// no filho da esquerda
		int right = 2 * pos + 2;// no filho da direita
		if ((l < n) && (v[l] > v[pos])) {// se l nao for o ultimo no e for maior que o pai
			maxi = l;// no maximo recebe o conteudo do filho da esquerda
		} else {
			maxi = pos;// no maximo recebe o conteudo lido
		}
		comparisonsCounter++;// incrementa o conta comparacoes
		
		if (right < n && v[right] > v[maxi]) {// se right (filho da direita) nao for o ultimo no e for maior que o pai
			comparisonsCounter++;// incrementa o conta comparacoes
			maxi = right;// no maximo recebe o conteudo do filho da direita
		}
		if (maxi != pos) {// caso o mo maximo ja nao for o o conteudo lido
			swap(v, pos, maxi);
			maxHeapify(v, maxi, n);
		}
	}

	/*
	 * Metodo swap: Efetua a troca de lugar dos elementos para ordena-los.
	 * 
	 * @param v: vetor de inteiros
	 * @param j: elemento anteriormente definido como menor, a ser trocado
	 * @param aposJ: elemento menor detectado
	 * 
	 */
	public static void swap(int[] v, int j, int aposJ) {
		int aux = v[j];
		v[j] = v[aposJ];
		v[aposJ] = aux;
		System.out.println("Vetor Swapeando:");
		imprimeVetor(v,j,aposJ);
		changesCounter++;// incrementa o conta trocas
	}

	public static int getChangesCounter() {
		return changesCounter;
	}

	public static int getComparisonsCounter() {
		return comparisonsCounter;
	}
	
	public static int getHeapifyCounter() {
		return heapifyCounter;
	}

/*
 * Metodo imprimeVetor
 * Imprime o vetor recebido destacando os valores que estao em swap no momento
 * 
 * @param vetor: vetor de inteiros
 * @param j: primeiro valor selecionado para troca
 * @param aposJ: segundo valor selecionado para troca
 */
	public static void imprimeVetor(int[] vetor, int j, int aposJ){
		StringBuffer stringVetor = new StringBuffer();
		for (int i = 0; i < vetor.length; i++) {
			if (i == j || i == aposJ)
					stringVetor.append("<"+vetor[i]+">"+" ");
			else
			stringVetor.append(vetor[i]+" ");
		
		}
	System.out.println(stringVetor);
	}
}
