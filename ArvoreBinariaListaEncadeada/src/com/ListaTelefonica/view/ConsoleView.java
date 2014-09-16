package com.ListaTelefonica.view;

import static java.lang.System.out;

import java.util.Scanner;

public class ConsoleView {

	private Scanner teclado = new Scanner(System.in);

	public void message(String message) {
		out.println(message);
	}

	public String read(String prompt) {
		out.print(prompt+": ");
		return teclado .nextLine();
	}
	
	public String readString(String prompt) {
		showPrompt(prompt);
		return readString();
	}
	
	public String readString() {
		return teclado.nextLine();
	}
	
	public void showPrompt(String prompt) {
		System.out.print(prompt+": ");
	}
	
	public void printContato(String nome, String telefone) {
		message("Nome: " + nome);
		message("Telefone: " + telefone);
	}
	
	public void printContatoBinario(String nome, String telefone, int contador, int indice) {
		message("Nome: " + nome);
		message("Telefone: " + telefone);
		message("Numero de pesquisas binarias: " + contador);
		message("Numero de pesquisas no metodo linear: " + (indice+1));
	}

	public void logError(String message) {
		message("Error: " + message);
	}

}
