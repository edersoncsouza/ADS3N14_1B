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
import mvc.view.BrowseableView;
import mvc.view.ExtendedView;
import mvc.model.NodoD;

public class PessoaApp {
	
	static NodoD<String> nodoPesquisado = null;
	
	public static void main(String[] args) throws IOException{
		menuPrincipal();		
	}	
	
	public static void menuPrincipal() {	
	try {
		//instancia o objeto PessoaController
		PessoaController controller = new PessoaController();
		BrowseableView viewer = new BrowseableView();
		

		
		String contato = "";
		String[] vetContato = new String[2];
		
		ListaDuplamenteEncadeada<String> lista;
		
		//armazena os contatos na lista
		lista = (controller.LerArquivoPessoasRetorno());
		
		//cria o leitor para a operacao de menu
		Scanner leitor = new Scanner(System.in);
			int operacao;

			System.out.println();
			System.out.println("SISTEMA DE LISTA TELEFONICA");
			System.out.println("===========================");
			System.out.println("1 - Listar contatos");
			System.out.println("2 - Adicionar contato");
			System.out.println("3 - Pesquisar contato");
			System.out.println("4 - Excluir contato");
			System.out.println("===========================");
			System.out.println("0 - Sair do software");
			System.out.print("Opcao: ");

			operacao = (leitor.nextInt());

			switch (operacao) {
			case 0://sair do software
				System.out.println("Encerramento do sistema!");
				System.exit(0);
				break;
			case 1://listar contatos
				/*
				 *  define o tipo de visualizacao como um objeto do tipo 
				 *  ExtendedView - interface PessoaView
				 */
				controller.setView(new ExtendedView());
				lista.print();
				menuPrincipal();
				break;
			case 2://adicionar contato
				//chama o metodo criaPessoa
				controller.criaPessoa();
				menuPrincipal();
				break;
			case 3://pesquisar contato
				try{
					//armazena o nodo para facilitar a navegacao no metodo menuNavegacao
					nodoPesquisado=controller.buscaPessoa();
					contato=nodoPesquisado.getDado();
					}catch(Exception e){
						System.out.println("Não foi encontrado nenhum contato com essa letra inicial");
					}
				vetContato=contato.split("\n");
				controller.setView(new BrowseableView());
				viewer.imprimePessoa(vetContato[0], vetContato[1]);
				
				menuPrincipal();
				break;
			case 4://excluir contato
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
	public static void menuNavegacao(int operacao) {
		try {
		//instancia o objeto PessoaController
		PessoaController controller = new PessoaController();
		BrowseableView viewer = new BrowseableView();
		
		String contato = "";
		String[] vetContato = new String[2];
		
		switch (operacao) {
		case 0://Sair do software
			System.out.println("Encerramento do sistema!");
			System.exit(0);
			break;
		case 1://Avancar para proximo contato
			nodoPesquisado=nodoPesquisado.getNext();
			try{
				//armazena o nodo para facilitar a navegacao no metodo menuNavegacao
				//nodoPesquisado=controller.buscaPessoa();
				contato=nodoPesquisado.getDado();
				}catch(Exception e){
					System.out.println("Não foi encontrado nenhum contato com essa letra inicial");
					e.printStackTrace();
				}
			vetContato=contato.split("\n");
			controller.setView(new BrowseableView());
			viewer.imprimePessoa(vetContato[0], vetContato[1]);
			
			menuPrincipal();
			break;
		case 2://Retornar para contato anterior
			nodoPesquisado=nodoPesquisado.getPrev();
			try{
				//armazena o nodo para facilitar a navegacao no metodo menuNavegacao
				nodoPesquisado=controller.buscaPessoa();
				contato=nodoPesquisado.getDado();
				}catch(Exception e){
					System.out.println("Não foi encontrado nenhum contato com essa letra inicial");
				}
			vetContato=contato.split("\n");
			controller.setView(new BrowseableView());
			viewer.imprimePessoa(vetContato[0], vetContato[1]);
			
			menuPrincipal();
			break;
		case 3://Pesquisar outro contato
			try{
				contato=controller.buscaPessoa().getDado();
				}catch(Exception e){
					System.out.println("Não foi encontrado nenhum contato com essa letra inicial");
				}
			vetContato=contato.split("\n");
			controller.setView(new BrowseableView());
			viewer.imprimePessoa(vetContato[0], vetContato[1]);
			
			menuPrincipal();
			break;
		case 4://Retornar ao menu principal
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
		

		
	}
}