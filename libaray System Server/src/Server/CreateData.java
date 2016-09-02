package Server;
import java.io.*;
import java.util.ArrayList;

public class CreateData {
	ArrayList<Teacher>  t=new ArrayList();
	public CreateData(){
		try{
    ObjectOutputStream  outputT=new ObjectOutputStream(new FileOutputStream("TeacherList",false));
    
   t.add(new Teacher("Jno","25","125", true));
   t.add(new Teacher("Tom","23", "124",true));
   t.add(new Teacher("Sun", "26", "127", true));
   t.add(new Teacher("李华", "27", "128",true));
   t.add(new Teacher("李丹", "24", "129", true));
   outputT.writeObject(t);
    outputT.close();
    ArrayList<Undergraduate>  u=new ArrayList();
    ObjectOutputStream  outputU=new ObjectOutputStream(new FileOutputStream("UndergraduateList",false));
   u.add(new  Undergraduate("章鱼","142", "135",false));
   u.add(new  Undergraduate("王大", "143","136", false));
   outputU.writeObject(u);
    outputU.close();
    
    ArrayList<Postgraduate>  p=new ArrayList();
    ObjectOutputStream  outputP=new ObjectOutputStream(new FileOutputStream("PostgraduateList",false));
    p.add(new Postgraduate("米泽", "101", "132", true));
    p.add(new Postgraduate("都帅", "102", "133", true));
    outputP.writeObject(p);
    outputP.close();
    
    ArrayList<Manager>  m=new ArrayList();
    ObjectOutputStream  outputM=new ObjectOutputStream(new FileOutputStream("ManagerList",false));
    m.add(new Manager("老大","167","124"));
    outputM.writeObject(m);
    outputM.close();
    
    ArrayList<Book>  b=new ArrayList();
    ObjectOutputStream  outputB=new ObjectOutputStream(new FileOutputStream("BookList",false));
   b.add(new Book("Red","DOO",false));
   b.add(new Book("Black and h","DOO",false));
   b.add(new Book("Hei","黑子",true));
   b.add(new Book("Hei","adas",true));
   outputB.writeObject(b);
    outputB.close();
		}catch(IOException es){
		}	
		
    }
}
