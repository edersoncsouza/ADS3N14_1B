//http://www.mcs.csueastbay.edu/~bhecker/Previous%20Terms/CS-3240-Fall13/Examples/BinaryTree-2.java

package com.ListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.ListaTelefonica.model.*;
import com.ListaTelefonica.view.*;

public class Arvore <T extends Comparable<T>>{

	public ConsoleView view;
	private Nodo<T> raiz;
	
	
	public Arvore(ConsoleView view) {
		this.view = view;
	}
	
	
	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	/*
	 * public void insert(Pessoa pessoa) {
		T chave=(T) ( (Pessoa) pessoa).getNome();
		raiz = insert(chave, raiz);
	}

	private Nodo<T> insert(T chave, Nodo<T> nodo) {
		if (nodo == null) {
			nodo = new Nodo<T>(chave);
		} else if (chave.compareTo(nodo.getChave()) < 0)
			// adiciona a chave a sub-arvore esquerda
			nodo.setFilhoEsquerda(insert(chave, nodo));
		else if (chave.compareTo(nodo.getChave()) > 0)
			// adiciona a chave a sub-arvore direita
			nodo.setFilhoDireita(insert(chave, nodo));
		else
			System.out.println("Chave duplicada : " + chave.toString());
		return nodo;
	}
	 */
	
	
	public void insereNodo(T chave, T data) {
		Nodo<T> novo = new Nodo<T>(chave, data);
		if (raiz == null) {
			raiz = novo;
		}
		else{
			Nodo<T> atual = raiz;
			Nodo<T> pai;

			while (true) {// While perpetuo 
				pai = atual;// atual comeca valendo raiz

				// Check if the new node should go on  the left side of the parent node
				if (chave.compareTo(atual.getChave()) < 0)
					// Switch focus to the left child
					atual = atual.getFilhoDaEsquerda();

					// If the left child has no children
					if (atual == null) {
						// then place the new node on the left of it
						pai.setFilhoDaEsquerda(novo);
						return; // All Done
					}
					// If we get here put the node on the right
					else
						atual = atual.getFilhoDaDireita();

						// If the right child has no children
						if (atual == null) {
							// then place the new node on the right of it
							pai.setFilhoDaDireita(novo);
						return; // All Done
					}	
				}
		}//fim do while perpetuo
	}//fim do metodo insereNodo
	
	
	public void insertContato() {

		String name = (view.readString("Nome"));
		String phone = (view.readString("Telefone"));
		
		Pessoa<T> pessoa = new Pessoa(name);
		pessoa.setTelefone(phone);
		
		T chave = (T) name;
		
		if (!name.startsWith("#"))
			insereNodo(chave, (T) pessoa);
	}

	
	public void loadFile(String filename) {
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while(arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				Pessoa<T> pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);
				
				T chave = (T) name;
				
				if (!name.startsWith("#"))
					insereNodo(chave, (T) pessoa);

			}
			//current = contatos.getHead();
		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
		//fillArray(listSize);
	}

	/*
	public void fillArray(int tamanho){
		Nodo<Pessoa> contatoAtual = contatos.getHead();
		vetorPessoas = new Pessoa[tamanho];
		int cont=0;
			
		//while(cont < tamanho){//enquanto o contador for menor que o tamanho do vetor
		while(contatoAtual != null){
			vetorPessoas[cont] = contatoAtual.getData();//adiciona os dados do nodo a uma posicao do vetor

			contatoAtual = contatoAtual.getNext();//avanca para o proximo nodo
			cont++;//incrementa o contador para o vetor
		}
	}
	
	public void showContato() {
		Nodo<T> atual;
		if (atual == null) {
			view.message("Nenhum contato existente.");
		} else {
			Pessoa contato = atual.getData();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}

	public void removeContato() {
		if (current != null) {
			contatos.remove(current);
			nextContato();
		}
	}

	private Nodo<Pessoa> procuraContato(ListaEncadeada<Pessoa> lista, String chave)
	{
		Nodo<Pessoa> iter = lista.getHead();
		while (iter != null) {
			Pessoa contato = iter.getData();
			String nome = contato.getNome().toLowerCase();
			if (nome.startsWith(chave)) {
				return iter;
			}
			iter = iter.getNext();
		}
		return null;
	}
	
	private Pessoa procuraContatoBinario(String chave)
	{
		int limiteSuperior = vetorPessoas.length-1;
		int limiteInferior = 0; 
		int contador=0;
		int indice=0;//utilizado para fins de comparacao com a pesquisa linear
		int meio=0;
		Pessoa atual=null;
		
		do{
				if (limiteSuperior < 0){
					atual=null;
				}else{
					
					contador++;//incrementa o contador das buscas efetuadas
					meio = (limiteInferior + limiteSuperior)/2;//calcula o meio do vetor para comecar a busca
					System.out.println("Meio: " + meio);
					atual = vetorPessoas[meio];//armazena a pessoa da casa do meio
					
					int cmp = chave.compareTo(vetorPessoas[meio].getNome().substring(0,1));//compara o nome da pessoa com a chave (letra inicial)
					
				if (cmp == 0){
					currentBinario = atual; //se o inicial for a mesma retorna
					atual = null;
					indice=meio;//pois a leitura e sempre da posicao "do meio"
					showContatoBinario(contador, indice);//como esse metodo nao trabalha com o tipo Nodo, possui um show proprio
					//return atual;
				}
				if (cmp < 0)
					limiteSuperior=meio-1;//se o inicial for menor reduz a pesquisa a primeira metade
				if (cmp > 0)
					limiteInferior = meio+1;//se o inicial for maior reduz a pesquisa a segunda metade
				
			}
		}while (atual != null);
		return null;
	}
	

	public void searchContato(String tipo) {
		String chave = view.read("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = null;
			
		if(tipo.equals("sequencial"))
		contato = procuraContato(contatos, chave);
		
		if (tipo.equals("binario"))//caso seja do tipo binario, chama metodo proprio
		procuraContatoBinario(chave);
		
		if (contato != null)
			current = contato;
	}
*/

	/*
	public void saveFile(String filename) {
		FileWriter arq = null;
		try {
			arq = new FileWriter(filename,false);
			Nodo<Pessoa> iter = arquivo.getHead();
			while (iter != null) {
				Pessoa contato = iter.getData();
				if (procuraContato(contatos, contato.getNome()) == null)
					arq.append("#"+contato.getNome()+"\n");
				else
					arq.append(contato.getNome()+"\n");
				arq.append(contato.getTelefone()+"\n");
				iter = iter.getNext();
			}
		} catch (IOException e) {
			view.message(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					view.message(e.getMessage());
				}
		}
	}
*/
}
