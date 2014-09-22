import java.io.Serializable;


public class Candidato implements Serializable {
	private String nome;
	private int votos;
	public Candidato(String nome) {
		super();
		this.nome = nome;
		this.votos = 0;
	}
	
	public void adicionarVoto()
	{
		votos++;
	}
	
	

	public String getNome() {
		return nome;
	}

	public int getVotos() {
		return votos;
	}

	@Override
	public String toString() {
		return "Candidato " + nome + ": " + votos;
	}
	
	
}
