package mvc.view;

import static java.lang.System.out;

import java.util.Scanner;

	public class ConsoleView {

		private Scanner teclado = new Scanner(System.in);
		
		public String[] cabecColumns = { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J" };
		
		
		public void cabecalhoColunas(int colunas){
			String cabecalho = " ";
			for(int i=0;i<colunas;i++){
				cabecalho = cabecalho + "\t" + cabecColumns[i];
			}
			System.out.println(cabecalho);
		}
		
		public void cabecalhoLinhas(int linhas, int colunas){
			
			for(int j=0;j<linhas;j++){
			
				String cabecalho = Integer.toString(j);//acrescenta o numero da linha a string antes dos pontos
				
				for(int i=0;i<colunas;i++){
					cabecalho = cabecalho + "\t" + ".";
				}
			System.out.println(cabecalho);
			
			}
		}
		
		public void printMatrix(String[][] matrix, int rows, int columns){
			
			for(int x=0;x<rows;x++){
				
				String header = Integer.toString(x);//acrescenta o numero da linha a string antes dos pontos
				
				for(int y=0;y<columns;y++){
					header = header + "\t" + matrix[x][y];
				}
			System.out.println(header);
			
			}
			
		}
		
		public void message(String message) {
			out.println(message);
		}

		public String read(String prompt) {
			out.print(prompt+": ");
			return teclado .nextLine();
		}

		public void logError(String message) {
			message("Error: " + message);
		}

}