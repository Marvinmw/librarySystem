package ServeInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.Book;
import Server.Consumer;


public interface ConsumerInterface extends PersonInterface{
	ArrayList<Book>  searchByAuthor(String author) throws RemoteException;
	ArrayList<Book>  searchByBookName(String bookName) throws RemoteException;
	boolean returnBook(Book book) throws RemoteException;
	 boolean renewBook(Book book) throws RemoteException;
	 boolean borrowBook(Book book) throws RemoteException;
	 boolean getPrivilege() throws RemoteException;
	 String update() throws RemoteException;
	 void setName(String newName) throws RemoteException;
	 void setIsPrivilege() throws RemoteException;
	 void setConsumerPapersNumber(String newpapersword) throws RemoteException;
	 void showMybookList() throws RemoteException;
	String getName()throws RemoteException;
	String getStatus()throws RemoteException;
	
}
