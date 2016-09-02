package ServeInterface;
import java.rmi.*;

import java.util.Calendar;



public interface BookInterface extends Remote{
	Calendar getRetrunDate() throws RemoteException;
	 String getName() throws RemoteException;
	 void setName(String newName) throws RemoteException;
	 String getAuthor() throws RemoteException;
	 void setAuthor(String newAuthor) throws RemoteException;
	 ConsumerInterface getBorrower() throws RemoteException;
	 boolean getIsRare() throws RemoteException;
	 void changeIsRare() throws RemoteException;
	 Calendar getBorrowDate() throws RemoteException;
	 void creatBorrowDate() throws RemoteException;
	 void destroyDate() throws RemoteException;
	 boolean setBorrower(ConsumerInterface consumer) throws RemoteException;
	 boolean destroyBorrower() throws RemoteException;
	 boolean setCanBorrow() throws RemoteException;
	 boolean delayReturnDate() throws RemoteException;
     String getInformationConsumer() throws RemoteException;
	 boolean getCanBorrow() throws RemoteException;
	 String remind() throws RemoteException;
	 String getCompleteInformation()  throws RemoteException;
}
