package mvc.view;

import static java.lang.System.out;
import java.util.Scanner;

public class ConsoleView {

	private Scanner teclado = new Scanner(System.in);

	public void message(String message) {
		out.println(message);
	}

	public String read(String prompt) {
		out.print(prompt + ": ");
		return teclado.nextLine();
	}

	public void logError(String message) {
		message("Error: " + message);
	}
	
	public String[] cabecColumns = { "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J" };

	public void cabecalhoColunas(int colunas) {
		String cabecalho = " ";
		for (int i = 0; i < colunas; i++) {
			cabecalho = cabecalho + "\t" + cabecColumns[i];
		}
		System.out.println(cabecalho);
	}

	public void cabecalhoLinhas(int linhas, int colunas) {

		for (int j = 0; j < linhas; j++) {

			String cabecalho = Integer.toString(j);// acrescenta o numero da
													// linha a string antes dos
													// pontos

			for (int i = 0; i < colunas; i++) {
				cabecalho = cabecalho + "\t" + ".";
			}
			System.out.println(cabecalho);

		}
	}

	public void printFakeMatrix(String[][] matrix, int rows, int columns) {

		for (int x = 0; x < rows; x++) {

			String header = Integer.toString(x);// acrescenta o numero da linha
												// a string antes dos pontos

			for (int y = 0; y < columns; y++) {
				header = header + "\t" + ".";// cria uma linha apenas com pontos
												// e nao com valor da matriz
			}
			System.out.println(header);
		}
	}

	public void printMatrix(String[][] matrix, int rows, int columns) {

		for (int x = 0; x < rows; x++) {

			String header = Integer.toString(x);// acrescenta o numero da linha
												// a string antes dos pontos

			for (int y = 0; y < columns; y++) {
				header = header + "\t" + matrix[x][y];
			}
			System.out.println(header);
		}
	}

	public int getIndex(String letter){
		int indice=-1;
		
		letter = letter.toUpperCase();
		
		for(int i=0;i<cabecColumns.length;i++){
			
			if (letter.equals(cabecColumns[i])){
				indice=i;
				i=cabecColumns.length;//para forçar a sair do for mais cedo
			}
		}
		return indice;
	}

}