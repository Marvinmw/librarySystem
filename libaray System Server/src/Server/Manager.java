package Server;
/**
 * 管理员类
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
	  status="管理员";
  }

  public Manager() throws RemoteException {
	  status="管理员";
}

//搜索书名
  public ArrayList<Book>  searchByBookName(String bookName)throws RemoteException {
	  return LibrarySystem.searchBookByBookName(bookName);
  }
  public ArrayList<Book>  searchByAuthor(String author)throws RemoteException {
	  return LibrarySystem.searchBookByAurhor(author);
  }
  //搜所用户
  public Consumer searchConsumerByPaper(String papersnumber)throws RemoteException {
	  return  LibrarySystem.searchConsumerByPapersnumber(papersnumber);
  }
  public ArrayList<Person> searchConsumerByName(String name)throws RemoteException{
	  return  LibrarySystem.searchConsumerByName(name);
  }
  //设置书的种类
  public void setBookInformation(BookInterface book)throws RemoteException {
	  book.changeIsRare();
  }
  //设置该用户名字
 public void setConsumerName(ConsumerInterface consumer,String newName)throws RemoteException {
	 consumer.setName(newName);
 }
 //设置该用户结束权限
 public void setConsumerRightRareBook(ConsumerInterface consumer)throws RemoteException {
	 consumer.setIsPrivilege();
 }
 //移除用户
 public  boolean removeConsumer(ConsumerInterface consumer)throws RemoteException {
	 if(!((Consumer)consumer).myBookList.isEmpty())
	   return false;
	 return LibrarySystem.removeConsumer((Consumer)consumer);
 } 
 //增加用户
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
  //删除该书
 public void removeBook(BookInterface book)throws RemoteException {
	 
	 LibrarySystem.removeBook((Book)book);
 }
//增加该书
 public boolean addBook(BookInterface book)throws RemoteException {
	return LibrarySystem.addBook((Book)book);
 }
public void setConsumerPapersNumber(ConsumerInterface consumer, String newpapersword) throws RemoteException {
	((Consumer)consumer).setConsumerPapersNumber(newpapersword);
	
}


}



