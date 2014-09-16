package mvc.app;

import mvc.model.Jogador;
import mvc.view.ConsoleView;
import mvc.controller.TabuleiroController;

public class BatalhaNaval {

	public static void main(String[] args) {
		ConsoleView view = new ConsoleView();
		TabuleiroController controller = new TabuleiroController();
		String command = "";

		controller.startGame();

		controller.printMaskMatrix();

		view.message("Digite 'ajuda' para comandos validos.");
		while (!command.equals("sair")) {
			if(controller.win()==true){
				System.out.println("Parabéns  você venceu!!!!" );
				System.exit(0);
			}else{
			command = view.read("Comando").toLowerCase();
			if (command.equals("ajuda"))
				view.message("ajuda jogar sair");
			if(command.equals("jogar"))
				controller.play();
			if(command.equals("idbeholda"))
				controller.printMatrix();		
			controller.printMaskMatrix();
			}// fim do else nao venceu
		}// fim do while
	}// fim do metodo main

	

}// fim da classe BatalhaNaval

