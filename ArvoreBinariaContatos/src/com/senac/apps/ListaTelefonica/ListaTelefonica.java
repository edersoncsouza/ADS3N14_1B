package com.senac.apps.ListaTelefonica;

import com.senac.apps.ListaTelefonica.controller.ListaController;
import com.senac.apps.ListaTelefonica.view.ListaTelefonicaConsoleView;

public class ListaTelefonica {
	
	public static void main(String[] args) {
		ListaTelefonicaConsoleView view = new ListaTelefonicaConsoleView();
		ListaController controller = new ListaController(view);
		String command = "";
		
		controller.loadFile("telefones.dat");
		view.showMessage("Digite 'ajuda' para comandos validos.");
		while (!command.equals("sair")) {
			controller.showContato();
			command = view.readString("Comando").toLowerCase();
			if (command.equals("avancar"))
				controller.nextContato();
			if (command.equals("voltar"))
				controller.previousContato();
			if (command.equals("inserir"))
				controller.insertContato();
			if (command.equals("excluir"))
				controller.removeContato();
			if (command.equals("procurar"))
				controller.searchContato();
			if (command.equals("ajuda"))
				view.showMessage("ajuda  avancar  voltar  inserir  excluir  procurar  sair");
		}
		controller.saveFile("telefones.dat");
	}

}
