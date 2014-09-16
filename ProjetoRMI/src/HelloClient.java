import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class HelloClient {

	public static void main(String[] args) {
		String host = "localhost"; // altere aqui, caso execute em outra maquina
		try{
			// obtem uma referencia para o registro do RMI
			Registry registry = LocateRegistry.getRegistry(host);
			
			// obtem a stub do servidor
			Hello stub = (Hello) registry.lookup("Hello");
			
			// chama os metodos  do servidor  e imprime a mensagem
			String name = JOptionPane.showInputDialog("Nome: ");
			if (name.length() >2)
				stub.setName(name);
			String msg = stub.hello();
			
			System.out.println("Mensagem do servidor: " + msg);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
