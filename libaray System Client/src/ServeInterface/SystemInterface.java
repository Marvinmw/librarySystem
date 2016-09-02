package ServeInterface;

import java.rmi.Remote;

import java.rmi.RemoteException;



public interface SystemInterface extends Remote{
	 PersonInterface check(String papersNumber, String passWord) throws RemoteException;
}
