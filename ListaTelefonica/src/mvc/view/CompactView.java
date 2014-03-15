/*
 * Classe View da aplicacao
 * 
 * <p>Implementa a interface re-escrevendo o metodo imprimePessoa para acrescentar o rotulo
 *  de Contato e apresentando os dados em uma unica linha.</p>
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.view;

import static java.lang.System.out;

public class CompactView implements PessoaView {

	@Override
	public void imprimePessoa(String nome, String telefone) {
		out.println(String.format("Contato: %s - %s", nome, telefone));
	}

}