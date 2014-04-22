package com.senac.views;

import java.util.Scanner;

public class ConsoleView {

	private static final Scanner teclado = new Scanner(System.in);
	
	public void imprimeInteiro(Integer valor) {
		System.out.println(valor);
	}

	public void logError(String message) {
		System.out.println("ERROR: " + message);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public void showPrompt(String prompt) {
		System.out.print(prompt+": ");
	}

	public String readString(String prompt) {
		showPrompt(prompt);
		return readString();
	}
	
	public String readString() {
		return teclado.nextLine();
	}
	

}
