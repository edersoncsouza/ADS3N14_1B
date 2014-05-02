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
			if (command.equals("raiz"))
				controller.showRoot();
			if (command.equals("infixa"))
				controller.inorder();
			if (command.equals("prefixa"))
				controller.preorder();
			if (command.equals("posfixa"))
				controller.postorder();
			if (command.equals("nivel"))
				controller.levelorder();;
			if (command.equals("inserir"))
				controller.insertContact();
			if (command.equals("excluir"))
				controller.removeContato();
			if (command.equals("procurar"))
				controller.locateContact();
			if (command.equals("ajuda"))
				view.message("ajuda  raiz  infixa  prefixa  posfixa  nivel  inserir  excluir  procurar  sair");
		}
		controller.saveFile("telefones.dat");
	}

}
