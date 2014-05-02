package com.ListaTelefonica.model;

import com.ListaTelefonica.*;

public class Nodo<T> {
	
	private T chave;
	private T data;
	private Nodo<T> pai;
	private Nodo<T> filhoDaEsquerda;
	private Nodo<T> filhoDaDireita;
	
	public Nodo(T chave, T data)
	{
		this.chave = chave;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public T getChave() {
		return chave;
	}

	public Nodo<T> getFilhoDaEsquerda() {
		return filhoDaEsquerda;
	}

	public void setFilhoDaEsquerda(Nodo<T> filhoDaEsquerda) {
		this.filhoDaEsquerda = filhoDaEsquerda;
	}

	public Nodo<T> getFilhoDaDireita() {
		return filhoDaDireita;
	}

	public void setFilhoDaDireita(Nodo<T> filhoDaDireita) {
		this.filhoDaDireita = filhoDaDireita;
	}

	public Nodo<T> getPai() {
		return pai;
	}

	public void setPai(Nodo<T> pai) {
		this.pai = pai;
	}
	
	
}