package mvc.controller;

import java.util.Random;

import mvc.model.*;
import mvc.view.*;

public class TabuleiroController {

	private Tabuleiro jogo;
	private ConsoleView view;
	Jogador jogador;

	String[][] matriz = new String[10][10];// cria a matriz do tabuleiro
	String[][] matrizMascara = new String[10][10];// cria a matriz que oculta o tabuleiro
	PortaAvioes[] vetorPortaAvioes = new PortaAvioes[1];
	Destroyer[] vetorDestroyers = new Destroyer[2];
	Fragata[] vetorFragatas = new Fragata[2];
	Torpedeiro[] vetorTorpedeiros = new Torpedeiro[3];
	Submarino[] vetorSubmarinos = new Submarino[5];

	private String imagemMatriz, imagemMascara;
	
	public void startGame() {
		jogo = new Tabuleiro();// cria o objeto do tipo Tabuleiro
		jogo.setColumns(10);// define a qtdade de colunas
		jogo.setRows(10);// define a qtdade de linhas
		view = new ConsoleView();// cria o objeto do tipo ConsoleView
		jogador = new Jogador();// cria o objeto do tipo Jogador

		fillMatrixes();// inicializa a matriz com os pontos
		assortShips();// distribui as embarcacoes
	}

	public boolean win(){
		boolean venceu=false;
		
		imagemMatriz = view.returnMatrix(matriz, 10, 10);
		imagemMascara = view.returnMatrix(matrizMascara, 10, 10);
		
		if(imagemMascara.equals(imagemMatriz))
			venceu=true;
		
		return venceu;
	}

	public void assortShips() {

		/*
		 * 1 porta-avioes com 5 unidades de tamanho. 2 destroyers com 4 unidades
		 * de tamanho. 2 fragatas com 3 unidades de tamanho. 3 torpedeiros com 2
		 * unidades de tamanho. 5 submarinos, com 1 unidade de tamanho.
		 */

		insertAirCraftCarrier(vetorPortaAvioes, 5);
		insertDestroyer(vetorDestroyers, 4);
		insertFrigate(vetorFragatas, 3);
		insertTorpedoBoat(vetorTorpedeiros, 2);
		insertSubmarine(vetorSubmarinos, 1);
	}

	public void insertAirCraftCarrier(PortaAvioes[] vetor, int tamanho) {
		String orientacao;
		int x, y;

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = new PortaAvioes();
			// define o tamanho da embarcacao
			vetor[i].setTamanho(tamanho);

			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());

			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h

			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);

			// insere a embarcacao no tabuleiro
			insertShip(x, y, orientacao, vetor[i].getTamanho());
		}

	}// fim do metodo insertAirCraftCarrier

	public void insertDestroyer(Destroyer[] vetor, int tamanho) {
		String orientacao;
		int x, y;

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = new Destroyer();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);

			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());

			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h

			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);

			// insere a embarcacao no tabuleiro
			insertShip(x, y, orientacao, vetor[i].getTamanho());
		}

	}// fim do metodo insertDestroyer

	public void insertFrigate(Fragata[] vetor, int tamanho) {
		String orientacao;
		int x, y;

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = new Fragata();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);

			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());

			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h

			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);

			// insere a embarcacao no tabuleiro
			insertShip(x, y, orientacao, vetor[i].getTamanho());
		}
	}// fim do metodo insertFrigate

	public void insertTorpedoBoat(Torpedeiro[] vetor, int tamanho) {
		String orientacao;
		int x, y;

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = new Torpedeiro();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);

			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());

			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h

			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);

			// insere a embarcacao no tabuleiro
			insertShip(x, y, orientacao, vetor[i].getTamanho());
		}
	}// fim do metodo insertTorpedoBoat

	public void insertSubmarine(Submarino[] vetor, int tamanho) {
		String orientacao;
		int x, y;

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = new Submarino();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);

			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());

			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h

			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);

			// insere a embarcacao no tabuleiro
			insertShip(x, y, orientacao, vetor[i].getTamanho());
		}

	}// fim do metodo insertSubmarine

	public void insertShip(int x, int y, String orientacao, int tamanhoEmbarc) {

		for (int i = 0; i < tamanhoEmbarc; i++) {
			if (orientacao.equals("h"))
				matriz[x][y + i] = "O";
			else
				matriz[x + i][y] = "O";
		}
	}

	public String recognitionMission(int tamanhoEmbarc) {
		String orientacao;
		String xyz;// linha, coluna, orientacao

		int x, y, orientacaoInt;
		int iFor;
		int limiteTabuleiro;// para evitar colocar embarcacoes para fora do
							// tabuleiro
		boolean ocupado = true;

		do {
			// gera randomicamente a orientacao v/h
			orientacaoInt = generateRandomPosition();

			if (orientacaoInt > 0) {
				orientacao = "v";
			} else {
				orientacao = "h";
			}

			// gera randomicamente a possivel posicao
			x = generateRandomLocation();
			y = generateRandomLocation();

			// prepara os limites para uso do for
			if (orientacao.equals("v")) {
				iFor = x;// usa o valor da linha por se posicionar ao longo da
							// mesma
				limiteTabuleiro = jogo.getRows();
			} else {
				iFor = y;// usa o valor da coluna por se posicionar ao longo da
							// mesma
				limiteTabuleiro = jogo.getColumns();
			}

			// se o limite menos a posicao for maior que o tamanho da
			// embarcacao, nao ha espaco suficiente
			if ((limiteTabuleiro - iFor) < tamanhoEmbarc) {
				ocupado = true;
			} else {
				// define ocupacao falsa, caso nao encontre ocupacao se mantem assim
				ocupado = false;
				// executa o for para testar posicoes ocupadas
				for (int i = iFor; i < tamanhoEmbarc; i++) {
					// verifica se a posicao esta ocupada
					if (matriz[x][y].equals("0")) {
						ocupado = true;
						// forca a saida do for ao encontrar um espaco ocupado
						i = tamanhoEmbarc;
					}
				}
			}// fim do else onde ha espaco suficiente
		} while (ocupado);

		xyz = Integer.toString(x) + Integer.toString(y) + orientacao;
		return xyz;
	}

	public int generateRandomPosition() {// randomiza a posicao 0=v , 1=h
		Random gerador = new Random();
		int posicao = gerador.nextInt(2);

		return posicao;
	}

	public int generateRandomLocation() {// randomiza as coordenadas xy
		Random gerador = new Random();
		int localizacao = gerador.nextInt(10);
		return localizacao;
	}

	public void fillMatrixes() {
		for (int x = 0; x < matriz.length; x++)
			for (int y = 0; y < matriz[x].length; y++) {
				matriz[x][y] = ".";
				matrizMascara[x][y] = ".";
			}
	}

	public void printMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		view.printMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}

	public void printMaskMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		view.printMatrix(matrizMascara, jogo.getRows(), jogo.getColumns());
	}

	public boolean damageConfirmation(int x, int y) {
		boolean confirmed = false;

		if (matriz[x][y].equals("O"))
			confirmed = true;

		return confirmed;
	}

	public void airCraftCarrierReport(int x, int y) {
		int testeX, testeY;			
			// for que percorre as partes da embarcacao
			for (int j = 0; j < vetorPortaAvioes[0].getTamanho(); j++) {
				
				String orientacao = vetorPortaAvioes[0].getOrientacao();

				if (orientacao.equals("v")) {// se esta na vertical
					// somado j na posicao X para percorrer as casas na vertical
					testeX = vetorPortaAvioes[0].getPosicaoPopa()[0]+ j;
					testeY = vetorPortaAvioes[0].getPosicaoPopa()[1];
				} else {
					testeX = vetorPortaAvioes[0].getPosicaoPopa()[0];
					testeY = vetorPortaAvioes[0].getPosicaoPopa()[1]+ j;
				}
				// se a posicao lida corresponde ao tiro
				if ((testeX == x) && (testeY == y)) {
					// incrementa dano da embarcacao
					vetorPortaAvioes[0].setDano(vetorPortaAvioes[0].getDano() + 1);
					
					// verifica se apos computar dano a embarcacao foi afundada
					// acrescenta + 2 pontos ao jogador
					if (vetorPortaAvioes[0].getDano() == vetorPortaAvioes[0]
							.getTamanho()) {
						jogador.setPontos(jogador.getPontos() + 2);
						System.out.println("Embarcacao afundada!");
					}
				}
			}// fim do for j
	}// fim do metodo

	public void destroyerReport(int x, int y) {
		int testeX, testeY;
		// for percorre que percorre as embarcacoes do  tipo
		for (int i = 0; i < vetorDestroyers.length; i++) {
			// for que percorre as partes da embarcacao
			for (int j = 0; j < vetorDestroyers[0].getTamanho(); j++) {
				String orientacao = vetorDestroyers[i].getOrientacao();

				if (orientacao.equals("v")) {// se esta na vertical
					// somado j na posicao X para percorrer as casas na vertical
					testeX = vetorDestroyers[0].getPosicaoPopa()[0]+ j;
					testeY = vetorDestroyers[0].getPosicaoPopa()[1];
				} else {
					testeX = vetorDestroyers[0].getPosicaoPopa()[0];
					testeY = vetorDestroyers[0].getPosicaoPopa()[1]+ j;
				}
				// se a posicao lida corresponde ao tiro
				if ((testeX == x) && (testeY == y)) {
					// incrementa dano da embarcacao
					vetorDestroyers[i].setDano(vetorDestroyers[i].getDano() + 1);
					
					// verifica se apos computar dano a embarcacao foi afundada
					// acrescenta + 2 pontos ao jogador
					if (vetorDestroyers[i].getDano() == vetorDestroyers[i]
							.getTamanho()) {
						jogador.setPontos(jogador.getPontos() + 2);
						System.out.println("Embarcacao afundada!");
					}
				}
			}// fim do for j
		}// fim do for i
	}// fim do metodo

	public void frigateReport(int x, int y) {
		int testeX, testeY;
		// for percorre que percorre as embarcacoes do  tipo
		for (int i = 0; i < vetorFragatas.length; i++) {
			// for que percorre as partes da embarcacao
			for (int j = 0; j < vetorFragatas[0].getTamanho(); j++) {
				String orientacao = vetorFragatas[i].getOrientacao();

				if (orientacao.equals("v")) {// se esta na vertical
					// somado j na posicao X para percorrer as casas na vertical
					testeX = vetorFragatas[0].getPosicaoPopa()[0]+ j;
					testeY = vetorFragatas[0].getPosicaoPopa()[1];
				} else {
					testeX = vetorFragatas[0].getPosicaoPopa()[0];
					testeY = vetorFragatas[0].getPosicaoPopa()[1]+ j;
				}
				// se a posicao lida corresponde ao tiro
				if ((testeX == x) && (testeY == y)) {
					// incrementa dano da embarcacao
					vetorFragatas[i].setDano(vetorFragatas[i].getDano() + 1);
					
					// verifica se apos computar dano a embarcacao foi afundada
					// acrescenta + 2 pontos ao jogador
					if (vetorFragatas[i].getDano() == vetorFragatas[i]
							.getTamanho()) {
						jogador.setPontos(jogador.getPontos() + 2);
						System.out.println("Embarcacao afundada!");
					}
				}
			}// fim do for j
		}// fim do for i
	}// fim do metodo

	public void torpedoBoatReport(int x, int y) {
		int testeX, testeY;
		// for percorre que percorre as embarcacoes do  tipo
		for (int i = 0; i < vetorTorpedeiros.length; i++) {
			// for que percorre as partes da embarcacao
			for (int j = 0; j < vetorTorpedeiros[0].getTamanho(); j++) {
				String orientacao = vetorTorpedeiros[i].getOrientacao();

				if (orientacao.equals("v")) {// se esta na vertical
					// somado j na posicao X para percorrer as casas na vertical
					testeX = vetorTorpedeiros[0].getPosicaoPopa()[0]+ j;
					testeY = vetorTorpedeiros[0].getPosicaoPopa()[1];
				} else {
					testeX = vetorTorpedeiros[0].getPosicaoPopa()[0];
					testeY = vetorTorpedeiros[0].getPosicaoPopa()[1]+ j;
				}
				// se a posicao lida corresponde ao tiro
				if ((testeX == x) && (testeY == y)) {
					// incrementa dano da embarcacao
					vetorTorpedeiros[i].setDano(vetorTorpedeiros[i].getDano() + 1);
				
					// verifica se apos computar dano a embarcacao foi afundada
					// acrescenta + 2 pontos ao jogador
					if (vetorTorpedeiros[i].getDano() == vetorTorpedeiros[i]
							.getTamanho()) {
						jogador.setPontos(jogador.getPontos() + 2);
						System.out.println("Embarcacao afundada!");
					}
				}
			}// fim do for j
		}// fim do for i
	}// fim do metodo
	
	public void submarineReport(int x, int y) {
		int testeX, testeY;
		// for percorre que percorre as embarcacoes do  tipo
		for (int i = 0; i < vetorSubmarinos.length; i++) {
					testeX = vetorSubmarinos[i].getPosicaoPopa()[0];
					testeY = vetorSubmarinos[i].getPosicaoPopa()[1];
	
				// se a posicao lida corresponde ao tiro
				if ((testeX == x) && (testeY == y)) {					
					// incrementa dano da embarcacao
					vetorSubmarinos[i].setDano(vetorSubmarinos[i].getDano() + 1);
					
					// verifica se apos computar dano a embarcacao foi afundada
					// acrescenta + 2 pontos ao jogador
					if (vetorSubmarinos[i].getDano() == vetorSubmarinos[i].getTamanho()) {
						jogador.setPontos(jogador.getPontos() + 2);
						System.out.println("Embarcacao afundada!");
					}
				}
		}// fim do for i
	}// fim do metodo
	
	public void damageReport(int x, int y) {
		airCraftCarrierReport(x,y);
		destroyerReport(x,y);
		frigateReport(x,y);
		torpedoBoatReport(x,y);
		submarineReport(x,y);
	}
	public void updateMaskMatrix(int x, int y, boolean acerto) {

		if (acerto)
			matrizMascara[x][y] = "O";
		else
			matrizMascara[x][y] = "-";
	}

	/*
	 * Metodo returnIntegerXY: Retorna, em formato inteiro a coordenada X ou Y.
	 * 
	 * @param parXy uma string contendo o par de coordenadas
	 * 
	 * @param parte um char com dois valores possiveis(x/y)
	 * 
	 * @return int retorna a coordenada (x/y) em formato inteiro
	 */

	public int returnIntegerXY(String parXY, char parte) {
		int inicio, coordenada;

		if (parte == 'x')
			inicio = 0;
		else
			inicio = 1;

		coordenada = Integer.parseInt(parXY.substring(inicio, inicio + 1));
		return coordenada;
	}

	/*
	 * Metodo returnStringXY: Retorna, em formato String a coordenada X ou Y.
	 * 
	 * @param parXy uma string contendo o par de coordenadas
	 * 
	 * @param parte um char com dois valores possiveis(x/y)
	 * 
	 * @return int retorna a coordenada (x/y) em formato String
	 */
	public String returnStringXY(String parXY, char parte) {
		int inicio;
		String coordenada;

		if (parte == 'x')
			inicio = 0;
		else
			inicio = 1;

		coordenada = parXY.substring(inicio, inicio + 1);
		return coordenada;
	}

	public void play() {
		String jogada, x, y;
		int intX = 0, intY = 0;
		boolean acertou;

		if (jogador.getPontos()>0){
		
		if (jogador.getNome().equals("johnDoe"))
			jogador.setNome(view.read("Nome"));

		jogada = view.read("Jogada (linha/coluna) ");

		try {

			// x recebe a posicao X da jogada recebida
			x = returnStringXY(jogada, 'x');

			// y recebe a posicao Y do metodo getJogada
			y = returnStringXY(jogada, 'y');

			// caso jogada seja feita ao contrario: coluna/linha,
			// inverte os valores
			if(y.matches("[0-9]"))
				if ((Integer.parseInt(y) <= jogo.getRows())
						&& x.matches("[a-jA-J]")) {
					String aux = x;
					x = y;
					y = aux;
				}
			/*
			System.out.println("X=" + x+" e menor ou igual a "+jogo.getRows()+ " : "+ (Integer.parseInt(x) <= jogo.getRows()));
			System.out.println("Y=" + y+" esta contigo entre a-j: "+ y.matches("[a-jA-J]"));
			*/
			if(x.matches("[0-9]"))
			if ((Integer.parseInt(x) <= jogo.getRows())
					&& y.matches("[a-jA-J]")) {

				// recebe o valor inteiro da posicao X da jogada
				// intX = returnIntegerXY(jogada,'x');//removido para poder inverter
				intX = Integer.parseInt(x);
				
				// recebe a letra (posicao Y) da jogada, busca o indice numerico
				// da mesma
				intY = view.getIndex(y);

				/*
				// recebe a posicao Y numerica e transforma em string para
				// passar pro metodo damageConfirmation
				y = Integer.toString(intY);
				*/

				/* verifica, na matriz mascara, se o tiro ja foi dado nessa
				 * posicao. Caso nao tenha sido dado segue para a 
				 * verificacao. Isto evita pontuar uma area ja atingida
				 */
				if (matrizMascara[intX][intY].equals("O")
						|| matrizMascara[intX][intY].equals("-")) {
					System.out.println("Essa jogada ja foi feita!");
				} else {		
					// decrementa os pontos
					jogador.setPontos(jogador.getPontos() - 1);
					
					// armazena a situacao do tiro e faz atualizacoes
					acertou = damageConfirmation(intX, intY);
					if (acertou) {
						// informa que acertou
						System.out.println("Tiro acertou uma embarcacao!");

						/*
						 * chama o metodo damageReport() que:
						 * - verifica se a embarcacao se encontra na posicao do tiro;
						 * - insere o dano na embarcacao;
						 * - verifica se a embarcacao foi destruida(dano=tamanho);
						 */
						damageReport(intX, intY);

						// armazena os pontos normais
						jogador.setPontos(jogador.getPontos() + 3);

						// informa os pontos do jogador
						System.out.println("Pontos do jogador "
								+ jogador.getNome() + ": "
								+ jogador.getPontos());

						// insere o dano na matrizMascara
						updateMaskMatrix(intX, intY, acertou);

					}// fim do "se acertou"
					else {
						System.out.println("Tiro acertou apenas agua!");
						// informa os pontos do jogador
						System.out.println("Pontos do jogador "
								+ jogador.getNome() + ": "
								+ jogador.getPontos());
						// insere o erro na matrizMascara
						updateMaskMatrix(intX, intY, acertou);
					}
				}// fim do else, jogada nao feita
			}// fim do teste de validacao simples

		} catch (Exception E) {
			//E.printStackTrace();
			System.out
					.println("Jogada invalida! formato aceito: numero(linha)/letra(coluna), Ex.: 1a ");
		}
		}//fim do if pontos de jogador diferente de zero
		else{
			System.out.println("********** G A M E  O V E R **********");
			System.exit(0);
		}
	}// fim do metodo play


}// fim da classe TabuleiroController
