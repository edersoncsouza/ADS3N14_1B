package com.senac.apps.ArvoreListaTelefonica;

import com.senac.apps.ArvoreListaTelefonica.controller.ArvoreController;
import com.senac.apps.ArvoreListaTelefonica.view.ArvoreListaTelefonicaConsoleView;

public class ArvoreListaTelefonica {
	
	public static void main(String[] args) {
		ArvoreListaTelefonicaConsoleView view = new ArvoreListaTelefonicaConsoleView();
		ArvoreController controller = new ArvoreController(view);
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
