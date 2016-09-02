package Server;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import ServeInterface.BookInterface;



/**
 * 书类有书名name，作者author，借阅人consumer，借出状态canBorrow，类别isRare
 * 借出日期borrowDate，归还日期returnDate 有getter和setter
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

	// 改变书的种类
	public void changeIsRare() throws RemoteException {
		if (!isRare)
			isRare = true;
		else
			isRare = false;
	}

	// 返回书的借阅状态
	public Calendar getBorrowDate() throws RemoteException {
		return borrowDate;
	}

	// 创建借阅及归还时间
	public void creatBorrowDate() throws RemoteException {
		borrowDate = Calendar.getInstance();
		returnDate= Calendar.getInstance();
		returnDate.add(borrowDate .DATE, 30);
	}

	// 销毁借阅及归还时间
	public void destroyDate() throws RemoteException {
		borrowDate = null;
		returnDate = null;
	}

	// 设置借阅人
	public boolean setBorrower(Consumer consumer) throws RemoteException {
		borrower = consumer;
		return true;
	}

	// 销毁借阅人
	public boolean destroyBorrower() throws RemoteException {
		this.borrower = null;
		return true;
	}

	// 设置是否可借
	public boolean setCanBorrow() throws RemoteException {
		if (!canBorrow)
			canBorrow = true;
		else
			canBorrow = false;
		return true;

	}

	// 延长归还时间
	public boolean delayReturnDate() throws RemoteException {
		if (count < 1) {
			count++;
			returnDate.add(returnDate.DATE, 30);
			return true;
		} else
			return false;
	}

	// 生成该书的信息
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

	// 返回书的借阅者的信息
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

	// 获取完整的书的信息
	public String getCompleteInformation() throws RemoteException {
		return "Name :" + name + "\n" + "Author :" + author + "\n"
				+ "\nBorrow date: " + borrowDate.getTime() + "-----"
				+ returnDate.getTime() + "\n" + this.getCanBorrow();
	}
}
