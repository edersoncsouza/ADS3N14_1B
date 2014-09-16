package com.senac.apps.ArvoreListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.apps.ArvoreListaTelefonica.model.Pessoa;
import com.senac.apps.ArvoreListaTelefonica.view.ArvoreListaTelefonicaConsoleView;
import com.senac.estruturas.Arvore;
import com.senac.estruturas.Nodo;

public class ArvoreController<T extends Comparable<T>> {

	private Nodo<T> raiz;
	private Arvore<Pessoa> arvore;

	private ArvoreListaTelefonicaConsoleView view;
	private Nodo<Pessoa> current;

	public ArvoreController(ArvoreListaTelefonicaConsoleView view) {
		this.view = view;
		raiz = null;
	}

	public void insert(T chave) {
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
			throw new RuntimeException("Chave duplicada : " + chave.toString());
		return nodo;
	}

	public void loadFile(String filename) {
		T chave;
		Nodo<Pessoa> pessoaNodo;
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while (arq.hasNext()) {
				String name = arq.nextLine();// le o nome da pessoa
				String phone = arq.nextLine();// le o telefone da pessoa

				Pessoa pessoa = new Pessoa(name);// instancia o objeto pessoa, fornecendo nome ao construtor
				pessoa.setTelefone(phone);// define o telefone da pessoa

				insert((T) name);
			}// fim do while
		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
	}// fim do metodo loadFile

	public void showContato() {
		if (current == null) {
			view.showMessage("Nenhum contato existente.");
		} else {
			Pessoa contato = current.getData();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}

	public void insertContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(view.readString("Nome"));
		contato.setTelefone(view.readString("Telefone"));
		
		System.out.println("Pessoa: "+contato.getNome()+" foi adicionada com o telefone: "+ contato.getTelefone());
		
		//Nodo<Pessoa> novo = new Nodo<Pessoa>(contato);
		insert((T) contato.getNome());
	}

	/*
	public void removeContato() {
		if (current != null) {
			contatos.remove(current);
			nextContato();
		}
	}
*/
	

	private Nodo<Pessoa> procuraContato(Arvore<Pessoa> arvore,
			String chave) {
		Nodo<Pessoa> iter = arvore.getRaiz();
		while (iter != null) {
			Pessoa contato = iter.getData();
			String nome = contato.getNome().toLowerCase();
			if (nome.startsWith(chave)) {
				return iter;
			}
			iter = iter.getFilhoEsquerda();
		}
		return null;
	}

	public void searchContato() {
		String chave = view.readString("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = procuraContato(arvore, chave);
		if (contato != null)
			current = contato;
	}

	

	public void saveFile(String filename) {
		FileWriter arq = null;
		try {
			arq = new FileWriter(filename, false);
			Nodo<Pessoa> iter = arvore.getRaiz();
			while (iter != null) {
				Pessoa contato = iter.getData();
				if (procuraContato(arvore, contato.getNome()) == null)
					arq.append("#" + contato.getNome() + "\n");
				else
					arq.append(contato.getNome() + "\n");
				arq.append(contato.getTelefone() + "\n");
				iter = iter.getFilhoEsquerda();
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
