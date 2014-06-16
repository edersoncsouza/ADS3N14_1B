package com.ArvoreAVLeRubroNegra.app;

import com.ArvoreAVLeRubroNegra.controller.AvlTree;
import com.ArvoreBinariaAvleRubroNegra.View.ConsoleView;

public class Principal {

	public static void main(String[] args) {
		 	AvlTree controller = new AvlTree();
			ConsoleView view = new ConsoleView();
			String command = "";
			
			view.message("Digite 'ajuda' para comandos validos.");
			while (!command.equals("sair")) {
				//controller.showContato();
				command = view.read("Comando").toLowerCase();
				if (command.equals("raiz"))
					controller.getRoot();
				if (command.equals("infixa"))
					controller.inorder();
				if (command.equals("prefixa"))
					controller.preorder();
				if (command.equals("posfixa"))
					controller.postorder();
				if (command.equals("inserir"))
					controller.insert(x);
				if (command.equals("excluir"))
					//controller.removeContato();
					controller.deleteNode();
				if (command.equals("procurar"))
					controller.search(el);
				if (command.equals("ajuda"))
					view.message("ajuda  raiz  infixa  prefixa  posfixa  nivel  inserir  excluir  procurar  sair");
			}
			//controller.saveFile("telefones.dat");
		}

	}

