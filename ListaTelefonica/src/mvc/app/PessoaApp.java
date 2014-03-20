/*
 * Classe da aplicacao principal
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.app;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import mvc.controller.ListaDuplamenteEncadeada;
import mvc.controller.PessoaController;
import mvc.view.ExtendedView;

public class PessoaApp {
	
	public static void main(String[] args) throws IOException{
		menuPrincipal();		
	}	
	
	public static void menuPrincipal() {	
	try {
		//instancia o objeto PessoaController
		PessoaController controller = new PessoaController();
		ListaDuplamenteEncadeada<String> lista;
		
		//armazena os contatos na lista
		lista = (controller.LerArquivoPessoasRetorno());
		
		//cria o leitor para a operacao de menu
		Scanner leitor = new Scanner(System.in);
			int operacao;

			System.out.println();
			System.out.println("SISTEMA DE LISTA TELEFONICA");
			System.out.println("===========================");
			System.out.println("1 - Listar telefones");
			System.out.println("2 - Adicionar telefone");
			System.out.println("3 - Pesquisar telefone");
			System.out.println("======================");
			System.out.println("0 - Sair do software");
			System.out.print("Opcao: ");

			operacao = (leitor.nextInt());

			switch (operacao) {
			case 0://sair do software
				System.out.println("Encerramento do sistema!");
				System.exit(0);
				break;
			case 1://listar telefones
				/*
				 *  define o tipo de visualizacao como um objeto do tipo 
				 *  ExtendedView - interface PessoaView
				 */
				controller.setView(new ExtendedView());
				lista.print();
				menuPrincipal();
				break;
			case 2://adicionar telefone
				//chama o metodo criaPessoa
				controller.criaPessoa();
				menuPrincipal();
				break;
			case 3://pesquisar telefone
				try{
				String pessoa = controller.buscaPessoa().getDado();
				System.out.println(pessoa);
				}catch(Exception e){
					System.out.println("Não foi encontrado nenhum contato com essa letra inicial");
				}
				menuPrincipal();
				break;
			default:
				System.out
						.println("OPCAO INVALIDA!!! - Pressione qualquer tecla para retornar...");
				System.in.read();
				break;
			}// fim do switch / case
		}// fim do try
		catch (Exception e) {
			System.out
					.println("OCORREU UM ERRO!!! - Retornando ao menu principal...");
			//e.printStackTrace();
			menuPrincipal();
		}

	}// fim do metodo menuPrincipal

}