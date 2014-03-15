package mvc.app;

import mvc.controller.PessoaController;
import mvc.view.ExtendedView;

public class PessoaApp {
	public static void main(String[] args) {
		
		PessoaController controller = new PessoaController();
		controller.criaPessoa();
		controller.setView(new ExtendedView());
		controller.mostraPessoa();
		
	}
}