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
		StringBuffer cabecalho = new StringBuffer();
		for (int i = 0; i < colunas; i++) {
			cabecalho.append("\t" + cabecColumns[i]);
		}
		System.out.println(cabecalho);
	}
	
	public String returnMatrix(String[][] matrix, int rows, int columns) {
		String returnedMatrix;
		//String header = "";
		StringBuffer header = new StringBuffer();
		for (int x = 0; x < rows; x++) {
			header.append(Integer.toString(x));
			// acrescenta o numero da linha a string antes dos pontos
			//header = header + Integer.toString(x);

			// cria uma linha apenas com pontos e nao com valor da matriz
			for (int y = 0; y < columns; y++) {
				if(matrix[x][y].equals("O"))
					header.append("\t" + matrix[x][y]);
					//header = header + "\t" + matrix[x][y];
			}
		}
		returnedMatrix = header.toString();
		return returnedMatrix;
	}
	
	public void printMatrix(String[][] matrix, int rows, int columns) {

		for (int x = 0; x < rows; x++) {
			StringBuffer header = new StringBuffer();
			// acrescenta o numero da linha a string antes dos pontos
			//String header = Integer.toString(x);
			header.append(Integer.toString(x));
			
			for (int y = 0; y < columns; y++) {
				header.append("\t" + matrix[x][y]);
				//header = header + "\t" + matrix[x][y];
			}
			System.out.println(header);
		}
	}

	public int getIndex(String letter){
		int indice=-1;
		
		letter = letter.toUpperCase();
		
		for(int i=0;i<cabecColumns.length;i++){
			
			if (letter.equals(cabecColumns[i]))
				indice=i;
		}
		return indice;
	}

}