package mvc.controller;

import java.util.Random;

import mvc.model.Embarcacao;
import mvc.model.Jogador;
import mvc.model.Tabuleiro;
import mvc.view.ConsoleView;

public class TabuleiroController {

	private Tabuleiro jogo;
	private ConsoleView view;
	private Jogador jogador;

	String[][] matriz = new String[10][10];

	public void startGame() {
		jogo = new Tabuleiro();
		jogo.setColumns(10);
		jogo.setRows(10);
		view = new ConsoleView();
		jogador = new Jogador();

		fillMatrix();//preenche a matriz com os pontos
		assortShips();//distribui as embarcacoes
	}

	public void assortShips() {
		
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
		
		tipoEmbarc = 0;// zero representa PortaAvioes

		// zero e a primeira posicao do vetor dos tipos de embarcacoes, PortaAvioes
		portaAvioes.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);	
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		orientacao = localizacao.substring(2);// separa a parte v/h

		// define a orientacao da embarcacao
		portaAvioes.setOrientacao(orientacao);

		// define a posicao da embarcacao
		portaAvioes.setPosicaoPopa(x, y);

		insertShip( x,  y,  orientacao,  tamanhoEmbarc);
		
	}//fim do metodo insertAirCraftCarrier

	public void insertDestroyer() {
		Embarcacao destroyer = new Embarcacao();
		String orientacao;
		int tipoEmbarc, tamanhoEmbarc;
		int x, y;

		tamanhoEmbarc = destroyer.getTamanho("Destroyer");
		
		tipoEmbarc = 2;// dois representa Fragata

		destroyer.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);	
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		orientacao = localizacao.substring(2);// separa a parte v/h

		// define a orientacao da embarcacao
		destroyer.setOrientacao(orientacao);

		// define a posicao da embarcacao
		destroyer.setPosicaoPopa(x, y);

		insertShip( x,  y,  orientacao,  tamanhoEmbarc);
	}//fim do metodo insertDestroyer
	
	public void insertFrigate() {
		Embarcacao fragata = new Embarcacao();
		String orientacao;
		int tipoEmbarc, tamanhoEmbarc;
		int x, y;

		tamanhoEmbarc = fragata.getTamanho("Fragata");
		
		tipoEmbarc = 2;// dois representa Fragata

		fragata.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);	
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		orientacao = localizacao.substring(2);// separa a parte v/h

		// define a orientacao da embarcacao
		fragata.setOrientacao(orientacao);

		// define a posicao da embarcacao
		fragata.setPosicaoPopa(x, y);

		insertShip( x,  y,  orientacao,  tamanhoEmbarc);
	}//fim do metodo insertFrigate

	public void insertTorpedoBoat() {
		Embarcacao torpedeiro = new Embarcacao();
		String orientacao;
		int tipoEmbarc, tamanhoEmbarc;
		int x, y;

		tamanhoEmbarc = torpedeiro.getTamanho("Torpedeiro");
		
		tipoEmbarc = 2;// dois representa Fragata

		torpedeiro.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);	
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		orientacao = localizacao.substring(2);// separa a parte v/h

		// define a orientacao da embarcacao
		torpedeiro.setOrientacao(orientacao);

		// define a posicao da embarcacao
		torpedeiro.setPosicaoPopa(x, y);

		insertShip( x,  y,  orientacao,  tamanhoEmbarc);
	}//fim do metodo insertTorpedoBoat

	public void insertSubmarine() {
		Embarcacao submarino = new Embarcacao();
		String orientacao;
		int tipoEmbarc, tamanhoEmbarc;
		int x, y;

		tamanhoEmbarc = submarino.getTamanho("Submarino");
		
		tipoEmbarc = 2;// dois representa Fragata

		submarino.setTipoEmbarc(tipoEmbarc);

		// recebe a posicao xy e orientacao do metodo recognitionMission
		String localizacao = recognitionMission(tamanhoEmbarc);	
		x = Integer.parseInt(localizacao.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(localizacao.substring(1,2));// separa a parte y
		orientacao = localizacao.substring(2);// separa a parte v/h

		// define a orientacao da embarcacao
		submarino.setOrientacao(orientacao);

		// define a posicao da embarcacao
		submarino.setPosicaoPopa(x, y);

		insertShip( x,  y,  orientacao,  tamanhoEmbarc);
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

	public void fillMatrix() {
		for (int x = 0; x < matriz.length; x++)
			for (int y = 0; y < matriz[x].length; y++)
				matriz[x][y] = ".";
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
	
	public void printFakeMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		view.printFakeMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}
	public boolean damageConfirmation(String jogada){
		int x,y;
		boolean confirmed=false;	
		
		x = Integer.parseInt(jogada.substring(0,1));//.charAt(0);// separa a parte x	
		y =  Integer.parseInt(jogada.substring(1,2));// separa a parte y
		
		if (matriz[x][y].equals("0")) 
				confirmed = true;
		
		return confirmed;
		}

	public void play() {
		String jogada,x,y;
		boolean acertou;
		
		if(jogador.getNome().equals("johnDoe"))
		jogador.setNome(view.read("Nome"));
		
		jogada = view.read("Jogada (linha/coluna): ");
		

		
		//x recebe a posicao X do metodo getJogada
		x=jogada.substring(0,1);
		//y recebe a posicao Y do metodo getJogada
		y=jogada.substring(1,2);
		
		if((Integer.parseInt(x)<=jogo.getRows()) && y.matches("[a-j]")  ){
		
		//recebe a letra (posicao Y) da jogada, busca o indice numerico da mesma
		//transforma novamente em string para passar pro metodo damageConfirmation
		y = Integer.toString(view.getIndex(jogada.substring(1,2)));
			
		//envia pro metodo setJogada a string XY
		jogo.setJogada(x.concat(y));
		
		//decrementa os pontos do jogador devido o tiro dado
		jogador.setPontos(jogador.getPontos()-1);
		
		//armazena a situacao do tiro e faz atualizacoes
		acertou = damageConfirmation(jogo.getJogada());
		if (acertou){
			System.out.println("Tiro acertou uma embarcacao!");
			//armazena os pontos (por enquanto nao computa destruicao - 5 pontos
			jogador.setPontos(jogador.getPontos()+3);
			
			//muda a tela apresentando o local
		}else{
			System.out.println("Tiro acertou apenas agua!");
		}
		
	}else{
		System.out.println("Jogada invalida! formato aceito: numero(linha)/letra(coluna), Ex.: 1a ");
	}
		//fim do if de validacao da jogada
		
	}//fim do metodo play
	
}//fim da classe TabuleiroController
