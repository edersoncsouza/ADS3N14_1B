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
		String[][] posicaoEmbarc=new String[1][1];
		int x, y;
		boolean ocupado = true;
		
		//posicaoEmbarc[x][y]= "0";
		
		//imprime a posicao gerada
		//System.out.println("Posicao gerada: " + x+y);
				
		//verifica se a posicao esta ocupada
		//ocupado=recognitionMission(posicaoEmbarc);
		
		if(ocupado){
			System.out.println("Posicao ocupada!");
		}else System.out.println("Posicao livre!");

		
		insertAirCraftCarrier();//insertAirCraftCarrier(String[][] localizacao)
		insertDestroyer();
		insertFrigate();
		insertTorpedoBoat();
		insertSubmarine();
		
		
	}
	
	public void insertAirCraftCarrier(){
		Embarcacao portaAvioes = new Embarcacao();
		String orientacao;
		int x,y;
		
		//zero e a primeira posicao do vetor dos tipos de embarcacoes, PortaAvioes
		portaAvioes.setTipoEmbarc(0);
		
		//define randomicamente a orientacao v/h
		if(generateRandomPosition()>0){
			portaAvioes.setOrientacao("v");
		}else{
			portaAvioes.setOrientacao("h");
		}
		
		//gera randomicamente a possivel posicao
		x = generateRandomLocation();
		y = generateRandomLocation();
		
		//define a posicao da embarcacao
		portaAvioes.setPosicaoPopa(x,y);
		
		//grava na matriz
		matriz[x][y]="0";
	}
	
	public void insertFrigate(){
		
	}
	
	public void insertTorpedoBoat(){
		
	}
	
	public void insertSubmarine(){
		
	}
	
	public void insertDestroyer(){
		
	}

	public boolean recognitionMission(String posicao, String tipo, String orientacao) {
		boolean ocupado = true;
		int x = Character.getNumericValue(posicao.charAt(0));
		int y = Character.getNumericValue(posicao.charAt(1));

		if (matriz[x][y].equals(".")) {
			ocupado = false;
		}
		return ocupado;
	}

	public int generateRandomPosition() {//randomiza a posicao 0=v , 1=h
		Random gerador = new Random();
		int posicao = gerador.nextInt(1);
		
		return posicao;
	}
	
	public int generateRandomLocation() {//randomiza as coordenadas xy
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
		// view.cabecalhoLinhas(jogo.getRows(),jogo.getColumns());//imprimir linha falsa, apenas para teste
		view.printMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}
}
