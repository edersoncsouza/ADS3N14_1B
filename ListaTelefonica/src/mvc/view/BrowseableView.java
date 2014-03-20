/*
 * Classe View da aplicacao
 * 
 * <p>Implementa a interface re-escrevendo o metodo imprimePessoa para acrescentar rotulos
 *  aos dados e apresentando-os em duas linhas.</p>
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.view;

import static java.lang.System.out;

import java.util.Scanner;

import mvc.app.PessoaApp;
import mvc.controller.PessoaController;

public class BrowseableView implements PessoaView {

	public void imprimePessoa(String nome, String telefone) {
		// cria o leitor para a operacao de menu
		Scanner leitor = new Scanner(System.in);
		int operacao;
		try {
			System.out.println("================CONTATO================");
			System.out.println("Nome: " + nome);
			System.out.println("Telefone "+ telefone);
			System.out.println("=======================================");
			System.out.println("SISTEMA DE LISTA TELEFONICA - NAVEGACAO");
			System.out.println("=======================================");
			System.out.println("1 - Avancar para proximo contato");
			System.out.println("2 - Retornar para contato anterior");
			System.out.println("3 - Pesquisar outro contato");
			System.out.println("4 - Retornar ao menu principal");
			System.out.println("=======================================");
			System.out.println("0 - Sair do software");
			System.out.println("Opcao: ");

			operacao = (leitor.nextInt());
			if ((operacao > 4) || (operacao < 0)) {
				System.out
						.println("OPCAO INVALIDA!!! - Pressione qualquer tecla para retornar...");
				System.in.read();
			}else{
				PessoaApp.menuNavegacao(operacao);
			}
		}// fim do try
		catch (Exception e) {
			System.out
					.println("OCORREU UM ERRO!!! - Retornando ao menu principal...");
			// e.printStackTrace();
			PessoaApp.menuPrincipal();
		}

		leitor.close();

	}
}