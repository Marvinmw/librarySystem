package ServeInterface;

import java.rmi.RemoteException;

import java.util.ArrayList;


public interface ConsumerInterface extends PersonInterface{
	ArrayList<BookInterface>  searchByAuthor(String author) throws RemoteException;
	ArrayList<BookInterface>  searchByBookName(String bookName) throws RemoteException;
	boolean returnBook(BookInterface book) throws RemoteException;
	 boolean renewBook(BookInterface book) throws RemoteException;
	 boolean borrowBook(BookInterface book) throws RemoteException;
	 boolean getPrivilege() throws RemoteException;
	 String update() throws RemoteException;
	 void setName(String newName) throws RemoteException;
	 void setIsPrivilege() throws RemoteException;
	 void setConsumerPapersNumber(String newpapersword) throws RemoteException;
	 void showMybookList() throws RemoteException;
	String getName()throws RemoteException;
	String getStatus()throws RemoteException;
	
}
