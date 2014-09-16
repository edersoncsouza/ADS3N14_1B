import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello{
	private String name;
	protected HelloImpl() throws RemoteException{
		super();
		name="world";
	}
	
	
	@Override
	public String hello() throws RemoteException {
		return "Hello "+ name;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name;
		System.out.println("Nome renomeado para "+ name);
		
	}
	
	
}
