/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author lhries
 */
public class EleicaoImpl extends UnicastRemoteObject implements Eleicao{

    private ArrayList<Candidato> candidatos;
    public EleicaoImpl() throws RemoteException
    {
        super();
        candidatos = new ArrayList<>();
        candidatos.add(new Candidato("Tiririca"));
        candidatos.add(new Candidato("Paulo Maluf"));
        candidatos.add(new Candidato("Mulher Fruta"));
        candidatos.add(new Candidato("Ex BBB"));
    }
	@Override
	public void votar(String nome) throws RemoteException {
		for (Candidato c:candidatos) 
			if(c.getNome().equalsIgnoreCase(nome))
				c.adicionarVoto();
	}
	
	@Override
	public ArrayList<String> getCandidatos() throws RemoteException {
		ArrayList<String> listaNomes = new ArrayList<>();
		for(Candidato c:candidatos)
			listaNomes.add(c.getNome());
		return(listaNomes);
	}
	
	@Override
	public ArrayList<Candidato> getResultado() throws RemoteException {
		Collections.sort(candidatos,new Comparator<Candidato>() {

			@Override
			public int compare(Candidato arg0, Candidato arg1) {
				return(arg1.getVotos()-arg0.getVotos());
			}
			
		});
		return candidatos;
	}


    

}
