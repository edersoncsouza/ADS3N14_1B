package com.senac.apps.ListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.senac.apps.ListaTelefonica.model.Pessoa;
import com.senac.apps.ListaTelefonica.view.ConsoleView;
import com.senac.estruturas.ListaEncadeada;
import com.senac.estruturas.ListaOrdenada;
import com.senac.estruturas.Nodo;
import com.senac.estruturas.VetorOrdenado;

public class ListaController {

	private ListaEncadeada<Pessoa> arquivo;
	private ListaOrdenada<Pessoa> contatos;
	private ConsoleView view;
	private Nodo<Pessoa> current;
	private Pessoa currentBinario;
	private Pessoa[] vetorPessoas;//Adicionado
	private int listSize=0;
	
	public ListaController(ConsoleView view) {
		this.view = view;
		this.contatos = new ListaOrdenada<Pessoa>();
		this.arquivo  = new ListaEncadeada<Pessoa>();
		this.current = null;
	}

	public void loadFile(String filename) {
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while(arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				Pessoa pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);
				arquivo.insert(new Nodo<Pessoa>(pessoa));
				if (!name.startsWith("#")){
					contatos.insert(new Nodo<Pessoa>(pessoa));
					listSize++;
				}
			}
			current = contatos.getHead();
		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
	}

	public void fillArray(){
		Pessoa contato = contatos.getHead().getData();
		int cont=0;
		
		while(cont < listSize){
		vetorPessoas[cont] = contato;
		cont++;
		}
	}
	
	public void showContato() {
		if (current == null) {
			view.message("Nenhum contato existente.");
		} else {
			Pessoa contato = current.getData();
			view.printContato(contato.getNome(), contato.getTelefone());
		}
	}
	
	public void showContatoBinario(int contador){
		if (currentBinario == null) {
			view.message("Nenhum contato existente.");
		} else {
			view.printContatoBinario(currentBinario.getNome(), currentBinario.getTelefone(), contador);
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
		contato.setNome(view.read("Nome"));
		contato.setTelefone(view.read("Telefone"));
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
	
	private void procuraContatoBinario(Pessoa[] vetorPessoas, String chave)
	{
		int limiteSuperior = vetorPessoas.length-1;
		int limiteInferior = 0;
		int contador=0;
		Pessoa atual=null;
		
		do{
			contador++;
			int meio = limiteSuperior/2;//calcula o meio do vetor para comecar a busca
			atual = vetorPessoas[meio];//armazena a pessoa da casa do meio
			int cmp = vetorPessoas[meio].getNome().compareTo(chave);//compara o nome da pessoa com a chave (letra inicial)
			
				if (cmp == 0){
					currentBinario = atual; //se o inicial for a mesma retorna
					atual = null;
					showContatoBinario(contador);
				}
				if (cmp < 0)
					limiteSuperior=meio-1;//se o inicial for menor reduz a pesquisa a primeira metade
				if (cmp > 0)
					limiteInferior = meio+1;//se o inicial for maior reduz a pesquisa a segunda metade
				
			}while (atual != null);

	}
	
	
	public void searchContato(String tipo) {
		String chave = view.read("Inicio do Nome").toLowerCase();
		Nodo<Pessoa> contato = null;
		
		if(tipo.equals("sequencial"))
		contato = procuraContato(contatos, chave);
		
		if (tipo.equals("binario"))
			procuraContatoBinario(vetorPessoas, chave);
		
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

}
