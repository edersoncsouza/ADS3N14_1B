import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class EleicaoServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			java.rmi.registry.LocateRegistry.createRegistry(1099);  
			
			EleicaoImpl servicoHello = new EleicaoImpl();
			
			Naming.rebind("Eleicao", servicoHello);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
