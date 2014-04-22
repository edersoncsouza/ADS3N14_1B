package com.senac.apps.ListaTelefonica.view;

import com.senac.views.ConsoleView;

public class ListaTelefonicaConsoleView
			extends ConsoleView
{

	public void printContato(String nome, String telefone) {
		showMessage("Nome: " + nome);
		showMessage("Telefone: " + telefone);
	}

}
