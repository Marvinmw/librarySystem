package Server;

import java.rmi.RemoteException;

import ServeInterface.StudentInterface;


public class Student extends Consumer implements StudentInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Student() throws RemoteException {
		status="Ñ§Éú";
		}

	String  messageFromTeacher="";
    public void  getMessageFromTeacher(Book book)throws RemoteException {
    	messageFromTeacher+="Book name:"+book.getName()+". You should  retrun for a teacher.";
    }
    	
    public String update()throws RemoteException {
    	String output=super.update();
    	output+=messageFromTeacher;
    	 messageFromTeacher="";
		return output;
    }
		
    
    
}
