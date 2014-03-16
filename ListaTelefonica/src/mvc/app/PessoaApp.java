/*
 * Classe da aplicacao principal
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import mvc.controller.PessoaController;
import mvc.view.ExtendedView;

public class PessoaApp {
	public static void main(String[] args) throws IOException{

		// instancia o objeto PessoaController
		PessoaController controller = new PessoaController();
		
		//chama o metodo criaPessoa
		controller.criaPessoa();
		
		/*
		 *  define o tipo de visualizacao como um objeto do tipo 
		 *  ExtendedView - interface PessoaView
		 */
		controller.setView(new ExtendedView());
		
		// chama o metodo mostraPessoa
		//controller.mostraPessoa();
		
		// chama o metodo LerArquivoPessoas
		controller.LerArquivoPessoas();

	}
}