package mvc.app;

import mvc.view.ConsoleView;

import mvc.controller.TabuleiroController;

public class BatalhaNaval {

	public static void main(String[] args) {
		ConsoleView view = new ConsoleView();
		TabuleiroController controller = new TabuleiroController();
		String command = "";

		controller.startGame();

		//controller.printFakeMatrix();
		controller.printMaskMatrix();

		view.message("Digite 'ajuda' para comandos validos.");
		while (!command.equals("sair")) {
			command = view.read("Comando").toLowerCase();
			if (command.equals("ajuda"))
				view.message("ajuda jogar sair");
			if(command.equals("jogar"))
				controller.play();
					
			//controller.printMatrix();
			controller.printMaskMatrix();
		}// fim do while
	}// fim do metodo main

	

}// fim da classe BatalhaNaval

