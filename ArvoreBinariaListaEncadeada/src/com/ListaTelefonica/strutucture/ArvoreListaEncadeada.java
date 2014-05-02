package com.ListaTelefonica.strutucture;

import com.ListaTelefonica.model.*;

public class ArvoreListaEncadeada<T> {

	protected Nodo<T> raiz;

	public ArvoreListaEncadeada() {
		raiz = null;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public void insert(T data) {
		T chave = (T) ((Pessoa) data).getNome();
		System.out.println("nome da pessoa: " + chave);
		if ((raiz) == null) {
			raiz = new Nodo<T>(chave, data);
		} else
			insert(data, raiz);
	}

	public void insert(T data, Nodo<T> atual) {
		T chave = (T) ((Pessoa) data).getNome();

		if (((Pessoa) data).compareTo(atual.getData()) < 0) {
			if (atual.getFilhoDaEsquerda() == null) {
				atual.setFilhoDaEsquerda(new Nodo<T>(chave, data));
			} else {
				insert(data, atual.getFilhoDaEsquerda());
			}
		} else if (((Pessoa) data).compareTo(atual.getData()) > 0) {
			if (atual.getFilhoDaDireita() == null) {
				atual.setFilhoDaDireita(new Nodo<T>(chave, data));
			} else {
				insert(data, atual.getFilhoDaDireita());
			}
		} else {
			System.out.println("Chave repetida, elemento nao sera incluido!");
		}
	}

	/*
	 * public void remove(Nodo<T> nodo) { Nodo<T> ant = nodo.getPrevious();
	 * Nodo<T> next = nodo.getNext(); if (ant != null) ant.setNext(next); else
	 * head = next; if (next != null) next.setPrevious(ant); else tail = ant; }
	 */
}
