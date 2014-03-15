/*
 * Classe Controller da aplicacao 
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.controller;

import java.io.File;

import java.util.Scanner;

import mvc.model.Pessoa;
import mvc.view.*;

public class PessoaController {

	private PessoaView view;
	private Pessoa pessoa;
	Scanner leitor = new Scanner(System.in);

	// construtor que inicializa o tipo de visao padrao como Extendedview
	public PessoaController() {
		this.view = new ExtendedView();
	}

	/*
	 * Metodo setView <p>Este metodo define o tipo de visualizacao para o nome e
	 * telefone da pessoa.</p>
	 * 
	 * @param view, objeto do tipo definido pela interface PessoaView
	 */
	public void setView(PessoaView view) {
		this.view = view;
	}

	/*
	 * Metodo criaPessoa <p>Este metodo instancia um objeto do tipo {@link
	 * Pessoa.java} e recebe, via teclado, seu nome e telefone.</p>
	 */
	public void criaPessoa() {
		pessoa = new Pessoa();

		System.out.println("Digite o nome da pessoa: ");
		pessoa.setNome(leitor.next());

		System.out.println("Digite o telefone da pessoa: ");
		pessoa.setTelefone(leitor.next());

	}

	/*
	 * Metodo mostraPessoa <p>Este metodo aciona o metodo imprimePessoa do
	 * objeto to tipo PessoaView.</p>
	 */
	public void mostraPessoa() {
		view.imprimePessoa(pessoa.getNome(), pessoa.getTelefone());
	}

	/*
	 * Metodo LerArquivoPessoas <p>Este metodo deve trazer os nomes e telefones
	 * salvos em arquivo</p>
	 * 
	 * @Source http://www.guj.com.br/java/78913-ler-arquivo-utilizando-scanner
	 */
	public void LerArquivoPessoas(){

		try {
			/*
			 * instancia um objeto do tipo File que recebe o arquivo telefones.txt 
			 * da pasta arquivos contida na raiz do projeto
			 */
			File arquivo = new File(("arquivos\\telefones.txt"));
			
			//Instancia um objeto do tipo Scanner que recebe o arquivo como parametro
			Scanner leitorArquivo = new Scanner(arquivo);
			
			//enquanto houver mais uma linha
			while (leitorArquivo.hasNextLine())
				System.out.println(leitorArquivo.nextLine());

			//fechamento do leitor
			leitorArquivo.close();
		} catch (Exception FileNotFoundException) {
			System.out.println("Arquivo de telefones não encontrado!");
		}

	}
}