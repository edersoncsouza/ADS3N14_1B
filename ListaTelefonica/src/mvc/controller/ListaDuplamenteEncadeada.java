/*
 * Classe ListaDuplamenteEncadeada
 * 
 * @Source http://treedevelopment.forumeiros.com/t10-modelo-para-implementacao-da-lista-duplamente-encadeada-em-java
 * @Source http://www.caelum.com.br/apostila-java-estrutura-dados/listas-ligadas/#5-17-adicionando-no-comeco-da-lista
 * @Source http://marciohbe.wordpress.com/2009/11/22/lista-duplamente-encadeada-em-java/
 */

package mvc.controller;

import mvc.model.NodoD;

public class ListaDuplamenteEncadeada<T> {

	protected NodoD<T> head;
	protected NodoD<T> tail;

	
	public ListaDuplamenteEncadeada() {
		head = null;
		tail = null;
	}

	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo insere um novo nodo no final(direita) da lista
	 * 
	 * @param <novo> Nodo de tipo generico Nodo<T>
	 */
	public void insert(NodoD<T> novo) {
		novo.setNext(head);// define, no novo nodo, o head atual como o proximo
							// nodo
		head = novo;// define o novo nodo como o head da lista
		if (tail == null)// caso o fim da lista seja nulo (list vazia)
			tail = novo;// novo nodo sera tambem o fim da lista
	}

	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo insere um novo nodo depois de um nodo especifico da lista
	 * 
	 * @param <novo> Nodo de tipo generico Nodo<T>
	 * 
	 * @param <anterior> Nodo de tipo generico Nodo<T>
	 */
	public void insert(NodoD<T> novo, NodoD<T> anterior) {
		novo.setNext(anterior.getNext());// aponta para o proximo do nodo
											// anterior
		anterior.setNext(novo);// define como proximo do anterior o nodo novo
		if (anterior == tail)// se o anterior for a cauda
			tail = novo;// o novo sera definido como cauda
	}

	/*
	 * Metodo append
	 * 
	 * <p>Este metodo insere um novo nodo no final(tail) da lista
	 * 
	 * @param <novo> Nodo de tipo generico Nodo<T>
	 * 
	 * @param <anterior> Nodo de tipo generico Nodo<T>
	 */
	public void append(NodoD<T> novo) {
		if (tail != null)// se a lista nao esta vazia
			tail.setNext(novo);// define proximo nodo do tail como o nodo novo
		else
			// lista vazia
			head = novo;// nodo novo definido como head
		tail = novo;// nodo novo definido como tail
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