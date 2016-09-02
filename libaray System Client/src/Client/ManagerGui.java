package Client;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;

import ServeInterface.*;

/**
 * 该类为管理员界面
 * 其中搜索结果的显示用表格实现，
 * 且有修改添加，删除，保存的功能（尚未实现）
 * */
public class ManagerGui extends JApplet{
	//private String[][]  s={{"aa","ss","cc","ss"},{"afas","asfsa","fh","ghg"},{"rt","vbn","jj","as"}};
	private int commond=0;
	private ManagerInterface manager;
	private ArrayList<BookInterface>  bookList;
	private ArrayList<ConsumerInterface>  consumerList;
	private ArrayList<PersonInterface>  personList;
	private JLabel jlb1=new JLabel("当前身份：管理员");
	private JLabel[]  jlb2={new JLabel("名称",JLabel.RIGHT)
	,new JLabel("证件",JLabel.RIGHT),new JLabel("密码",JLabel.RIGHT),new JLabel("重输",JLabel.RIGHT)};
	private  JLabel[] jlb3={new JLabel("书名"),new JLabel("作者"),new JLabel("种类")};
	private JButton jb6=new JButton("添加书");
	private JTextField jtf1=new JTextField(10);
	
	
	private JButton jb1=new JButton("搜索");
	private JButton jb2=new JButton("删除");
	private JButton jb3=new  JButton("添加人员");
	private JButton jb5=new JButton("注销");
	//private JButton jb4=new JButton("保存修改");
    private JRadioButton jrb1=new JRadioButton("书名");
    private JRadioButton jrb2=new JRadioButton("作者");
    private JRadioButton  jrb3=new JRadioButton("用户证件号");
    private JRadioButton  jrb4=new JRadioButton("用户姓名");
    private String[]  addItem={"本科生","管理员","研究生","教师"};
    private JComboBox  jcb=new JComboBox(addItem);

    private ButtonGroup bp=new ButtonGroup();
    private JPanel p1=new JPanel();
    private JPanel p2=new JPanel();
    private JPanel p3=new JPanel();
    private JPanel p4=new JPanel();
    private JPanel p5=new JPanel();
    private JPanel p6=new JPanel();
    private JPanel p9=new JPanel();
    private JPanel p10=new JPanel();
  
    private String[] columnName={"姓名","证件号","身份"};
    private String[] columnName1={"书名","作者","种类","是否可借"};
    private DefaultTableModel df=new DefaultTableModel(columnName,8);
    private JTable  jtb=new JTable(df);
   
    
    private JTextField[] jtf2=new JTextField[5];
    private JTextField[] jtf3=new JTextField[3];
    private JPanel[] p7=new JPanel[5];
    private JPanel[] p8=new  JPanel[4];
    
    
    private JTabbedPane jtp=new JTabbedPane();
   
    public ManagerGui(ManagerInterface person) {
		manager=person;
	}

	public void init(){
    	
    	setLayout(new BorderLayout());
    	//ImageIcon ic=new ImageIcon("图片/picture4.jpg");
    	//setIconImage(ic.getImage());
    	//标题
    	p1.add(jlb1);
    	p1.add(jb5);
    	add(p1,BorderLayout.NORTH);
    	
    	bp.add(jrb1);
    	bp.add(jrb2);
    	bp.add(jrb3);
    	bp.add(jrb4);
    	bp.setSelected(jrb1.getModel(), true);
    	//搜索区
        p2.setLayout(new BorderLayout(2,0));
        p4.add(jtf1);
        p4.add(jb1);
        p2.add(p4,BorderLayout.NORTH);
        p5.add(jrb1);
        p5.add(jrb2);
        p5.add(jrb3);
        p5.add(jrb4);
        p2.add(p5,BorderLayout.SOUTH);
        
        //添加区
        
        p7[0]=new JPanel();
        for(int i=0;i<4;i++){
        	p7[i+1]=new JPanel();
        	jtf2[i]=new JTextField(8);
        }
        p8[3]=new JPanel();
        for(int i=0;i<3;i++){
        	p8[i]=new JPanel();
            jtf3[i]=new JTextField(10);	
        }
        p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
        p7[0].add(jcb);
       p7[0].add(jb3);
        p3.add(p7[0]);
        for(int i=0;i<jlb2.length;i++){
        	p7[i+1].add(jlb2[i]);
        	p7[i+1].add(jtf2[i]);
        	p3.add(p7[i+1]);
        }
        
       jb6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED  ));
       //p8[3].setLayout(new BorderLayout());
       p8[3].add(jb6);
      
        for(int i=0;i<jlb3.length;i++){
        	p8[i].add(jlb3[i]);
        	p8[i].add(jtf3[i]);
        	p10.add(p8[i]);
        }
         p10.add(p8[3]);
        jtp.add(p3,"添加人员");
        jtp.add(p10,"添加书籍");
        //搜索显示结果,初始状态
       
        p6.setLayout(new BorderLayout());
        p6.add(new JScrollPane(jtb),BorderLayout.CENTER);
        jtb.getTableHeader().setReorderingAllowed(false);
        
        p9.setLayout(new GridLayout(1,0));
        p9.add(jb2);
       // p9.add(jb4);
        p6.add(p9,BorderLayout.SOUTH);
    	JSplitPane jSpliPane2=new JSplitPane(
    			JSplitPane.VERTICAL_SPLIT,p2,p6);
    	JSplitPane jSplipane1=new JSplitPane(
    			JSplitPane.HORIZONTAL_SPLIT,jtp,jSpliPane2);
         add(jSplipane1,BorderLayout.CENTER);
    	// setSize(700,600);
    	 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setVisible(true);
      
   	  
    	
   //监听搜索按钮
  jb1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		if(jtf1.getText().equals(""))
    			JOptionPane.showMessageDialog(
    					null, "请输入关键字","提醒",JOptionPane.PLAIN_MESSAGE);
    		else{
    			switch(commond){
    			case 0:  try {
    				for(BookInterface b:manager.searchByBookName(getSearchKey()))
    				   bookList.add(b);
						if(bookList.isEmpty())
							showMessage1();
						else{
							changeTableToBookL();
							for(BookInterface bo: bookList){
								String[]   s=getBookInformaton(bo);
								df.addRow(s);
								}
							}
					} catch (RemoteException e1) {
					showMessage();
						e1.printStackTrace();
					}  break;
    			case 1:try{
    				for(BookInterface b:manager.searchByAuthor(getSearchKey()))
    						bookList.add(b);
    				if(bookList.isEmpty())
    					showMessage1();
    				else{
						changeTableToBookL();
						for(BookInterface bo: bookList){
		        		String[]   s=getBookInformaton(bo);
							df.addRow(s);
							}
						}
    			}  catch(RemoteException e1){
    				showMessage();
					e1.printStackTrace();
    			}   break;
    			case 2:try{
    				ConsumerInterface ci=manager.searchConsumerByPaper(getSearchKey());
    				if(ci!=null)
    					consumerList.add(ci);
    				else
    				showMessage1();
    				for(ConsumerInterface bo: consumerList){
						String[]   s=getConsumerInformatin(bo);
						df.addRow(s);
					}
    			}catch(RemoteException e1){
    				showMessage();
    				e1.printStackTrace();
    			}
    			case 3:try{
    				for(PersonInterface ci:manager.searchConsumerByName(getSearchKey()))
    					personList.add(ci);
    				if(personList.isEmpty())
    					showMessage1();
    				else
    				for(PersonInterface p:personList){
    					String[]  m=getPersonInformation(p);
    					df.addRow(m);
    				}
    					
    					
    			}catch(RemoteException e1){
    				showMessage();
    				e1.printStackTrace();
    			}
    		}	
   	}
   	}
  });		
    			
    			
    	
  jb2.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
	  }
  });
  jb3.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	  
  });
  /*jb4.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		  
	  });*/
	  
  jb5.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
  
 jrb1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
    	  changeTableToBookL();
	}
	 
 });
 
 jrb2.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent e) {
		 changeTableToBookL();
	}
	 
 });

 jrb3.addActionListener(new ActionListener(){

	
	public void actionPerformed(ActionEvent e) {
		changeTableToPerson();
	}
	 
 });

 jrb4.addActionListener(new ActionListener(){

	
	public void actionPerformed(ActionEvent e) {
		changeTableToPerson();
	}
	 
 });
 
 jcb.addItemListener(new ItemListener(){

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
	         
	       }
	 
 });
    }

protected String[] getPersonInformation(PersonInterface p) {
	String[]  s=new String[3];
	try {
		s[0]=p.getName();
		s[1]=p.getPapersNumer();
		s[2]=p.getStatus();
		return s;
	} catch (RemoteException e) {
		e.printStackTrace();
		return null;
	}
	}

//书的显示信息
  protected String[] getBookInformaton(BookInterface bo) {
		String[]  s=new String[4];
		try {
			s[0]=bo.getName();
			s[1]=bo.getAuthor();
			s[2]=bo.getIsRare()?"珍贵":"普通";
			s[3]=bo.getCanBorrow()?"可借":"不可借";
			return s;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}	
//人的显示信息	
	protected  String[]  getConsumerInformatin(ConsumerInterface bo) {
		String[]  s=new String[3];
		try {
			s[0]=bo.getName();
			s[1]=bo.getPapersNumer();
			s[2]=bo.getStatus();
			return s;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
  //显示搜索消息
  public void showMessage(){
	  JOptionPane.showMessageDialog(
				null, "搜索失败","提醒",JOptionPane.PLAIN_MESSAGE);
		
  }
  public void showMessage1(){
	  JOptionPane.showMessageDialog(
				null, "未找到","提醒",JOptionPane.PLAIN_MESSAGE);
	 }	
 
  //获取搜索关键字
  public String getSearchKey(){
	  String s=jtf1.getText();
	  s=s.replaceAll("\\s+", " ");
	  s=s.trim();
	  return s;
  }
//改变表格模式
public void changeTableToBookL(){
	  df=new DefaultTableModel(columnName1,8);
	jtb.setModel(df);
	  }
  
  public void changeTableToPerson(){
	  df=new DefaultTableModel(columnName,8);
	  jtb.setModel(df);
  }
 
   public void start(ManagerGui ma){
         JFrame frame=new JFrame();
         ma.init();
         frame.add(ma);
         frame.setSize(500,500);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
}

}   
 
  

		  
	  
	  
	  


