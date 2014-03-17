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

public class ExtendedView implements PessoaView {

	public void imprimePessoa(String nome, String telefone) {
		out.println("Nome: " + nome);
		out.println("Telefone: " + telefone);
	}
}