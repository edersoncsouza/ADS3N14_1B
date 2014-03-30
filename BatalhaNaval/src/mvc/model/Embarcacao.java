package mvc.model;

public class Embarcacao {
	
	private String[] tipo = {"Porta-Avioes","Destroyer","Fragata","Torpedeiro","Submarino"};
	private String tipoEmbarc;
	private int[] tamanho = {5,4,3,2,1};
	private int[] posicaoPopa;
	private String orientacao; //v=vertical, h=horizontal
	
	public String getTipoEmbarc() {
		return tipoEmbarc;
	}
	public void setTipoEmbarc(int indiceTipo) {
		tipoEmbarc = tipo[indiceTipo];
	}
	
	public int getTamanho(String tipoEmbarc){
		int tamanhoEmbarc=0;
		
		for(int i=0;i<tipo.length;i++){
			if(tipo[i].equals(tipoEmbarc)){
				tamanhoEmbarc = tamanho[i];
				return tamanhoEmbarc;
			}		
		}
		return tamanhoEmbarc;
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

	
	
	
}
