package mvc.model;

public class Tabuleiro {

	private int rows;
	private int columns;
	private String xy;
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setJogada(String xy){
		this.xy = xy;
	}
	public String getJogada(){
		return xy;
	}
}
