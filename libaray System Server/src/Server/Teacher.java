package Server;

import java.rmi.RemoteException;

import ServeInterface.TeacherInterface;


public class Teacher extends Consumer implements TeacherInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Teacher(String na, String pn,  String pw, boolean b) throws RemoteException {
		name = na;
		papersNumber = pn;
		password = pw;
		privilege = b;
		status="老师";
	}



	public Teacher() throws RemoteException{
		status="本科生";
	}



	public boolean sendMessageToStudent(Book book) throws RemoteException {
		Consumer borrower = book.getBorrower();
		if (borrower instanceof Student) {
			((Student) borrower).getMessageFromTeacher(book);
			return true;
		} else
			return false;
	}
  
}
