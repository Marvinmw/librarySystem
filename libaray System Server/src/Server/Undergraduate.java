package Server;

import java.rmi.RemoteException;

import ServeInterface.UnderGInterface;

public class Undergraduate extends Student implements UnderGInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Undergraduate(String na,  String pn,  String pw, boolean b) throws RemoteException{
		name=na;
		papersNumber=pn;
		password=pw;
		privilege=b;
		status="本科生";
	}

	public Undergraduate() throws RemoteException{
		status="本科生";
	}
	 

}
