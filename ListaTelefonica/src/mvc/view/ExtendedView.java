package mvc.view;

import static java.lang.System.out;

public class ExtendedView implements PessoaView{
	public void imprimePessoa(String nome, String telefone) {
		out.println("Nome: " + nome);
		out.println("Telefone: " + telefone);
	}
}