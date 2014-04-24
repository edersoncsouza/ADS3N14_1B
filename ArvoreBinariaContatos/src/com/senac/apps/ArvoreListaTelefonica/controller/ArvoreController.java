package com.senac.apps.ArvoreListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.apps.ArvoreListaTelefonica.model.Pessoa;
import com.senac.apps.ArvoreListaTelefonica.view.ArvoreListaTelefonicaConsoleView;
import com.senac.estruturas.Arvore;
import com.senac.estruturas.ListaEncadeada;
import com.senac.estruturas.ListaOrdenada;
import com.senac.estruturas.Nodo;

public class ArvoreController <T extends Comparable<T>>{

	private Nodo<T> raiz;
	
	private ArvoreListaTelefonicaConsoleView view;
	private Nodo<Pessoa> current;
	
	public ArvoreController(ArvoreListaTelefonicaConsoleView view) {
		this.view = view;
		raiz = null;	
	}

	 /** 
	   Inserts the given data into the binary tree. 
	   Uses a recursive helper. 
	  */ 
	  public void insert(T chave) { 
	    raiz = insert(raiz, chave); 
	  } 
	
	private Nodo<T> insert (Nodo<T> novo, T chave){
		if (novo == null){
			novo = new Nodo<T>(chave);
		}
		if(novo.getChave().equals(chave)){
			System.out.println("Chave duplicada, nao sera incluida na arvore!");
		}
		
		if (chave.compareTo(novo.getChave()) < 0) {
	        // adiciona a chave a sub-arvore esquerda
	        novo.setFilhoEsquerda(insert(novo.getFilhoEsquerda(),chave));
	        
	    }
		else{// adiciona a chave a sub-arvore direita
			novo.setFilhoDireita(insert(novo.getFilhoDireita(),chave));
			
		}
		return novo;
	}
		
	
	public void loadFile(String filename) {
		T chave;
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while(arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				Pessoa pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);
				//arquivo.insert(new Nodo<Pessoa>(pessoa));
				chave=pessoa;
				insert(new Nodo<Pessoa>(pessoa,null,null),pessoa.getNome());
				

		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
	}

	public void showContato() {
		if (current == null) {
			view.showMessage("Nenhum contato existente.");
		} else {
			Pessoa contato = current.getData();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}

	public void nextContato() {
		if (current != null) {
			current = current.getNext();
			if (current == null)
				current = contatos.getHead();
		}
	}

	public void previousContato() {
		if (current != null) {
			current = current.getPrevious();
			if (current == null)
				current = contatos.getTail();
		}
	}

	public void insertContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(view.readString("Nome"));
		contato.setTelefone(view.readString("Telefone"));
		Nodo<Pessoa> novo = new Nodo<Pessoa>(contato);
		contatos.insert(novo);
		arquivo.append(new Nodo<Pessoa>(contato));
		current = novo;
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
	
	public void searchContato() {
		String chave = view.readString("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = procuraContato(contatos, chave);
		if (contato != null)
			current = contato;
	}

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
			view.showMessage(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					view.showMessage(e.getMessage());
				}
		}
	}

}
