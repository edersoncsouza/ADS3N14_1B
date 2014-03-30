package mvc.controller;

import java.util.Random;

import mvc.model.Embarcacao;
import mvc.model.Tabuleiro;
import mvc.view.ConsoleView;

public class TabuleiroController {

	private Tabuleiro jogo;
	private ConsoleView view;

	String[][] matriz = new String[10][10];

	public void inicializaJogo() {
		jogo = new Tabuleiro();
		jogo.setColumns(10);
		jogo.setRows(10);
		view = new ConsoleView();

		fillMatrix();
		assortShips();
	}

	public void assortShips() {
		int limitePortaAvioes = 1;
		int limiteDestroyer = 2;
		int limiteFragata = 2;
		int limiteTorpedeiro = 3;
		int limiteSubmarinos = 5;
		String[][] posicaoEmbarc = new String[1][1];
		int x, y;
		/*
		boolean ocupado = true;

		if (ocupado) {
			System.out.println("Posicao ocupada!");
		} else
			System.out.println("Posicao livre!");
		*/
		insertAirCraftCarrier();// insertAirCraftCarrier(String[][] localizacao)
		insertDestroyer();
		insertFrigate();
		insertTorpedoBoat();
		insertSubmarine();

	}

	public void insertAirCraftCarrier() {
		Embarcacao portaAvioes = new Embarcacao();
		String orientacao;
		int tipoEmbarc, tamanhoEmbarc;
		int x, y;

		tamanhoEmbarc = portaAvioes.getTamanho("Porta-Avioes");
		System.out.println("Tamanho da embarcacao "  + tamanhoEmbarc);
		
		tipoEmbarc = 0;// zero representa PortaAvioes

		// zero e a primeira posicao do vetor dos tipos de embarcacoes,
		// PortaAvioes
		portaAvioes.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);
		
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x
		
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		
		orientacao = localizacao.substring(2);// separa a parte v/h
		System.out.println("Orientacao: " + orientacao);

		// define a orientacao da embarcacao
		portaAvioes.setOrientacao(orientacao);

		// define a posicao da embarcacao
		portaAvioes.setPosicaoPopa(x, y);

		// imprime a posicao gerada
		System.out.println("Posicao gerada: " + x + y);

		// grava na matriz
		matriz[x][y] = "0";
	}

	public void insertFrigate() {

	}

	public void insertTorpedoBoat() {

	}

	public void insertSubmarine() {

	}

	public void insertDestroyer() {

	}

	public String recognitionMission(int tamanhoEmbarc) {
		String orientacao;
		String xyz;// linha, coluna, orientacao

		int x, y;
		int iFor;
		int limiteTabuleiro;// para evitar colocar embarcacoes para fora do tabuleiro
		boolean ocupado = true;

		do {

			// gera randomicamente a orientacao v/h
			if (generateRandomPosition() > 0) {
				orientacao = "v";
			} else {
				orientacao = "h";
			}

			// gera randomicamente a possivel posicao
			x = generateRandomLocation();
			y = generateRandomLocation();

			// prepara os limites para uso do for
			if (orientacao.equals("v")) {
				iFor = x;// usa o valor da linha por se posicionar ao longo da mesma
				limiteTabuleiro = jogo.getRows();
			} else {
				iFor = y;// usa o valor da coluna por se posicionar ao longo da  mesma
				limiteTabuleiro = jogo.getColumns();
			}

			// se o limite menos a posicao for maior que o tamanho da
			// embarcacao, nao ha espaco suficiente
			if ((limiteTabuleiro - iFor) < tamanhoEmbarc) {
				ocupado = true;
				System.out.println("Limite do tabuleiro: " + limiteTabuleiro);
				System.out.println("iFor: " + iFor);
				System.out.println("Tamanho da embarcacao: " + tamanhoEmbarc);
				System.out.println("Nao cabia aqui!");
			} else {
				// executa o for para testar posicoes ocupadas
				for (int i = iFor; i < tamanhoEmbarc; i++) {

					// verifica se a posicao esta ocupada
					if (matriz[x][y].equals(".")) {

						ocupado = false;
					} else {
						ocupado = true;
						i = tamanhoEmbarc;//forca a saida do for ao encontrar um espaco ocupado
					}
				}
			}//fim do else onde ha espaco suficiente
		} while (ocupado);
		
		xyz = Integer.toString(x) +Integer.toString(y) + orientacao;
		System.out.println("XYZ: " + xyz);
		return xyz;
	}

	public int generateRandomPosition() {// randomiza a posicao 0=v , 1=h
		Random gerador = new Random();
		int posicao = gerador.nextInt(1);

		return posicao;
	}

	public int generateRandomLocation() {// randomiza as coordenadas xy
		Random gerador = new Random();
		int localizacao = gerador.nextInt(10);
		return localizacao;
	}

	public void fillMatrix() {
		for (int x = 0; x < matriz.length; x++)
			for (int y = 0; y < matriz[x].length; y++)
				matriz[x][y] = ".";
		// matriz[x][y] = (Integer.toString(x)+Integer.toString(y));
	}

	public void imprimirCabecalhos() {
		view.cabecalhoColunas(jogo.getColumns());
		view.cabecalhoLinhas(jogo.getRows(), jogo.getColumns());
	}

	public void imprimirMatriz() {
		view.cabecalhoColunas(jogo.getColumns());
		// view.cabecalhoLinhas(jogo.getRows(),jogo.getColumns());//imprimir
		// linha falsa, apenas para teste
		view.printMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}
}
