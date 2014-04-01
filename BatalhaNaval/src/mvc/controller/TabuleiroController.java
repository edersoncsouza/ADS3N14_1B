package mvc.controller;

import java.util.Random;

import mvc.model.*;
import mvc.view.*;

public class TabuleiroController {

	private Tabuleiro jogo;
	private ConsoleView view;
	private Jogador jogador;

	String[][] matriz = new String[10][10];// cria a matriz do tabuleiro
	String[][] matrizMascara = new String[10][10];// cria a matriz que oculta o tabuleiro

	public void startGame() {
		jogo = new Tabuleiro();// cria o objeto do tipo Tabuleiro
		jogo.setColumns(10);// define a qtdade de colunas
		jogo.setRows(10);// define a qtdade de linhas
		view = new ConsoleView();// cria o objeto do tipo ConsoleView
		jogador = new Jogador();// cria o objeto do tipo Jogador

		fillMatrixes();// inicializa a matriz com os pontos
		assortShips();// distribui as embarcacoes
	}

	public void assortShips() {
		
		/*
		 * 1 “porta-aviões” com 5 unidades de tamanho.
		 * 2 “destroyers” com 4 unidades de tamanho.
		 * 2 “fragatas” com 3 unidades de tamanho.
		 * 3 “torpedeiros” com 2 unidades de tamanho.
		 * 5 submarinos, com 1 unidade de tamanho.
		 */
		PortaAvioes[] vetorPortaAvioes = new PortaAvioes[1];
		Destroyer[] vetorDestroyers = new Destroyer[2];
		Fragata[] vetorFragatas = new Fragata[2];
		Torpedeiro[] vetorTorpedeiros = new Torpedeiro[3];
		Submarino[] vetorSubmarinos = new Submarino[5];

		insertAirCraftCarrier(vetorPortaAvioes,5);	
		insertDestroyer(vetorDestroyers,4);
		insertFrigate(vetorFragatas,3);
		insertTorpedoBoat(vetorTorpedeiros,2);
		insertSubmarine(vetorSubmarinos,1);
		
	}

	public void insertAirCraftCarrier(PortaAvioes[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new PortaAvioes();
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
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertAirCraftCarrier
	
	public void insertDestroyer(Destroyer[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
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
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertDestroyer
	
	public void insertFrigate(Fragata[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
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
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
	}//fim do metodo insertFrigate

	public void insertTorpedoBoat(Torpedeiro[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
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
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
	}//fim do metodo insertTorpedoBoat

	public void insertSubmarine(Submarino[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
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
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertSubmarine

	public void insertShip(int x, int y, String orientacao, int tamanhoEmbarc){
		
		for(int i=0;i<tamanhoEmbarc;i++){
			if(orientacao.equals("h"))
			matriz[x][y+i] = "0";
			else
				matriz[x+i][y] = "0";
		}
	}
	
	public String recognitionMission(int tamanhoEmbarc) {
		String orientacao;
		String xyz;// linha, coluna, orientacao

		int x, y, orientacaoInt;
		int iFor;
		int limiteTabuleiro;// para evitar colocar embarcacoes para fora do tabuleiro
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
				/*
				System.out.println("Nao cabia aqui!");
				System.out.println("Limite do tabuleiro: " + limiteTabuleiro);
				System.out.println("Orientacao: " + orientacao);
				System.out.println("iFor: " + iFor);
				System.out.println("Posicao XY: " + Integer.toString(x) +Integer.toString(y));
				System.out.println("Tamanho da embarcacao: " + tamanhoEmbarc);
				*/
			} else {
				//define ocupacao falsa, caso nao encontre ocupacao se mantem assim
				ocupado = false;
				// executa o for para testar posicoes ocupadas
				for (int i = iFor; i < tamanhoEmbarc; i++) {
					// verifica se a posicao esta ocupada
					if (matriz[x][y].equals("0")) {
						ocupado = true;
						i = tamanhoEmbarc;//forca a saida do for ao encontrar um espaco ocupado
					}
				}
			}//fim do else onde ha espaco suficiente
		} while (ocupado);
		
		xyz = Integer.toString(x) +Integer.toString(y) + orientacao;
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
			for (int y = 0; y < matriz[x].length; y++){
				matriz[x][y] = ".";
				matrizMascara[x][y] = ".";
			}
	}

	public void printHeaders() {
		view.cabecalhoColunas(jogo.getColumns());
		view.cabecalhoLinhas(jogo.getRows(), jogo.getColumns());
	}

	public void printMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		// view.cabecalhoLinhas(jogo.getRows(),jogo.getColumns());//imprimir linha falsa, apenas para teste
		view.printMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}
	
	public void printMaskMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		view.printMaskMatrix(matrizMascara, jogo.getRows(), jogo.getColumns());
	}
	
	//public boolean damageConfirmation(String jogada){
	public boolean damageConfirmation(int x, int y){
		//int x,y;
		boolean confirmed=false;	
		
		//x = Integer.parseInt(jogada.substring(0,1));//.charAt(0);// separa a parte x	
		//y =  Integer.parseInt(jogada.substring(1,2));// separa a parte y
		
		if (matriz[x][y].equals("0")) 
				confirmed = true;
		
		return confirmed;
		}

	public void damageReport(int x, int y){
		// buscar entre as embarcacoes alguma que esteja na posicao xy
		
		// devolve a posicao, insere o dano ou chama algum metodo que insira
	}
	
	public void updateMaskMatrix(int x, int y, boolean acerto){
		
		if(acerto)		
			matrizMascara[x][y]="O";
		else
			matrizMascara[x][y]="-";
	}
	
	/*
	 * Metodo returnIntegerXY:		Retorna, em formato inteiro a coordenada X ou Y.
	 * 
	 * @param	parXy	uma string contendo o par de coordenadas
	 * @param	parte	um char com dois valores possiveis(x/y)
	 * @return	int		retorna a coordenada (x/y) em formato inteiro  
	 */
	
	public int returnIntegerXY(String parXY, char parte){
		int inicio, coordenada;
		
		if(parte=='x' )
			inicio=0;
		else
			inicio = 1;
		
		coordenada = Integer.parseInt(parXY.substring(inicio,inicio+1));
		return coordenada;
	}
	
	/*
	 * Metodo returnStringXY:		Retorna, em formato String a coordenada X ou Y.
	 * 
	 * @param	parXy	uma string contendo o par de coordenadas
	 * @param	parte	um char com dois valores possiveis(x/y)
	 * @return	int		retorna a coordenada (x/y) em formato String  
	 */
	public String returnStringXY(String parXY, char parte){
		int inicio;
		String coordenada;
		
		if(parte=='x' )
			inicio=0;
		else
			inicio = 1;
		
		coordenada = parXY.substring(inicio,inicio+1);
		return coordenada;
	}
	
	public void play() {
		String jogada,x,y;
		int intX=0, intY=0;
		boolean acertou;
		
		if(jogador.getNome().equals("johnDoe"))
		jogador.setNome(view.read("Nome"));
		
		jogada = view.read("Jogada (linha/coluna): ");
		
		// embuxa jogada para evitar vazio
		if (jogada.equals(""))
			jogada="00";
		
		// x recebe a posicao X da jogada recebida
		x = returnStringXY(jogada,'x');
		
		// y recebe a posicao Y do metodo getJogada
		y = returnStringXY(jogada,'y');
		
		if((Integer.parseInt(x)<=jogo.getRows()) && y.matches("[a-jA-J]")  ){
		
		// recebe a letra (posicao Y) da jogada, busca o indice numerico da mesma
		intY = view.getIndex(y);
		
		// recebe a posicao Y numerica e transforma em string para passar pro metodo damageConfirmation
		y = Integer.toString(intY);

		//armazena a situacao do tiro e faz atualizacoes
		acertou = damageConfirmation(intX, intY);
		if (acertou){
			/*
			 * modificar aqui para:
			 * 1 - informar que acertou
			 * 2 - chamar um metodo que verifique que embarcacao se encontra naquela posicao
			 * 3 - inserir o dano para aquela embarcacao
			 * 4 - verificar se a embarcacao foi destruida (dano=tamanho)
			 * 5 - armazenar pontos do jogador
			 * 6 - informar pontos do jogador
			 * 7 - atualizar a matrizMascara
			 */
			
			// 1 - informa que acertou
			System.out.println("Tiro acertou uma embarcacao!");
			
			// 2 - chamar um metodo que verifique que embarcacao se encontra naquela posicao
			damageReport(intX, intY);
			
			// informa os pontos do jogador
			System.out.println("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
			
			// insere o dano na embarcacao
			
			// armazena os pontos (por enquanto nao computa destruicao - 5 pontos
			jogador.setPontos(jogador.getPontos()+3);
			
			// insere o dano na matrizMascara
			updateMaskMatrix(intX,intY, acertou);
			
		}else{
			System.out.println("Tiro acertou apenas agua!");
			//decrementa os pontos (por enquanto nao computa destruicao - 5 pontos
			jogador.setPontos(jogador.getPontos()-1);
			//informa os pontos do jogador
			System.out.println("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
			//insere o erro na matrizMascara
			updateMaskMatrix(intX,intY, acertou);
		}
		
	}else{
		System.out.println("Jogada invalida! formato aceito: numero(linha)/letra(coluna), Ex.: 1a ");
	}
		//fim do if de validacao da jogada
		
	}//fim do metodo play
	
}//fim da classe TabuleiroController
