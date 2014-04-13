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

	private static void buildMaxHeap(int[] v) {
		for (int i = v.length / 2 - 1; i >= 0; i--){
			maxHeapify(v, i, v.length);
		heapifyCounter++;
		}
	}

	private static void maxHeapify(int[] v, int pos, int n) {
		int maxi;
		int l = 2 * pos + 1;
		int right = 2 * pos + 2;
		if ((l < n) && (v[l] > v[pos])) {
			maxi = l;
		} else {
			maxi = pos;
		}
		comparisonsCounter++;// incrementa o conta comparacoes
		
		if (right < n && v[right] > v[maxi]) {
			comparisonsCounter++;// incrementa o conta comparacoes
			maxi = right;
		}
		if (maxi != pos) {
			swap(v, pos, maxi);
			maxHeapify(v, maxi, n);
		}
	}

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

	public static void setHeapifyCounter(int heapifyCounter) {
		HeapSort.heapifyCounter = heapifyCounter;
	}

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
