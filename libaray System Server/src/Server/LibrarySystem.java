package Server;
/**图书系统

 * 保存用户，管理员，图书信息
 * 具有查询，还书，借书，续借，删除，增加，改变信息的功能
 * */
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

import ServeInterface.SystemInterface;


public class LibrarySystem  extends UnicastRemoteObject implements  Serializable,SystemInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Teacher> teacherList = new ArrayList<Teacher>(); // 教师列表
	private static ArrayList<Postgraduate> postGList = new ArrayList<Postgraduate>(); // 研究生列表
	private static ArrayList<Undergraduate> underGList = new ArrayList<Undergraduate>(); // 本科生列表
	private static ArrayList<Manager> managerList = new ArrayList<Manager>(); // 管理员列表
	private static ArrayList<Book> bookList = new ArrayList<Book>(); // 图书列表

	// 每个列表逐个检索，且列表不能为空
	public  Person check(String papersNumber, String passWord) throws RemoteException {
		if (!teacherList.isEmpty())
			for (int i = 0; i < teacherList.size(); i++)
				if ((teacherList.get(i).getPapersNumer().equals(papersNumber))
						&(teacherList.get(i).getPassWord().equals(passWord)))
					return teacherList.get(i);
		if (!underGList.isEmpty())
			for (int i = 0; i < underGList.size(); i++)
				if ((underGList.get(i).getPapersNumer().equals(papersNumber))
						&(underGList.get(i).getPassWord().equals(passWord)))
					return underGList.get(i);
		if (!postGList.isEmpty())
			for (int i = 0; i < postGList.size(); i++)
				if ((postGList.get(i).getPapersNumer().equals(papersNumber))
						& (postGList.get(i).getPassWord().equals(passWord)))
					return postGList.get(i);
		if (!managerList.isEmpty())
			for (int i = 0; i < managerList.size(); i++)
				if ((managerList.get(i).getPapersNumer().equals(papersNumber))
						&(managerList.get(i).getPassWord().equals(passWord)))
					return managerList.get(i);
		return null;
	}

	// 根据作者搜索图书
	public static  ArrayList<Book> searchBookByAurhor(String author) throws RemoteException {
		ArrayList<Book> searchBook = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if ((book.getAuthor()).equalsIgnoreCase(author))
				searchBook.add(book);
		}
		return searchBook;
	}

	// 根据书名搜索书
	public static  ArrayList<Book> searchBookByBookName(String name) throws RemoteException {
		ArrayList<Book> searchBook = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if ((book.getName()).equalsIgnoreCase(name))
				searchBook.add(book);
		}
		return searchBook;
	}

	// 还书
	public static  boolean returnBook(Book book) throws RemoteException {
		book.destroyBorrower();//检查是否销毁借阅时间
		book.setCanBorrow();
		return true;

	}

	// 续借
	public static boolean renewBook(Book book) throws RemoteException {
		if (book.delayReturnDate())
			return true;
		else
			return false;
	}

	// 根据证件号搜索用户
	public static  Consumer searchConsumerByPapersnumber(String papersNumber) throws RemoteException {
		if (!teacherList.isEmpty())
			for (int i = 0; i < teacherList.size(); i++)
				if ((teacherList.get(i).getPapersNumer().equals(papersNumber) ))
					return teacherList.get(i);
		if (!underGList.isEmpty())
			for (int i = 0; i < underGList.size(); i++)
				if ((underGList.get(i).getPapersNumer().equals(papersNumber)))
					return underGList.get(i);
		if (!postGList.isEmpty())
			for (int i = 0; i < postGList.size(); i++)
				if ((postGList.get(i).getPapersNumer().equals(papersNumber)))
					return postGList.get(i);
        
		return null;
	}
	//根据人名搜索人
	public static ArrayList<Person> searchConsumerByName(String name) throws RemoteException {
		ArrayList<Person>  personList=new ArrayList<Person>();
		if (!teacherList.isEmpty())
			for (int i = 0; i < teacherList.size(); i++)
				if ((teacherList.get(i).getName().equals(name) ))
					personList.add(teacherList.get(i));
		if (!underGList.isEmpty())
			for (int i = 0; i < underGList.size(); i++)
				if ((underGList.get(i).getName().equals(name)))
					personList.add(underGList.get(i));
		if (!postGList.isEmpty())
			for (int i = 0; i < postGList.size(); i++)
				if ((postGList.get(i).getName().equals(name)))
					personList.add(postGList.get(i));
        if(personList.isEmpty())
		return null;
        else
        	return personList;
	}
	// 删除用户
	public static  boolean removeConsumer(Consumer consumer) throws RemoteException {
		if (consumer instanceof Teacher) {
			return teacherList.remove(consumer);
}
		
		if (consumer instanceof Undergraduate) {
			return underGList.remove(consumer);

		}
		if (consumer instanceof Postgraduate) {
			return postGList.remove(consumer);

		}
		return false;
	}

	// 增加用户
	public static  boolean addPerson(Person consumer) throws RemoteException {
		if (consumer instanceof Teacher)
			return teacherList.add((Teacher) consumer);

		if (consumer instanceof Undergraduate)
			return underGList.add((Undergraduate) consumer);

		if (consumer instanceof Postgraduate)
			return postGList.add((Postgraduate) consumer);
        if(consumer instanceof Manager)
	        	return managerList.add((Manager)consumer);
			return false;

	}

	// 删除书籍
	public static  boolean removeBook(Book book) throws RemoteException {
		if (book.getCanBorrow())
			return bookList.remove(book);
		return false;

	}

	public static  boolean addBook(Book book) throws RemoteException {
		return bookList.add(book);
	}
	
	//读入数据
@SuppressWarnings("unchecked")
public LibrarySystem() throws ClassNotFoundException, FileNotFoundException, IOException {
	try{
		//System.out.println(1);
	 ObjectInputStream inputT=new ObjectInputStream(new FileInputStream("TeacherList"));
	 teacherList= (ArrayList<Teacher>) inputT.readObject();
	  }catch(Exception es){}
	 
	   try{
	   ObjectInputStream inputU=new ObjectInputStream(new FileInputStream("UndergraduateList"));
	  underGList=(ArrayList<Undergraduate>) inputU.readObject();
	   }catch(Exception es){}
	   
		   
	   
	   
	   try{
		  // System.out.println(2);
	   ObjectInputStream inputP=new ObjectInputStream(new FileInputStream("PostgraduateList"));
	   postGList=(ArrayList<Postgraduate>) inputP.readObject();
	   }catch(Exception es){}
	  
		   
	   
	   
	   try{
		   //System.out.println(3);
	   ObjectInputStream inputM=new ObjectInputStream(new FileInputStream("ManagerList"));
		 managerList=(ArrayList<Manager>) inputM.readObject();
		  }catch(Exception es){}
	    
		  
	   
	   try{
		   //System.out.println(4);
		   ObjectInputStream inputB=new ObjectInputStream(new FileInputStream("BookList"));
			  bookList=(ArrayList<Book>) inputB.readObject();
			   }catch(Exception es){ }
	  
		 //  System.out.print(managerList.get(0));
	  
	
 }
	   //重新输出数据
	public static void OverideData(){
		try{
		ObjectOutputStream outputB=new  ObjectOutputStream(new FileOutputStream("BookList",false)); 
		outputB.writeObject(bookList);
		outputB.close();
		
		ObjectOutputStream outputT=new  ObjectOutputStream(new FileOutputStream("TeacherList",false)); 
		outputT.writeObject(teacherList);
		outputT.close();	
		
		ObjectOutputStream outputP=new  ObjectOutputStream(new FileOutputStream("PostgraduateList",false)); 
		outputP.writeObject(postGList);
		outputP.close();
		
		ObjectOutputStream outputU=new  ObjectOutputStream(new FileOutputStream("UndergraduateList",false)); 
		outputU.writeObject(underGList);
		outputU.close();
		
		ObjectOutputStream outputM=new  ObjectOutputStream(new FileOutputStream("ManagerList",false)); 
		outputM.writeObject(managerList);
		outputM.close();
		}catch(Exception ed){
		}	
		
	}
}
