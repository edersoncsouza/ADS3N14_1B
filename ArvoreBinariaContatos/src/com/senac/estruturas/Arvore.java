package com.senac.estruturas;

public class Arvore<T extends Comparable<T>>{
	
	private Nodo<T> raiz;
	
	public Arvore(){
		raiz = null;
	}
	
	
	private Nodo<T> insert (Nodo<T> novo, T chave){
		if (novo == null){
			return new Nodo<T>(chave, null, null);
		}
		if(novo.getChave().equals(chave)){
			System.out.println("Chave duplicada, nao sera incluida na arvore!");
		}
		
		if (chave.compareTo(novo.getChave()) < 0) {
	        // adiciona a chave a sub-arvore esquerda
	        novo.setFilhoEsquerda(insert(novo.getFilhoEsquerda(),chave));
	        return novo;
	    }
		else{// adiciona a chave a sub-arvore direita
			novo.setFilhoDireita(insert(novo.getFilhoDireita(),chave));
			return novo;
		}
		
	}
	
	/*
	private T insert(Nodo<T> novo, chave){
		T dado, temp = null;
		
		if (raiz == null) 
			raiz = novo;
		if (raiz != null)
				if(novo. .getData().compareTo(raiz.getData()) < 0)
					raiz.setFilhoDireita(dado = insert(novo));
				else
					if(novo.getData().compareTo(raiz.getData()) > 0)
						raiz.setFilhoEsquerda(dado = insert(novo));
		return temp;
		}
	
	*/

	
	
	public Nodo<T> procuraNodo(Nodo<T> needle)
	{
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
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
	public void append(Nodo<T> novo)
	{
		insert(novo);
	}
	
	
	
	public void inserir(int c) {  
        if (c < chave) {  
            if (esq == null)  
                esq = new NoArvore(c);  
            else  
                esq.inserir(c);  
        } else if (c > chave) {  
            if (dir == null)  
                dir = new NoArvore(c);  
            else  
                dir.inserir(c);  
        } else  
            JOptionPane.showMessageDialog(null, "Chave duplicada. Impossível inserir!");  
    } // fim do metodo inserir  
	
	
}
