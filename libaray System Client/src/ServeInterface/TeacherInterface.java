package ServeInterface;

import java.rmi.RemoteException;

public interface TeacherInterface extends ConsumerInterface{
	boolean sendMessageToStudent(BookInterface book) throws RemoteException;
}
