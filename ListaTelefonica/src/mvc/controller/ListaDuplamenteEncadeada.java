/*
 * Classe ListaDuplamenteEncadeada
 * 
 * @Source http://treedevelopment.forumeiros.com/t10-modelo-para-implementacao-da-lista-duplamente-encadeada-em-java
 * @Source http://www.caelum.com.br/apostila-java-estrutura-dados/listas-ligadas/#5-17-adicionando-no-comeco-da-lista
 * @Source http://marciohbe.wordpress.com/2009/11/22/lista-duplamente-encadeada-em-java/
 */
package mvc.controller;

import mvc.model.NodoD;

public class ListaDuplamenteEncadeada<T extends Comparable<T>> {

	protected NodoD<T> head;
	protected NodoD<T> tail;

	public ListaDuplamenteEncadeada() {
		head = null;
		tail = null;
	}

	private NodoD<T> procuraNodo(T data) {
		NodoD<T> nodo = head;
		NodoD<T> anterior = null;

		while (nodo != null)  {
			int compara = nodo.getDado().compareTo(data);

			if (compara == 0) {
				return nodo;
			}
			if (compara > 0) {
				return anterior;
			}
			anterior = nodo;
			nodo = nodo.getNext();
		}
		// return nodo;
		return anterior;
	}
	

	public void insert(NodoD<T> novo) {
		// define como anterior o  encontrado ou o proprio
		NodoD<T> anterior = procuraNodo(novo.getDado());

		if (anterior != null) {// se nao for o primeiro ou lista vazia
			novo.setNext(anterior.getNext());// aponta para o proximo do nodo anterior
			anterior.setNext(novo);// define como proximo do anterior o nodo novo
			if (anterior == tail)// se o anterior for a cauda
				tail = novo;// o novo sera definido como cauda
		} else {// senao
			if (tail != null) {// anterior nulo e tail existe = 1 ou mais elementos, adic inicio
				novo.setNext(head);// o proximo do novo e o head
				head = novo; // novo passa a ser o head
			} else {// senao (lista esta vazia)
				head = novo;// define como head o nodo novo
			}
			tail = novo;// define como tail o nodo novo
		}
	}

	
	public String procuraNodoInicial(T data) {
		NodoD<T> nodo = head;
		NodoD<T> anterior = null;
		char inicialBusca = data.toString().charAt(1);

		while (nodo != null) {
			// atributo recebe o primeiro caracter da transf em string do dado
			// do nodo
			char inicialContato = nodo.getDado().toString().charAt(1);

			if (inicialContato == inicialBusca) {
				// System.out.println("Sou o procuraNodo, valores iguais, estou retornando o nodo:"
				// + nodo);
				return nodo.getDado().toString();
			} else {
				anterior = nodo;
				nodo = nodo.getNext();
			}

		}//fim do while

		return anterior.getDado().toString();
	}
	
	
	/*
	 * Metodo print
	 * 
	 * <p>Este metodo apenas percorre e imprime os nodos da lista
	 */
	public void print() {
		NodoD<T> elem = head;
		do {
			System.out.println(elem.getDado());
			elem = elem.getNext();
		} while (elem != null);
	}

}