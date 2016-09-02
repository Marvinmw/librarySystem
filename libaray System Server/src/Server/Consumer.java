package Server;
/**
 * Teacher,Student的父类
 * person的子类
 * 数据域
 * 人名name,证件号papersNumber，已借的书用myBookList保存
 * 权限privilege
 * 
 * */
import java.rmi.RemoteException;
import java.util.*;

import ServeInterface.ConsumerInterface;

public class Consumer extends Person implements ConsumerInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Consumer() throws RemoteException {
		status="用户";
		}

	boolean privilege;
	ArrayList<Book>   myBookList=new ArrayList<Book>();
	//根据搜索作者名搜索书
     public  ArrayList<Book>  searchByAuthor(String author) throws RemoteException {
      return	 LibrarySystem.searchBookByAurhor(author);
     }
    //根据书名搜索
     public  ArrayList<Book>  searchByBookName(String bookName) throws RemoteException {
    	 return LibrarySystem.searchBookByBookName(bookName);
     }
     //还书
     public boolean returnBook(Book book) throws RemoteException {
    	 myBookList.remove(book);
    	 return LibrarySystem.returnBook(book);
     }
     //续借
     public boolean renewBook(Book book)throws RemoteException {
    	 return LibrarySystem.renewBook(book);
     }
     //借书，student的子类需要覆盖，检查借阅权限
     public boolean borrowBook(Book book)throws RemoteException {
    	if(book.getCanBorrow()){
    		if(book.getIsRare())
    		  if(!this.getPrivilege()){
    			  System.out.println("You have no right for the book.");
    			  return false;
    		  }
    		  book.creatBorrowDate();
    		  book.setBorrower(this);
    		  book.setCanBorrow();
    		  return  myBookList.add(book);
    		}
    	else
		 return false;	
    }			
    		
    
    public boolean getPrivilege() throws RemoteException {
		return privilege;
	}
		
		//返回所借的书列表
     	 public ArrayList getBorrowedBookList()throws RemoteException {
     		 return  myBookList;
     }
    //遍历书籍，到期图书提醒
         public String update()throws RemoteException {
        	 String output="";
        	 Calendar  currentTime=Calendar.getInstance();
        	 if(myBookList.isEmpty()){
        		 output="You do not borrow a book.";
        	 }	 
        	
        	 for(int i=0;i<myBookList.size();i++){
        		if(currentTime.after(myBookList.get(i).getRetrunDate()))
        			output+=myBookList.get(i).remind();
        	 }
        	 return output;
         }
         //设置名字
		public void setName(String newName) throws RemoteException {
			name=newName;
		}
		//设置借书权限
		public void setIsPrivilege() throws RemoteException {
			if(!privilege)
				privilege=true;
			else
				privilege=false;
		}
		//设置证件号
		public void setConsumerPapersNumber(String newpapersword) throws RemoteException {
			papersNumber=newpapersword;
		}	
			
		public void showMybookList()throws RemoteException {
			if(myBookList.isEmpty())
				System.out.println("Your book shelf is blank.");
			else
			for(int i=0;i<myBookList.size();i++)
				System.out.println(myBookList.get(i).getCompleteInformation());
		return;
		}
    		
		public String toString(){
			return "User :"+name+"\n"+"papers number:"+papersNumber+"\nprivilege :"+privilege;
			  
		  }
	
		
}
