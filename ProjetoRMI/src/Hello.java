import java.rmi.*;

public interface Hello extends Remote{

	public String hello() throws RemoteException;
	public void setName(String name) throws RemoteException;
	
}
