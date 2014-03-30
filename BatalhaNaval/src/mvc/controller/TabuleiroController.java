package mvc.controller;

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
