//http://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
//http://www.mcs.csueastbay.edu/~bhecker/Previous%20Terms/CS-3240-Fall13/Examples/BinaryTree-2.java
//http://rosettacode.org/wiki/Tree_traversal#Java

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
	private Nodo<T> raiz, current;

	public Arvore(ConsoleView view) {
		this.view = view;
		this.raiz = null;
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public boolean isEmpty() {
		Boolean vazio;
		if (raiz != null)
			vazio = false;
		else
			vazio = true;
		return vazio;
	}

	public void postorder() {
		if (!isEmpty())
			postorder(raiz);
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
			preorder(raiz);
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
			inorder(raiz);
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

	public void exibeRaiz() {
		T contatoT = raiz.getData();
		Pessoa contato = (Pessoa) contatoT;
		view.printContato(contato.getNome(), contato.getTelefone());
	}

	public void showContato(Nodo<T> nodo) {
		T contatoT = nodo.getData();
		Pessoa contato = (Pessoa) contatoT;
		view.printContato(contato.getNome(), contato.getTelefone());
	}

	public void inserir() {

		String name = (view.readString("Nome"));
		String phone = (view.readString("Telefone"));

		Pessoa<T> pessoa = new Pessoa(name);
		pessoa.setTelefone(phone);

		T chave = (T) name;

		inserir(chave, (T) pessoa);

	}
	
	public void inserir(T chave, T data) {
		Nodo<T> novo = new Nodo<T>(chave, data);

		showContato(novo);// para teste
		
		if (raiz == null) {
			raiz = novo;
		} else {
			Nodo<T> atual = raiz;
			Nodo<T> pai;
			pai = atual;// atual comeca valendo raiz

			// Verifica se o valor a ser inserido é menor que o nodo corrente da
			// árovre, se sim vai para subarvore esquerda
			if (chave.compareTo(atual.getChave()) < 0) {
				// if (valor < node.valor) {
				// Se tiver elemento no nodo esquerdo continua a busca
				if (novo.getFilhoDaEsquerda() != null) {
					chave = novo.getFilhoDaEsquerda().getChave();
					data = novo.getFilhoDaEsquerda().getData();
					inserir(chave, data);
				} else {
					// Se nodo esquerdo vazio insere o novo nodo aqui
					// System.out.println(" Inserindo " + valor +
					// " a esquerda de "+ node.valor);
					// node.esquerda = new No(valor);
					novo.setFilhoDaEsquerda(novo);
				}
				// Verifica se o valor a ser inserido é maior que o nodo
				// corrente da
				// árvore, se sim vai para subarvore direita
			} else if (chave.compareTo(atual.getChave()) > 0) {
				// Se tiver elemento no nodo direito continua a busca
				// if (node.direita != null) {
				if (novo.getFilhoDaDireita() != null) {
					chave = novo.getFilhoDaDireita().getChave();
					data = novo.getFilhoDaDireita().getData();
					inserir(chave, data);
				} else {
					// Se nodo direito vazio insere o novo nodo aqui
					// System.out.println(" Inserindo " + valor +
					// " a direita de " + node.valor);
					// node.direita = new No(valor);
					novo.setFilhoDaDireita(novo);
				}
			}
		}
	}

	public void insertContato() {

		String name = (view.readString("Nome"));
		String phone = (view.readString("Telefone"));

		Pessoa<T> pessoa = new Pessoa(name);
		pessoa.setTelefone(phone);

		T chave = (T) name;

		insereNodo(chave, (T) pessoa);

	}

	public void insereNodo(T chave, T data) {
		Nodo<T> novo = new Nodo<T>(chave, data);

		showContato(novo);// para teste

		if (raiz == null) {
			raiz = novo;
		} else {
			Nodo<T> atual = raiz;
			Nodo<T> pai;

			while (true) {// While perpetuo
				pai = atual;// atual comeca valendo raiz

				// Check if the new node should go on the left side of the
				// parent node
				if (chave.compareTo(atual.getChave()) < 0)
					// Switch focus to the left child
					pai = atual;//Alterado pra consertar a insercao
					atual = atual.getFilhoDaEsquerda();

				// If the left child has no children
				if (atual == null) {
					// then place the new node on the left of it
					pai.setFilhoDaEsquerda(novo);
					return; // All Done
				}
				// If we get here put the node on the right
				else{
					pai = atual;//Alterado pra consertar a insercao
					atual = atual.getFilhoDaDireita();
				}
				// If the right child has no children
				if (atual == null) {
					// then place the new node on the right of it
					pai.setFilhoDaDireita(novo);
					return; // All Done
				}
			}
		}// fim do while perpetuo
	}// fim do metodo insereNodo

	public void loadFile(String filename) {
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while (arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();

				Pessoa<T> pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);

				T chave = (T) name.toLowerCase();

				if (!name.startsWith("#"))
					insereNodo(chave, (T) pessoa);
					//inserir(chave, (T) pessoa);
			}
		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
	}

	public void removeContato() {
		if (current != null) {
			// contatos.remove(current);
			// nextContato();
		}
	}

	public void levelorder() {
		if (!isEmpty())
			levelorder(raiz);
		else
			System.out.println("Arvore vazia.");
	}

	public void levelorder(Nodo<T> nodo) {
		Queue<Nodo<T>> enfileraNodo = new LinkedList<Nodo<T>>();
		if (nodo != null)
			enfileraNodo.add(nodo);
		while (!enfileraNodo.isEmpty()) {
			Nodo<T> next = enfileraNodo.remove();

			showContato(next);
			// System.out.print(next.getData() + " ");

			if (next.getFilhoDaEsquerda() != null) {
				enfileraNodo.add(next.getFilhoDaEsquerda());
			}
			if (next.getFilhoDaDireita() != null) {
				enfileraNodo.add(next.getFilhoDaDireita());
			}
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
	public void searchContato() {
		String chave = view.read("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = null;
		/*
		 * if (contato != null) current = contato;
		 */
	}

	/*
	 * public void saveFile(String filename) { FileWriter arq = null; try { arq
	 * = new FileWriter(filename,false); Nodo<Pessoa> iter = arquivo.getHead();
	 * while (iter != null) { Pessoa contato = iter.getData(); if
	 * (procuraContato(contatos, contato.getNome()) == null)
	 * arq.append("#"+contato.getNome()+"\n"); else
	 * arq.append(contato.getNome()+"\n");
	 * arq.append(contato.getTelefone()+"\n"); iter = iter.getNext(); } } catch
	 * (IOException e) { view.message(e.getMessage()); } finally { if (arq !=
	 * null) try { arq.close(); } catch (IOException e) {
	 * view.message(e.getMessage()); } } }
	 */
}
