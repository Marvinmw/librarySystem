package Client;
import  javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ServeInterface.*;
import java.awt.*;
import java.awt.event.*;
public class UserGui extends JApplet{
	
 private ConsumerInterface consumer;
 private JLabel  jlb1=new JLabel("��ǰ���");
 private JLabel jlb2=new JLabel("ͼ������");
 private  JLabel jlb3=new JLabel("�������");
 private JLabel jlb4=new JLabel("ע��");
 private JTextField jtf1=new JTextField(10);
 private JButton jb1=new JButton("����");
 private JButton jb2=new JButton("����");
 private JButton jb3=new JButton("����");
 private JButton jb4=new JButton("����");
 private JPanel jp1=new JPanel();
 private JPanel jp2=new JPanel();
 private JPanel jp3=new JPanel();
 private JPanel jp4=new JPanel();
 private JPanel jp5=new JPanel();
 private JPanel jp6=new JPanel();
 private JPanel jp7=new JPanel();
 private JRadioButton jrb1=new JRadioButton("����");
 private JRadioButton jrb2=new JRadioButton("����");
 private String[]  s1={"����","����","����","�Ƿ�ɽ�"};
 private String[]  s2={"����","����","��������","Ӧ������","����"};
 private DefaultTableModel tableModel1=new DefaultTableModel(null,s1);
 private DefaultTableModel tableModel2=new DefaultTableModel(null,s2);
 private JTable  jtable1=new JTable(tableModel1);
 private JTable jtable2=new JTable(tableModel2);
 private JTextArea jta1=new JTextArea(6,10);
 private JSplitPane jSplitPane1=new JSplitPane();
 private  JSplitPane jSplitPane2=new JSplitPane();
 private JSplitPane jSplitPane3=new JSplitPane();
 private ButtonGroup bg=new ButtonGroup();
 
 public UserGui(ConsumerInterface c) {
	consumer=c;
}

public void init(){
	
	 setLayout(new BorderLayout());
	 //��ܱ�ͷ,jlb1Ӧ���������ã���ȷ��ʾ�û����
	 jp1.add(jlb1);
	 jp1.add(jlb4);
	 add(jp1,BorderLayout.NORTH);
	   //������
	  jp5.setLayout(new BorderLayout());
	  jp5.add(jlb2,BorderLayout.NORTH);
	 // jta1.setText("dsaffadsfgasfsdafasfasdfdsa");
	  jp5.add(new JScrollPane(jta1),BorderLayout.CENTER);
	  
	  
	  //�������
	  jp4.setLayout(new BorderLayout());
	  jp4.add(jlb3,BorderLayout.NORTH);
	  jp4.add(new JScrollPane(jtable2),BorderLayout.CENTER);
	  jp6.add(jb3);
	  jp6.add(jb4);
	  jp4.add(jp6,BorderLayout.SOUTH);
	  //jp5.add(jp4,BorderLayout.SOUTH);
	jSplitPane2=new JSplitPane(
				 JSplitPane.VERTICAL_SPLIT,jp5,jp4);
	 
	 //������
	 
	 jp2.add(jtf1);
	 jp2.add(jb1);
	 jp2.add(jrb1);
	 jp2.add(jrb2);
	 jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
	 jp3.add(new JScrollPane(jtable1));
	 jp3.add(jb2);
	 jSplitPane1=new JSplitPane(
			 JSplitPane.VERTICAL_SPLIT,jp2,jp3);
	
	  
	 jSplitPane3=new JSplitPane(
				 JSplitPane.HORIZONTAL_SPLIT, jSplitPane2,jSplitPane1);
	 

	  add(jSplitPane3,BorderLayout.CENTER);
	 // setSize(700,700);
 	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //setVisible(true);
      
        jlb4.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			 });
        jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        	}
        	});
        jb2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        	}
        	});
        jb3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        	}
        	});
        jb4.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        	}
        	});
        jrb1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        jrb2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
       
}	 
 
public  void start(UserGui user){
    JFrame frame=new JFrame();
	frame.add(user);
	frame.setSize(700,680);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	jSplitPane2.setDividerLocation(0.4);
    jSplitPane3.setDividerLocation(0.5);
     
	
}
 
}









