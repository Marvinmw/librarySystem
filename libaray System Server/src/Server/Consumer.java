package Server;
/**
 * Teacher,Student�ĸ���
 * person������
 * ������
 * ����name,֤����papersNumber���ѽ������myBookList����
 * Ȩ��privilege
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
		status="�û�";
		}

	boolean privilege;
	ArrayList<Book>   myBookList=new ArrayList<Book>();
	//��������������������
     public  ArrayList<Book>  searchByAuthor(String author) throws RemoteException {
      return	 LibrarySystem.searchBookByAurhor(author);
     }
    //������������
     public  ArrayList<Book>  searchByBookName(String bookName) throws RemoteException {
    	 return LibrarySystem.searchBookByBookName(bookName);
     }
     //����
     public boolean returnBook(Book book) throws RemoteException {
    	 myBookList.remove(book);
    	 return LibrarySystem.returnBook(book);
     }
     //����
     public boolean renewBook(Book book)throws RemoteException {
    	 return LibrarySystem.renewBook(book);
     }
     //���飬student��������Ҫ���ǣ�������Ȩ��
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
		
		//������������б�
     	 public ArrayList getBorrowedBookList()throws RemoteException {
     		 return  myBookList;
     }
    //�����鼮������ͼ������
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
         //��������
		public void setName(String newName) throws RemoteException {
			name=newName;
		}
		//���ý���Ȩ��
		public void setIsPrivilege() throws RemoteException {
			if(!privilege)
				privilege=true;
			else
				privilege=false;
		}
		//����֤����
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
