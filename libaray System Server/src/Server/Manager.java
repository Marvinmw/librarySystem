package Server;
/**
 * ����Ա��
 * */

import java.rmi.RemoteException;
import java.util.*;

import ServeInterface.BookInterface;
import ServeInterface.ConsumerInterface;
import ServeInterface.ManagerInterface;

public class Manager extends Person implements ManagerInterface{
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Manager(String na,String pn,String pw) throws RemoteException{
	  name=na;
	  papersNumber=pn;
	  password=pw;
	  status="����Ա";
  }

  public Manager() throws RemoteException {
	  status="����Ա";
}

//��������
  public ArrayList<Book>  searchByBookName(String bookName)throws RemoteException {
	  return LibrarySystem.searchBookByBookName(bookName);
  }
  public ArrayList<Book>  searchByAuthor(String author)throws RemoteException {
	  return LibrarySystem.searchBookByAurhor(author);
  }
  //�����û�
  public Consumer searchConsumerByPaper(String papersnumber)throws RemoteException {
	  return  LibrarySystem.searchConsumerByPapersnumber(papersnumber);
  }
  public ArrayList<Person> searchConsumerByName(String name)throws RemoteException{
	  return  LibrarySystem.searchConsumerByName(name);
  }
  //�����������
  public void setBookInformation(BookInterface book)throws RemoteException {
	  book.changeIsRare();
  }
  //���ø��û�����
 public void setConsumerName(ConsumerInterface consumer,String newName)throws RemoteException {
	 consumer.setName(newName);
 }
 //���ø��û�����Ȩ��
 public void setConsumerRightRareBook(ConsumerInterface consumer)throws RemoteException {
	 consumer.setIsPrivilege();
 }
 //�Ƴ��û�
 public  boolean removeConsumer(ConsumerInterface consumer)throws RemoteException {
	 if(!((Consumer)consumer).myBookList.isEmpty())
	   return false;
	 return LibrarySystem.removeConsumer((Consumer)consumer);
 } 
 //�����û�
 public boolean addPerson(String name, String papersNumber, String password,int type) throws RemoteException  {
	 if(type==1)
	return	 LibrarySystem.addPerson(new Teacher(name,papersNumber,password,true));
	 if(type==2)
	return	 LibrarySystem.addPerson(new Undergraduate(name,papersNumber,password,false));
	 if(type==3)
	return	 LibrarySystem.addPerson(new Postgraduate(name,papersNumber,password,true));
	 if(type==4)
		 return LibrarySystem.addPerson(new Manager(name,papersNumber,password));
	return false;
 }
  //ɾ������
 public void removeBook(BookInterface book)throws RemoteException {
	 
	 LibrarySystem.removeBook((Book)book);
 }
//���Ӹ���
 public boolean addBook(BookInterface book)throws RemoteException {
	return LibrarySystem.addBook((Book)book);
 }
public void setConsumerPapersNumber(ConsumerInterface consumer, String newpapersword) throws RemoteException {
	((Consumer)consumer).setConsumerPapersNumber(newpapersword);
	
}


}



