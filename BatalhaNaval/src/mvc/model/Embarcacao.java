package mvc.model;

abstract class Embarcacao {
		
	private int tamanho, dano;
	private int[] posicaoPopa;
	private String orientacao; //v=vertical, h=horizontal
	
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public int[] getPosicaoPopa() {
		return posicaoPopa;
	}
	public void setPosicaoPopa(int x, int y) {
		posicaoPopa = new int[2];
		
		this.posicaoPopa[0] = x;
		this.posicaoPopa[1] = y;
	}
	public String getOrientacao() {
		return orientacao;
	}
	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}	
}
