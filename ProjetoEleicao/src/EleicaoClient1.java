import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class EleicaoClient1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			
			Eleicao stub = (Eleicao) Naming.lookup("rmi://localhost:1099/Eleicao");
			
			ArrayList<String> listaCandidatos =stub.getCandidatos(); 
			
			String candidatos = "";
			for(String c: listaCandidatos)
				candidatos+=c+"\n";
			String nome = JOptionPane.showInputDialog(candidatos+"Nome: ");			

			stub.votar(nome);
			
			JOptionPane.showMessageDialog(null, "Voto computado com sucesso!");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
