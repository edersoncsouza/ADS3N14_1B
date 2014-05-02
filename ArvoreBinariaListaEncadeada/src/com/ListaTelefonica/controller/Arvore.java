//http://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
//http://www.mcs.csueastbay.edu/~bhecker/Previous%20Terms/CS-3240-Fall13/Examples/BinaryTree-2.java
//http://rosettacode.org/wiki/Tree_traversal#Java
//http://mattcb.blogspot.com.br/2012/12/binary-search-tree-serialize-and.html

package com.ListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.ListaTelefonica.model.*;
import com.ListaTelefonica.view.*;

public class Arvore<T extends Comparable<T>> {

	public ConsoleView view;
	private Nodo<T> root, current;

	public Arvore(ConsoleView view) {
		this.view = view;
		this.root = null;
	}

	public Nodo<T> getRaiz() {
		return root;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.root = raiz;
	}

	public boolean isEmpty() {
		Boolean empty;
		if (root != null)
			empty = false;
		else
			empty = true;
		return empty;
	}

	public void postorder() {
		if (!isEmpty())
			postorder(root);
		else
			System.out.println("Arvore vazia.");
	}

	public void postorder(Nodo<T> nodo) {
		if (nodo != null) {
			postorder(nodo.getFilhoDaEsquerda());
			postorder(nodo.getFilhoDaDireita());

			Pessoa<T> contato = (Pessoa<T>) nodo.getData();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}

	public void preorder() {
		if (!isEmpty())
			preorder(root);
		else
			System.out.println("Arvore vazia.");
	}

	public void preorder(Nodo<T> nodo) {
		if (nodo != null) {
			Pessoa<T> contato = (Pessoa<T>) nodo.getData();
			view.printContato(contato.getNome(), contato.getTelefone());

			preorder(nodo.getFilhoDaEsquerda());
			preorder(nodo.getFilhoDaDireita());
		}
	}

	public void inorder() {
		if (!isEmpty())
			inorder(root);
		else
			System.out.println("Arvore vazia.");
	}

	public void inorder(Nodo<T> nodo) {
		if (nodo != null) {
			inorder(nodo.getFilhoDaEsquerda());

			Pessoa<T> contato = (Pessoa<T>) nodo.getData();
			view.printContato(contato.getNome(), contato.getTelefone());

			inorder(nodo.getFilhoDaDireita());
		}
	}

	public void levelorder() {
		if (!isEmpty())
			levelorder(root);
		else
			System.out.println("Arvore vazia.");
	}

	public void levelorder(Nodo<T> nodo) {
		Queue<Nodo<T>> enfileraNodo = new LinkedList<Nodo<T>>();
		if (nodo != null)
			enfileraNodo.add(nodo);
		while (!enfileraNodo.isEmpty()) {
			Nodo<T> next = enfileraNodo.remove();

			showContact(next);
			// System.out.print(next.getData() + " ");

			if (next.getFilhoDaEsquerda() != null) {
				enfileraNodo.add(next.getFilhoDaEsquerda());
			}
			if (next.getFilhoDaDireita() != null) {
				enfileraNodo.add(next.getFilhoDaDireita());
			}
		}
	}

	public void showRoot() {
		T contactT = root.getData();
		Pessoa contact = (Pessoa) contactT;
		view.printContato(contact.getNome(), contact.getTelefone());
	}

	public void showContact(Nodo<T> nodo) {
		T contactT = nodo.getData();
		Pessoa contact = (Pessoa) contactT;
		view.printContato(contact.getNome(), contact.getTelefone());
	}

	public void locate() {
		Nodo<T> foundNode = null;
		Pessoa<T> contact = null;

		T key = (T) view.read("Nome do contato").toLowerCase();

		foundNode = locate(root, key);

		if (foundNode != null) {
			contact = (Pessoa<T>) foundNode.getData();
			view.printContato(contact.getNome(), contact.getTelefone());
		} else
			view.printContato("Contato nao encontrado",
					"Telefone nao encontrado");
	}

	public Nodo<T> locate(Nodo<T> t, T key) {

		if (t == null || key.equals(t.getChave()))// == t.getChave())
			return t;
		else if (key.compareTo(t.getChave()) < 0)
			return locate(t.getFilhoDaEsquerda(), key);
		else
			return locate(t.getFilhoDaDireita(), key);
	}

	public void searchContact() {
		T data = null;
		Pessoa<T> contact = null;

		T key = (T) view.read("Nome do contato").toLowerCase();

		if (root == null)// caso nao existam nodos
			view.printContato("Arvore vazia!", null);
		else
			contact = searchContact(root, key);
		if (contact != null)
			view.printContato(contact.getNome(), contact.getTelefone());
		else
			view.printContato("Contato nao encontrado", null);
	}

	public Pessoa<T> searchContact(Nodo<T> parent, T key) {
		Pessoa<T> contact = null;
		if (parent == null)
			return contact;

		contact = (Pessoa<T>) parent.getData(); // armazena o contato do nodo
												// recebido

		if (key.compareTo(parent.getChave()) == 0) {
			return contact;
		} else {

			while (true) { // While perpetuo
				// compara para saber se deve ir a esquerda do nodo
				if (key.compareTo(parent.getChave()) < 0) {
					if (parent.getFilhoDaEsquerda() != null)// se o nodo nao for
															// nulo
						// chama o metodo fornecendo o filho da esquerda
						searchContact(parent.getFilhoDaEsquerda(), key);
				} else {
					if (key.compareTo(parent.getChave()) > 0) {
						if (parent.getFilhoDaDireita() != null)// se o nodo nao
																// for nulo
							// chama o metodo fornecendo o filho da direita
							searchContact(parent.getFilhoDaDireita(), key);
					}
				}
				return contact;
			} // fim do while perpetuo
		}
	}

	public void insertContact() {
		String name = (view.readString("Nome"));
		String phone = (view.readString("Telefone"));

		Pessoa<T> contact = new Pessoa(name);
		contact.setTelefone(phone);

		T key = (T) name.toLowerCase(); // armazena a chave como o nome em
										// lowercase

		insertContact(key, (T) contact);
	}

	public void insertContact(T key, T data) {
		Nodo<T> novo = new Nodo<T>(key, data);

		if (root == null) { // caso nao existam nodos
			root = novo; // nodo novo sera a raiz
		} else {
			Nodo<T> atual = root;// posiciona na raiz
			Nodo<T> pai; // declara variavel pai

			while (true) { // While perpetuo
				pai = atual; // pai e atual comecam valendo raiz

				// compara para saber se deve ir a esquerda do nodo
				if (key.compareTo(atual.getChave()) < 0) {
					// se encaminha a esquerda
					pai = atual; // armazena o nodo de entrada (pai)
					atual = atual.getFilhoDaEsquerda(); // avanca para o filho da esquerda

					// se nao houver filho da esquerda
					if (atual == null) {
						// define no nodo pai que o filho da esquerda e o nodo novo
						pai.setFilhoDaEsquerda(novo); // atribui o nodo novo como filho da esquerda
						return; // sai do metodo
					}
				} // fim if < 0
					// Caso a comparacao encaminhe a direita
				else {
					pai = atual; // armazena o nodo de entrada (pai)
					atual = atual.getFilhoDaDireita(); // avanca para o filho da
														// direita

					// se nao houver filho da direita
					if (atual == null) {
						// define no nodo pai que o filho da direita e o nodo novo
						pai.setFilhoDaDireita(novo);
						return; // sai do metodo
					}
				} // fim do else
			} // fim do while perpetuo
		}
	}// fim do metodo insereNodo

	public String preOrderIterative() {
		StringBuilder sb = new StringBuilder(); // cria um novo stringbuilder
												// (concatenador de string)
		preOrderIterative(root, sb); // chama o metodo sobrecarregado
		return sb.toString(); // retorna a string concatenada
	}

	private void preOrderIterative(Nodo<T> nodo, StringBuilder sb) {

		// caso o nodo seja nulo
		if (nodo == null) {
			// sb.append("#" + "\n"); // insere um sustenido ao inves do contato
			return;
		}

		// armazena os dados do nodo em contact para separar nome e telefone
		Pessoa<T> contact = (Pessoa<T>) nodo.getData();
		sb.append(contact.getNome() + "\n"); // insere o nome no stringbuilder
		sb.append(contact.getTelefone() + "\n"); // insere o telefone no
													// stringbuilder

		// chama recursivamente o metodo encaminhando para o nodo da esquerda
		preOrderIterative(nodo.getFilhoDaEsquerda(), sb);
		// chama recursivamente o metodo encaminhando para o nodo da direita
		preOrderIterative(nodo.getFilhoDaDireita(), sb);
	}

	public void saveFile(String filename) {
		FileWriter arq = null; // declara o arquivo de saida
		try {
			// instancia o arquivo com o nome recebido
			arq = new FileWriter(filename, false);

			// grava o arquivo com o retorno do metodo preOrderIterative
			arq.write(preOrderIterative());

		} catch (IOException e) {
			// caso haja excecao com o arquivo
			view.message(e.getMessage());
		} finally {
			if (arq != null)
				try {
					// ao final do processo fecha o streaming
					arq.close();
				} catch (IOException e) {
					// caso haja excecao com o arquivo
					view.message(e.getMessage());
				}
		}
	}

	public void loadFile(String filename) {
		try {
			// declara e instancia o scanner fornecendo o arquivo como entrada
			Scanner arq = new Scanner(new FileReader(filename));

			while (arq.hasNext()) { // enquanto existir prox linha
				String name = arq.nextLine(); // recebe a linha atual na string
												// name
				String phone = arq.nextLine(); // recebe a linha atual na string
												// phone

				Pessoa<T> contact = new Pessoa(name); // cria e instancia o
														// objeto contact
				contact.setTelefone(phone); // adiciona o telefone ao objeto

				// converte o nome para minusculas e armazena na variavel key
				T key = (T) name.toLowerCase();

				// se o nome nao iniciar com sustenido chama o metodo para
				// inserir
				if (!name.startsWith("#"))
					insertContact(key, (T) contact);
				/*
				 * else name = arq.nextLine(); // inserido para evitar pegar
				 * linhas com #
				 */
			}
		} catch (FileNotFoundException e) { // caso nao encontre o arquivo
			view.logError(e.getMessage());
		}
	}

	public void removeContato() {
		if (current != null) {
			// contatos.remove(current);
			// nextContato();
		}
	}

	/*
	 * private Nodo<Pessoa> procuraContato(ListaEncadeada<Pessoa> lista, String
	 * chave) { Nodo<Pessoa> iter = lista.getHead(); while (iter != null) {
	 * Pessoa contato = iter.getData(); String nome =
	 * contato.getNome().toLowerCase(); if (nome.startsWith(chave)) { return
	 * iter; } iter = iter.getNext(); } return null; }
	 * 
	 * private Pessoa procuraContatoBinario(String chave) { int limiteSuperior =
	 * vetorPessoas.length-1; int limiteInferior = 0; int contador=0; int
	 * indice=0;//utilizado para fins de comparacao com a pesquisa linear int
	 * meio=0; Pessoa atual=null;
	 * 
	 * do{ if (limiteSuperior < 0){ atual=null; }else{
	 * 
	 * contador++;//incrementa o contador das buscas efetuadas meio =
	 * (limiteInferior + limiteSuperior)/2;//calcula o meio do vetor para
	 * comecar a busca System.out.println("Meio: " + meio); atual =
	 * vetorPessoas[meio];//armazena a pessoa da casa do meio
	 * 
	 * int cmp =
	 * chave.compareTo(vetorPessoas[meio].getNome().substring(0,1));//compara o
	 * nome da pessoa com a chave (letra inicial)
	 * 
	 * if (cmp == 0){ currentBinario = atual; //se o inicial for a mesma retorna
	 * atual = null; indice=meio;//pois a leitura e sempre da posicao "do meio"
	 * showContatoBinario(contador, indice);//como esse metodo nao trabalha com
	 * o tipo Nodo, possui um show proprio //return atual; } if (cmp < 0)
	 * limiteSuperior=meio-1;//se o inicial for menor reduz a pesquisa a
	 * primeira metade if (cmp > 0) limiteInferior = meio+1;//se o inicial for
	 * maior reduz a pesquisa a segunda metade
	 * 
	 * } }while (atual != null); return null; }
	 */

}
