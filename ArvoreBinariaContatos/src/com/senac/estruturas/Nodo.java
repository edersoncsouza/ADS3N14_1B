package com.senac.estruturas;

import com.senac.apps.ArvoreListaTelefonica.model.Pessoa;

public class Nodo<T> {
	private T chave, data;
	private Nodo<T> filhoEsquerda, filhoDireita;
	
	public Nodo(T chave)
	{
		this.chave = chave;
		this.data = null;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	public T getChave() {
		return chave;
	}
	
	public T getData() {
		return data;
	}

	public Nodo<T> getFilhoEsquerda() {
		return filhoEsquerda;
	}

	public Nodo<T> getFilhoDireita() {
		return filhoDireita;
	}
	
	public void setChave(T chave) {
		this.chave = chave;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void setFilhoEsquerda(Nodo<T> filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}

	public void setFilhoDireita(Nodo<T> filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
}