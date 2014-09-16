package com.senac.apps.ArvoreListaTelefonica.view;

import com.senac.views.ConsoleView;

public class ArvoreListaTelefonicaConsoleView
			extends ConsoleView
{

	public void printContato(String nome, String telefone) {
		showMessage("Nome: " + nome);
		showMessage("Telefone: " + telefone);
	}

}
