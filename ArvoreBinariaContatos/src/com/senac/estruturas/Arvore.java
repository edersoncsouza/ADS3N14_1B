package com.senac.estruturas;

public class Arvore<T extends Comparable<T>>{
	
	private Nodo<T> raiz;
	
	public Arvore(){
		raiz = null;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}
	
	
}
