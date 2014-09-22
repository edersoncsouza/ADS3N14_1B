import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class EleicaoClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			Eleicao stub = (Eleicao) Naming.lookup("rmi://localhost:1099/Eleicao");
			
			ArrayList<Candidato> listaCandidatos =stub.getResultado();
			
			String resultado = "";
			for(Candidato c: listaCandidatos)
				resultado+=c.toString()+"\n";
			
			JOptionPane.showMessageDialog(null,resultado);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

}
