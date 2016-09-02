package Server;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ServeInterface.PersonInterface;





public class Person extends UnicastRemoteObject implements  Serializable,PersonInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String status="»À";
	public Person() throws RemoteException {
		
		}
	protected String name;
	protected String  papersNumber;
	protected String password;
public String	getPapersNumer()throws RemoteException {
		return  papersNumber;
	}
public String	getPassWord()throws RemoteException {
	return  password;
}
public String getName() throws RemoteException {
	
	return name;
}

public String getStatus() throws RemoteException {
	
	return status;
}


}
