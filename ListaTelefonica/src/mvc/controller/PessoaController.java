/*
 * Classe Controller da aplicacao 
 * 
 * @author Rafael Guterres Jeffman, Ederson Souza
 * 
 * @version 1.0.1 
 */
package mvc.controller;

import mvc.model.Pessoa;
import mvc.model.NodoD;
import mvc.view.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PessoaController {

	private PessoaView view;
	private Pessoa pessoa;
	Scanner leitor = new Scanner(System.in);
	String caminho = "arquivos/telefones.txt";// localizacao relativa do arquivo
												// no projeto
	String sO = System.getProperty("os.name").toLowerCase();// sistema
															// operacional em
															// que esta rodando
	ListaDuplamenteEncadeada<String> listaTelefonica = new ListaDuplamenteEncadeada<String>(); // criar
																								// lista

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

		// Identifica se o sistema operacional que esta rodando e windows
		if (sO.indexOf("win") >= 0) {
			// Substitui contrabarras por barras
			caminho = caminho.replace("\\", "/");
		}

		// Abre arquivo para escrita
		BufferedWriter gravador = new BufferedWriter(new FileWriter(caminho,
				true));

		System.out.println("Digite o nome da pessoa: ");
		gravador.write((leitor.next()).toUpperCase());// converte para maiusc e
														// grava

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

	public NodoD<String> buscaPessoa() {
		NodoD<String> novo = listaTelefonica.head;//define o inicio da pesquisa para a lista completa
		String letraInicial;

		System.out.println("Digite a inicial do contato a procurar: ");
		letraInicial = leitor.next().toUpperCase();// armazena na string
		
		while (novo != null) {
			// atributo recebe o primeiro caracter da transf em string do dado
			String inicialContato = (novo.getDado().substring(0, 1));
			
			if (inicialContato.equals(letraInicial)) {
				return novo;
			}
			novo=novo.getNext();
		}		
		return novo;		
	}

	public String trazElemento(String inicialBusca) {

		NodoD<String> nodo = listaTelefonica.head;
		NodoD<String> anterior = null;
		String contatoEncontrado = "";

		while (nodo != null) {
			// atributo recebe o primeiro caracter da transf em string do dado
			// do nodo
			String inicialContato = (nodo.getDado().toString().substring(0, 1));

			if (inicialContato.equals(inicialBusca)) {
				contatoEncontrado = nodo.getDado().toString();

				// impressao de verificacao1
				System.out.println("Retornando encontrado: " + "\n"
						+ contatoEncontrado);

				return contatoEncontrado;
			}
		}// fim do while

		return "Nada encontrado";

	}

	/*
	 * Metodo LerArquivoPessoas <p>Este metodo deve trazer os nomes e telefones
	 * salvos em arquivo</p>
	 * 
	 * @Source http://www.guj.com.br/java/78913-ler-arquivo-utilizando-scanner
	 */
	public void lerArquivoPessoas() {

		try {

			// Identifica se o sistema operacional que esta rodando e windows
			if (sO.indexOf("win") >= 0) {
				// Substitui contrabarras por barras
				caminho = caminho.replace("\\", "/");
			}

			/*
			 * instancia um objeto do tipo File que recebe o arquivo
			 * telefones.txt da pasta arquivos contida na raiz do projeto
			 */
			File arquivo = new File(caminho);

			// Instancia um objeto do tipo Scanner que recebe o arquivo como
			// parametro
			Scanner leitorArquivo = new Scanner(arquivo);

			// cria o atributo que concatenara o conteudo do nodo
			String contato = "";

			System.out.println();// linha em branco meramente decorativa

			while (leitorArquivo.hasNextLine()) {// enquanto houver uma proxima
													// linha

				// for para concatenar nome e telefone antes de armazenar
				for (int i = 0; i <= 1; i++) {
					contato = contato + leitorArquivo.nextLine() + "\n";
				}

				NodoD<String> novo = new NodoD<String>(contato);// cria o nodo
																// novo com o
																// conteudo do
																// contato

				listaTelefonica.insert(novo);// insere o nodo na lista

				contato = "";// esvazia a string de concatenacao

			}// fim do while hasNextLine

			listaTelefonica.print();// manda imprimir a lista
			leitorArquivo.close();// fechamento do leitor

		} catch (Exception FileNotFoundException) {
			System.out.println("Arquivo de telefones nao encontrado!");
		}

	}// fim do metodo lerArquivoPessoas

	public ListaDuplamenteEncadeada<String> lerArquivoPessoasRetorno() {

		try {

			// Identifica se o sistema operacional que esta rodando e windows
			if (sO.indexOf("win") >= 0) {
				// Substitui contrabarras por barras
				caminho = caminho.replace("\\", "/");
			}

			/*
			 * instancia um objeto do tipo File que recebe o arquivo
			 * telefones.txt da pasta arquivos contida na raiz do projeto
			 */
			File arquivo = new File(caminho);

			// Instancia um objeto do tipo Scanner que recebe o arquivo como
			// parametro
			Scanner leitorArquivo = new Scanner(arquivo);

			// cria o atributo que concatenara o conteudo do nodo
			String contato = "";

			System.out.println();// linha em branco meramente decorativa

			while (leitorArquivo.hasNextLine()) {// enquanto houver uma proxima
													// linha

				// for para concatenar nome e telefone antes de armazenar
				for (int i = 0; i <= 1; i++) {
					contato = contato + leitorArquivo.nextLine() + "\n";
				}

				NodoD<String> novo = new NodoD<String>(contato);// cria o nodo
																// novo com o
																// conteudo do
																// contato

				listaTelefonica.insert(novo);// insere o nodo na lista

				contato = "";// esvazia a string de concatenacao

			}// fim do while hasNextLine

			// listaTelefonica.print();//manda imprimir a lista
			leitorArquivo.close();// fechamento do leitor

		} catch (Exception FileNotFoundException) {
			System.out.println("Arquivo de telefones nao encontrado!");
		}

		return listaTelefonica;
	}// fim do metodo lerArquivoPessoas

}// fim da classe PessoaController