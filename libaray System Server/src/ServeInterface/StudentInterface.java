package ServeInterface;

import java.rmi.RemoteException;

import Server.Book;



public interface StudentInterface extends ConsumerInterface{
	void  getMessageFromTeacher(Book book) throws RemoteException;
	String update() throws RemoteException;
	}
