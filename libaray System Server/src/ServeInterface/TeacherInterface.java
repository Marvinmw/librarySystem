package ServeInterface;

import java.rmi.RemoteException;

import Server.Book;


public interface TeacherInterface extends ConsumerInterface{
	boolean sendMessageToStudent(Book book) throws RemoteException;
}
