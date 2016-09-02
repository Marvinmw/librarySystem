package ServeInterface;

import java.rmi.RemoteException;


public interface StudentInterface extends ConsumerInterface{
	void  getMessageFromTeacher(BookInterface book) throws RemoteException;
	String update() throws RemoteException;
	}
