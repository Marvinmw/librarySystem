package ServeInterface;
import java.rmi.*;
public interface PersonInterface extends Remote{
	String	getPapersNumer() throws RemoteException;
	String	getPassWord() throws RemoteException;
	String getName()throws RemoteException;
	String getStatus()throws RemoteException;
}	

