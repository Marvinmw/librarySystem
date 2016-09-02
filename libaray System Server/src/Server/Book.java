package Server;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import ServeInterface.BookInterface;



/**
 * ����������name������author��������consumer�����״̬canBorrow�����isRare
 * �������borrowDate���黹����returnDate ��getter��setter
 * 
 * */

public class Book extends UnicastRemoteObject implements  Serializable,BookInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String name;
	private String author;
	private Consumer borrower;
	private boolean canBorrow;
	private boolean isRare;
	private Calendar borrowDate;
	private Calendar returnDate;
  public Book()throws RemoteException{
	  
	}
 
	public Book(String na, String au, boolean type) throws RemoteException {
		name = na;
		author = au;
		isRare = type;
		canBorrow = true;
	}

	public Calendar getRetrunDate() throws RemoteException {
		return returnDate;
	}

	public String getName() throws RemoteException {
		return this.name;
	}

	public void setName(String newName) throws RemoteException {
		name = newName;
	}

	public String getAuthor() throws RemoteException {
		return this.author;
	}

	public void setAuthor(String newAuthor) throws RemoteException {
		author = newAuthor;
	}

	public Consumer getBorrower() throws RemoteException {
		return borrower;
	}

	public boolean getIsRare() throws RemoteException {
		return isRare;
	}

	// �ı��������
	public void changeIsRare() throws RemoteException {
		if (!isRare)
			isRare = true;
		else
			isRare = false;
	}

	// ������Ľ���״̬
	public Calendar getBorrowDate() throws RemoteException {
		return borrowDate;
	}

	// �������ļ��黹ʱ��
	public void creatBorrowDate() throws RemoteException {
		borrowDate = Calendar.getInstance();
		returnDate= Calendar.getInstance();
		returnDate.add(borrowDate .DATE, 30);
	}

	// ���ٽ��ļ��黹ʱ��
	public void destroyDate() throws RemoteException {
		borrowDate = null;
		returnDate = null;
	}

	// ���ý�����
	public boolean setBorrower(Consumer consumer) throws RemoteException {
		borrower = consumer;
		return true;
	}

	// ���ٽ�����
	public boolean destroyBorrower() throws RemoteException {
		this.borrower = null;
		return true;
	}

	// �����Ƿ�ɽ�
	public boolean setCanBorrow() throws RemoteException {
		if (!canBorrow)
			canBorrow = true;
		else
			canBorrow = false;
		return true;

	}

	// �ӳ��黹ʱ��
	public boolean delayReturnDate() throws RemoteException {
		if (count < 1) {
			count++;
			returnDate.add(returnDate.DATE, 30);
			return true;
		} else
			return false;
	}

	// ���ɸ������Ϣ
	public String toString() {
		String bookInformation = "Name :" + name + "\n" + "Author :" + author
				+ "\n";
		if (canBorrow) {
			bookInformation += "\nThe book can be borrowed.";
		} else
			bookInformation += "\nThe book has been borrowed.";
		if (isRare)
			bookInformation += "\nThe book is rare.";
		else
			bookInformation += "\nThe book is common.";

		return bookInformation;
	}

	// ������Ľ����ߵ���Ϣ
	public String getInformationConsumer() throws RemoteException {
		if (borrower != null)
			return borrower.toString();
		return null;
	}

	public boolean getCanBorrow() throws RemoteException {
		return canBorrow;
	}

	
	public String remind() throws RemoteException {
		String reminding = "";
		reminding += "Name :" + name + "\n" + "Author :" + author + "\n";
		reminding += "Borrow date: " + borrowDate.getTime() + "-----"
				+ returnDate.getTime();
		reminding += "\n" + "You should retrun the book.\n";
		return reminding;
	}

	// ��ȡ�����������Ϣ
	public String getCompleteInformation() throws RemoteException {
		return "Name :" + name + "\n" + "Author :" + author + "\n"
				+ "\nBorrow date: " + borrowDate.getTime() + "-----"
				+ returnDate.getTime() + "\n" + this.getCanBorrow();
	}
}
