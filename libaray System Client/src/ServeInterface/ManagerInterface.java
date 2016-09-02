package ServeInterface;

import java.rmi.RemoteException;

import java.util.ArrayList;




public interface ManagerInterface extends PersonInterface{
	ArrayList<? extends BookInterface>  searchByBookName(String bookName) throws RemoteException;
	ArrayList<? extends BookInterface>  searchByAuthor(String author)throws RemoteException;
	ConsumerInterface searchConsumerByPaper(String papersnumber) throws RemoteException;
	void setBookInformation(BookInterface book) throws RemoteException;
	void setConsumerName(ConsumerInterface consumer,String newName) throws RemoteException;
	void setConsumerRightRareBook(ConsumerInterface consumer) throws RemoteException;
	boolean removeConsumer(ConsumerInterface consumer) throws RemoteException;
	 boolean addPerson(String name, String papersNumber, String password,int type) throws RemoteException;
	void removeBook(BookInterface book) throws RemoteException;
	boolean addBook(BookInterface book) throws RemoteException;
	void setConsumerPapersNumber(ConsumerInterface consumer, String newpapersword) throws RemoteException;
	ArrayList<? extends PersonInterface> searchConsumerByName(String searchKey)throws RemoteException;
}	

