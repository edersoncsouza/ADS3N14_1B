package mvc.controller;

import mvc.model.Nodo;

public class ListaEncadeada<T> {

	protected Nodo<T> head;
	protected Nodo<T> tail;

	
	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo insere um novo nodo no final(direita) da lista
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 */
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);//define, no novo nodo, o head atual como o proximo nodo
		head = novo;//define o novo nodo como o head da lista
		if (tail == null)//caso o fim da lista seja nulo (list vazia)
			tail = novo;//novo nodo sera tambem o fim da lista
	}

	
	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo insere um novo nodo depois de um nodo especifico da lista
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 * @param <anterior> Nodo de tipo generico Nodo<T>
	 */
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		novo.setNext(anterior.getNext());//aponta para o proximo do nodo anterior
		anterior.setNext(novo);//define como proximo do anterior o nodo novo
		if (anterior == tail)//se o anterior for a cauda
			tail = novo;//o novo sera definido como cauda
	}

	
	/*
	 * Metodo append
	 * 
	 * <p>Este metodo insere um novo nodo no final(tail) da lista
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 * @param <anterior> Nodo de tipo generico Nodo<T>
	 */
	public void append(Nodo<T> novo)
	{
		if (tail != null)//se a lista nao esta vazia
			tail.setNext(novo);//define proximo nodo do tail como o nodo novo
		else//lista vazia
			head = novo;//nodo novo definido como head
			tail = novo;//nodo novo definido como tail
	}

	/*
	 * Metodo print
	 * 
	 * <p>Este metodo apenas percorre e imprime os nodos da lista
	 */
	public void print() {
		Nodo<T> elem = head;
		do {
			System.out.println(elem.getData());
			elem = elem.getNext();
		} while (elem != null);		
	}

}