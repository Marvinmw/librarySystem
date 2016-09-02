package Client;

public class CommondObject{
private  int commond;
private  Object  object;
public void commondObject(int a,Object o){
	object=o;
	commond=a;
}
public int getCommond(){
	return commond;
}
public Object getObject(){
	return object;
}
}
