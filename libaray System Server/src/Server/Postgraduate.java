package Server;

import java.rmi.RemoteException;

import ServeInterface.PostGInterface;

public class Postgraduate extends Student implements PostGInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Postgraduate(String na, String pn, String pw, boolean b) throws RemoteException{
		name=na;
		papersNumber=pn;
		password=pw;
		privilege=b;
		status="�о���";
	}

	public Postgraduate() throws RemoteException{
		status="�о���";
	}

	
}
