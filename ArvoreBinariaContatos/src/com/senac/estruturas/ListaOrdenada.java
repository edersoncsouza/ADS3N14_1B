package com.senac.estruturas;

public class ListaOrdenada<T extends Comparable<T>>
				extends ListaEncadeada<T>
{	
	/*
	public NodoListaEncadeada<T> procuraNodo(NodoListaEncadeada<T> needle)
	{
		NodoListaEncadeada<T> atual = getHead();
		NodoListaEncadeada<T> anterior = null;
		T chaveNeedle = needle.getData();
		
		while (atual != null) {
			T chaveAtual = atual.getData();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}
	
	@Override
	public void append(NodoListaEncadeada<T> novo)
	{
		insert(novo);
	}
	
	@Override
	public void insert(NodoListaEncadeada<T> novo, NodoListaEncadeada<T> anterior)
	{
		insert(novo);
	}
	
	@Override
	public void insert(NodoListaEncadeada<T> novo)
	{
		NodoListaEncadeada<T> anterior = procuraNodo(novo);
		
		if (anterior == null) {
			novo.setNext(head);
			if (head != null)
				head.setPrevious(novo);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			NodoListaEncadeada<T> prox = anterior.getNext(); 
			novo.setNext(prox);
			novo.setPrevious(anterior);
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
			else
				prox.setPrevious(novo);
		}
	}
	*/
}
