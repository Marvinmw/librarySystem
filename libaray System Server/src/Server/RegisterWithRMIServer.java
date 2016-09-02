package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ServeInterface.BookInterface;
import ServeInterface.ConsumerInterface;
import ServeInterface.ManagerInterface;
import ServeInterface.PersonInterface;
import ServeInterface.PostGInterface;
import ServeInterface.StudentInterface;
import ServeInterface.SystemInterface;
import ServeInterface.TeacherInterface;
import ServeInterface.UnderGInterface;

public class RegisterWithRMIServer {

	/**×¢²á£Ò£Í£É
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BookInterface  book=new Book();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Book", book);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			ConsumerInterface consumer=new Consumer();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Consumer", consumer);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			SystemInterface  systemlb=new LibrarySystem();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("LibrarySystem", systemlb);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			ManagerInterface  manager=new Manager();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Manager", manager);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			PersonInterface  person=new Person();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Person",person);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			PostGInterface  postp=new Postgraduate();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Postgraduate",postp);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			UnderGInterface  underp=new Undergraduate();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("Undergraduate",underp);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			TeacherInterface  teacher= new Teacher();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("TeacherInterface",teacher);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			StudentInterface  student=new Student();
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind("StudentInterface",student);
		}	catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	}

