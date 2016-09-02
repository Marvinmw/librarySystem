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
 * ����Ϊ����Ա����
 * ���������������ʾ�ñ��ʵ�֣�
 * �����޸���ӣ�ɾ��������Ĺ��ܣ���δʵ�֣�
 * */
public class ManagerGui extends JApplet{
	//private String[][]  s={{"aa","ss","cc","ss"},{"afas","asfsa","fh","ghg"},{"rt","vbn","jj","as"}};
	private int commond=0;
	private ManagerInterface manager;
	private ArrayList<BookInterface>  bookList;
	private ArrayList<ConsumerInterface>  consumerList;
	private ArrayList<PersonInterface>  personList;
	private JLabel jlb1=new JLabel("��ǰ��ݣ�����Ա");
	private JLabel[]  jlb2={new JLabel("����",JLabel.RIGHT)
	,new JLabel("֤��",JLabel.RIGHT),new JLabel("����",JLabel.RIGHT),new JLabel("����",JLabel.RIGHT)};
	private  JLabel[] jlb3={new JLabel("����"),new JLabel("����"),new JLabel("����")};
	private JButton jb6=new JButton("�����");
	private JTextField jtf1=new JTextField(10);
	
	
	private JButton jb1=new JButton("����");
	private JButton jb2=new JButton("ɾ��");
	private JButton jb3=new  JButton("�����Ա");
	private JButton jb5=new JButton("ע��");
	//private JButton jb4=new JButton("�����޸�");
    private JRadioButton jrb1=new JRadioButton("����");
    private JRadioButton jrb2=new JRadioButton("����");
    private JRadioButton  jrb3=new JRadioButton("�û�֤����");
    private JRadioButton  jrb4=new JRadioButton("�û�����");
    private String[]  addItem={"������","����Ա","�о���","��ʦ"};
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
  
    private String[] columnName={"����","֤����","���"};
    private String[] columnName1={"����","����","����","�Ƿ�ɽ�"};
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
    	//ImageIcon ic=new ImageIcon("ͼƬ/picture4.jpg");
    	//setIconImage(ic.getImage());
    	//����
    	p1.add(jlb1);
    	p1.add(jb5);
    	add(p1,BorderLayout.NORTH);
    	
    	bp.add(jrb1);
    	bp.add(jrb2);
    	bp.add(jrb3);
    	bp.add(jrb4);
    	bp.setSelected(jrb1.getModel(), true);
    	//������
        p2.setLayout(new BorderLayout(2,0));
        p4.add(jtf1);
        p4.add(jb1);
        p2.add(p4,BorderLayout.NORTH);
        p5.add(jrb1);
        p5.add(jrb2);
        p5.add(jrb3);
        p5.add(jrb4);
        p2.add(p5,BorderLayout.SOUTH);
        
        //�����
        
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
        jtp.add(p3,"�����Ա");
        jtp.add(p10,"����鼮");
        //������ʾ���,��ʼ״̬
       
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
      
   	  
    	
   //����������ť
  jb1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e){
    		if(jtf1.getText().equals(""))
    			JOptionPane.showMessageDialog(
    					null, "������ؼ���","����",JOptionPane.PLAIN_MESSAGE);
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

//�����ʾ��Ϣ
  protected String[] getBookInformaton(BookInterface bo) {
		String[]  s=new String[4];
		try {
			s[0]=bo.getName();
			s[1]=bo.getAuthor();
			s[2]=bo.getIsRare()?"���":"��ͨ";
			s[3]=bo.getCanBorrow()?"�ɽ�":"���ɽ�";
			return s;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}	
//�˵���ʾ��Ϣ	
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
	
  //��ʾ������Ϣ
  public void showMessage(){
	  JOptionPane.showMessageDialog(
				null, "����ʧ��","����",JOptionPane.PLAIN_MESSAGE);
		
  }
  public void showMessage1(){
	  JOptionPane.showMessageDialog(
				null, "δ�ҵ�","����",JOptionPane.PLAIN_MESSAGE);
	 }	
 
  //��ȡ�����ؼ���
  public String getSearchKey(){
	  String s=jtf1.getText();
	  s=s.replaceAll("\\s+", " ");
	  s=s.trim();
	  return s;
  }
//�ı���ģʽ
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
 
  

		  
	  
	  
	  


