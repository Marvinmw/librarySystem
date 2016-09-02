package Client;
import java.awt.*;


import javax.swing.*;
import javax.swing.border.Border;

import ServeInterface.*;


import java.awt.event.*;
import java.rmi.RemoteException;
/**
 * 登陆模板组件
 * 用户输入用户名，密码
 * */
public class LandingPanel extends JPanel{
	 private SystemInterface  system;
	 private PersonInterface    person;
  private JPasswordField jpf=new JPasswordField(10);
  private JTextField jtf=new JTextField(10);
  private JTextField jtf1=new JTextField(10);
  private JLabel jl3=new JLabel("输入主机名");
  private JLabel   jl1=new JLabel("用户名");
  private JLabel  jl2=new JLabel("密码");
  private JPanel  jp1=new JPanel();
  //private JPanel  jp2=new drawImage();
  private JButton jb1=new JButton("登陆");
  private JButton jb2=new JButton("退出");
  //private JButton jb3=new JButton("注册");
  //private JButton jb4=new JButton("连接");
  private JPanel jp3=new JPanel();
  private JPanel jp4=new JPanel(new GridLayout(0,1));
 // private JPanel jp5=new JPanel();
  private LandingGui land=new LandingGui ();
  //初始化模板
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
	//登陆注册
	jb1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//System.out.print(getHostName().equals(""));
	if(!checkData())
	    	JOptionPane.showMessageDialog(
	    			null, "用户名或密码不能为空","提醒",JOptionPane.WARNING_MESSAGE);
	   
	   else if(!LinkServer()){
		   JOptionPane.showMessageDialog(
				   null, "无法建立连接","警告",JOptionPane.WARNING_MESSAGE);
		   jtf1.setText(null);
	   }
		else
			try {
				land.initializeRMI(getHostName());
				person=system.check(getPaperNumber(), getPassword());
			    if(person instanceof ConsumerInterface){
				JOptionPane.showMessageDialog(null, "登陆成功","成功",JOptionPane.OK_OPTION);
				UserGui  user=new UserGui((ConsumerInterface)person);
				user.init();
				user.start(user);
				land.setVisible(false);
			    }
			    else{
			     JOptionPane.showMessageDialog(null, "登陆成功","成功",JOptionPane.OK_OPTION);
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
				
				
					
			
//退出
   jb2.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}
	});
 }			
		
	
   //注册
  // jb3.addActionListener(new ActionListener(){
	//   public void actionPerformed(ActionEvent e){
		   
	  // }
   //});
    //}
 //建立连接
 protected boolean LinkServer() {
	if(getHostName().equals(""))
	return false;
	else
	return	land.initializeRMI(getHostName());
}
protected  boolean checkData() {
	return ((!getPaperNumber().equals(""))&&(!getPassword().equals("")))?true:false;
	}
	

//获取证件号
 public String getPaperNumber(){
	  String  s=jtf.getText().trim();
	  s=s.replaceAll("\\s+", " ");
	  jtf.setText(null);
	  return s;
  } 
 //获取密码
 public String getPassword(){
	char[] ch=jpf.getPassword();
	String s=ch.toString();
	
	return s;
 }
//获取登陆界面的引用
    public void setLandingGui(LandingGui l){
    	land=l;
    }
//获取主机名
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
	

 


