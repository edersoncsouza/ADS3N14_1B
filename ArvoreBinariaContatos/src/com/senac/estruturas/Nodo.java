package com.senac.estruturas;

public class Nodo<T> {
	private T chave;
	private Nodo<T> filhoEsquerda, filhoDireita;
	
	public Nodo(T chave)
	{
		this.chave = chave;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	public T getChave() {
		return chave;
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

	public void setFilhoEsquerda(Nodo<T> filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}

	public void setFilhoDireita(Nodo<T> filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	
}