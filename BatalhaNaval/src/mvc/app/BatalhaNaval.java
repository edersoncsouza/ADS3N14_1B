package mvc.app;

import mvc.controller.TabuleiroController;

public class BatalhaNaval {

	public static void main(String[] args) {
		TabuleiroController controller = new TabuleiroController();

		controller.inicializaJogo();
		
		controller.imprimirMatriz();
		
	}

}
