package mvc.controller;

import java.util.Scanner;

import mvc.model.Pessoa;
import mvc.view.*;

public class PessoaController {

	private PessoaView view;
	private Pessoa pessoa;
	Scanner leitor = new Scanner(System.in);

	public PessoaController() {
		this.view = new ExtendedView();
	}

	public void setView(PessoaView view) {
		this.view = view;
	}

	public void criaPessoa() {
		pessoa = new Pessoa();
		
		System.out.println("Digite o nome da pessoa: ");
		pessoa.setNome(leitor.next());
		
		System.out.println("Digite o telefone da pessoa: ");
		pessoa.setTelefone(leitor.next());
		
	}

	public void mostraPessoa() {
		view.imprimePessoa(pessoa.getNome(), pessoa.getTelefone());
	}
}