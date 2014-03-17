/*
 * Classe Controller da aplicacao 
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.controller;

import mvc.model.Pessoa;
import mvc.model.Nodo;
import mvc.view.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PessoaController{

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
	 * Pessoa.java} e recebe, via teclado, seu nome e telefone, salvando em
	 * arquivo ao sair.</p>
	 * 
	 * @Source
	 * http://www.guj.com.br/java/124651-salvar-uma-string-em-um-arquivo-
	 * txt-com-percistencia-alguem-pode-me-ajudarresolvido
	 */
	public void criaPessoa() throws IOException {

		// Abre arquivo para escrita
		BufferedWriter gravador = new BufferedWriter(new FileWriter(
				"arquivos\\telefones.txt", true));

		System.out.println("Digite o nome da pessoa: ");
		gravador.write(leitor.next());

		gravador.newLine();// passa para a proxima linha

		System.out.println("Digite o telefone da pessoa: ");
		gravador.write(leitor.next());

		gravador.newLine();// passa para a proxima linha
		gravador.flush();
		gravador.close();

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
	public void LerArquivoPessoas() {
		// criar lista
		ListaOrdenada<String> listaTelefonica = new ListaOrdenada<String>();
	
		try {
			/*
			 * instancia um objeto do tipo File que recebe o arquivo
			 * telefones.txt da pasta arquivos contida na raiz do projeto
			 */
			File arquivo = new File(("arquivos\\telefones.txt"));

			// Instancia um objeto do tipo Scanner que recebe o arquivo como parametro
			Scanner leitorArquivo = new Scanner(arquivo);
			
			//cria o atributo que concatenara o conteudo do nodo
			String contato="";
			
			System.out.println();//linha em branco meramente decorativa
			
			while (leitorArquivo.hasNextLine()) {// enquanto houver uma proxima linha

				//for para concatenar nome e telefone antes de armazenar
				for(int i=0;i<=1;i++){
					contato = contato + leitorArquivo.nextLine()+"\n";
				}
				
				//System.out.println(contato+"\n");
				
				Nodo<String> novo = new Nodo<String>(contato);
				
				listaTelefonica.insert(novo);
				
				contato="";
				
			}//fim do while hasNextLine
			
			listaTelefonica.print();//manda imprimir a lista
			leitorArquivo.close();// fechamento do leitor
			
		} catch (Exception FileNotFoundException) {
			System.out.println("Arquivo de telefones não encontrado!");
		} 

	}//fim do metodo lerArquivoPessoas
	
}//fim da classe PessoaController