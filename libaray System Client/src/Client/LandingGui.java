package Client;
import javax.swing.*;

import ServeInterface.*;
import java.awt.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LandingGui extends JApplet{
	//private static ImageIcon icon;//=new ImageIcon("bin/图片2/picture2.jpg");
	//private static Image image;//=icon.getImage();
    private String host=" ";
	private static LandingPanel lp=new LandingPanel();
	private boolean isStandaLone=false;
	private BookInterface  book;
	private ConsumerInterface  consumer;
	private ManagerInterface   manager;
	private PersonInterface    person;
	private PostGInterface  postG;
	private StudentInterface  student;
	private TeacherInterface  tercher;
	private UnderGInterface   underG;
   private SystemInterface  system;
    public void init(){
    	//initializeRMI();
	 //setIconImage(image);
	 //setTitle("欢迎来到大众书馆")
	 //setLayout(new BorderLayout());
	add(lp,BorderLayout.CENTER);
	//add(new JLabel(new ImageIcon("bin/图片1/picture2.jpg")),BorderLayout.SOUTH);
	 
	 //setSize(500,500);
	 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //setVisible(true);
 }	
 protected boolean initializeRMI(String s){
	 host=s;
	// if(!isStandaLone)  host=getCodeBase().getHost();
	 try{
		 Registry registry=LocateRegistry.getRegistry(host);
		 book=(BookInterface)
		 registry.lookup("Book");
		 consumer=(ConsumerInterface)
		 registry.lookup("Consumer");
		 manager=(ManagerInterface)
		 registry.lookup("Manager");
		 person=(PersonInterface)
		 registry.lookup("Person");
		 postG=(PostGInterface)
		 registry.lookup("Postgraduate");
		 student=(StudentInterface)
		 registry.lookup("Student");
		 tercher=(TeacherInterface)
		 registry.lookup("Teacher");
		 underG=(UnderGInterface)
		 registry.lookup("Undergraduate");
		 return true;
		 }catch(Exception ex){
			 JOptionPane.showMessageDialog(
		    			null, "连接失败","警告",JOptionPane.WARNING_MESSAGE);
			 return false;
	 }
 }	
	

public  static void main(String args[]){
        LandingGui  l=new LandingGui();
        JFrame   frame=new JFrame();
        l.isStandaLone=true;
     
        l.init();
       // l.start();
        frame.setLayout(new BorderLayout());
        frame.add(l,BorderLayout.CENTER);
        //frame.setIconImage(image);
        //frame.add(lp,BorderLayout.SOUTH);
        frame.setTitle("欢迎来到大众书馆");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        lp.setLandingGui(l);
 }      
        
 


}
