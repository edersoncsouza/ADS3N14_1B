package com.ListaTelefonica.app;

import com.ListaTelefonica.controller.Arvore;
import com.ListaTelefonica.view.ConsoleView;

public class ListaTelefonica {
	
	public static void main(String[] args) {
		ConsoleView view = new ConsoleView();
		Arvore controller = new Arvore(view);
		String command = "";
		
		controller.loadFile("telefones.dat");
		
		view.message("Digite 'ajuda' para comandos validos.");
		while (!command.equals("sair")) {
			//controller.showContato();
			command = view.read("Comando").toLowerCase();
			if (command.equals("inserir"))
				controller.insertContato();
			if (command.equals("excluir"))
				//controller.removeContato();
			if (command.equals("procurar"))
				//controller.searchContato("sequencial");
			if (command.equals("ajuda"))
				view.message("ajuda  inserir  excluir  procurar procurarbin sair");
		}
		//controller.saveFile("telefones.dat");
	}

}
