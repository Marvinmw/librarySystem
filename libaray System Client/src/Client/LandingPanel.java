package Client;
import java.awt.*;


import javax.swing.*;
import javax.swing.border.Border;

import ServeInterface.*;


import java.awt.event.*;
import java.rmi.RemoteException;
/**
 * ��½ģ�����
 * �û������û���������
 * */
public class LandingPanel extends JPanel{
	 private SystemInterface  system;
	 private PersonInterface    person;
  private JPasswordField jpf=new JPasswordField(10);
  private JTextField jtf=new JTextField(10);
  private JTextField jtf1=new JTextField(10);
  private JLabel jl3=new JLabel("����������");
  private JLabel   jl1=new JLabel("�û���");
  private JLabel  jl2=new JLabel("����");
  private JPanel  jp1=new JPanel();
  //private JPanel  jp2=new drawImage();
  private JButton jb1=new JButton("��½");
  private JButton jb2=new JButton("�˳�");
  //private JButton jb3=new JButton("ע��");
  //private JButton jb4=new JButton("����");
  private JPanel jp3=new JPanel();
  private JPanel jp4=new JPanel(new GridLayout(0,1));
 // private JPanel jp5=new JPanel();
  private LandingGui land=new LandingGui ();
  //��ʼ��ģ��
 LandingPanel(){
	 setLayout(new BorderLayout());
	 jp1.setLayout(new GridLayout(3,0,0,2));
	 jp1.add(jl1);
	 jp1.add(jtf);
	 jp1.add(jl2);
	 jp1.add(jpf);
	 jp3.add(jb1);
	 //jp3.add(jb3);
	 jp3.add(jb2);
	 //jp3.add(jb4);
	 jp1.add(jl3);
	 jp1.add(jtf1);
	jp4.add(jp1);
	 //jp4.add(jp5);
	  jp4.add(jp3);
	add(jp4,BorderLayout.CENTER);
	//add(jp2,BorderLayout.CENTER);
	setBorder(BorderFactory.createRaisedBevelBorder());
	//��½ע��
	jb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//System.out.print(getHostName().equals(""));
	if(!checkData())
	    	JOptionPane.showMessageDialog(
	    			null, "�û��������벻��Ϊ��","����",JOptionPane.WARNING_MESSAGE);
	   
	   else if(!LinkServer()){
		   JOptionPane.showMessageDialog(
				   null, "�޷���������","����",JOptionPane.WARNING_MESSAGE);
		   jtf1.setText(null);
	   }
		else
			try {
				land.initializeRMI(getHostName());
				person=system.check(getPaperNumber(), getPassword());
			    if(person instanceof ConsumerInterface){
				JOptionPane.showMessageDialog(null, "��½�ɹ�","�ɹ�",JOptionPane.OK_OPTION);
				UserGui  user=new UserGui((ConsumerInterface)person);
				user.init();
				user.start(user);
				land.setVisible(false);
			    }
			    else{
			     JOptionPane.showMessageDialog(null, "��½�ɹ�","�ɹ�",JOptionPane.OK_OPTION);
			     ManagerGui manager=new ManagerGui((ManagerInterface)person);
			     manager.init();
			     manager.start(manager);
			     land.setVisible(false);
			    }
			    	
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}
	});	
				
				
					
			
//�˳�
   jb2.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}
	});
 }			
		
	
   //ע��
  // jb3.addActionListener(new ActionListener(){
	//   public void actionPerformed(ActionEvent e){
		   
	  // }
   //});
    //}
 //��������
 protected boolean LinkServer() {
	if(getHostName().equals(""))
	return false;
	else
	return	land.initializeRMI(getHostName());
}
protected  boolean checkData() {
	return ((!getPaperNumber().equals(""))&&(!getPassword().equals("")))?true:false;
	}
	

//��ȡ֤����
 public String getPaperNumber(){
	  String  s=jtf.getText().trim();
	  s=s.replaceAll("\\s+", " ");
	  jtf.setText(null);
	  return s;
  } 
 //��ȡ����
 public String getPassword(){
	char[] ch=jpf.getPassword();
	String s=ch.toString();
	
	return s;
 }
//��ȡ��½���������
    public void setLandingGui(LandingGui l){
    	land=l;
    }
//��ȡ������
    public String getHostName(){
    	String s=jtf1.getText().trim();
    	return s;
    }
	
/* public static  void main(String args[]){
	JFrame j=new JFrame();
	j.add(new LandingPanel());
	j.setBackground(Color.blue);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setSize(300,300);
	j.setVisible(true);*/
	
 }		
	

 


