package ServeInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Server.Person;

public interface SystemInterface extends Remote{
	 Person check(String papersNumber, String passWord) throws RemoteException;
}
