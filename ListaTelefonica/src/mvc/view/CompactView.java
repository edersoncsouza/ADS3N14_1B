package mvc.view;

import static java.lang.System.out;

public class CompactView implements PessoaView {

	public void imprimePessoa(String nome, String telefone) {
		out.println(String.format("Contato: %s - %s", nome, telefone));
	}

}