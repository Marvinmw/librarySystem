package Client;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class drawImage extends JApplet{
	private ImageIcon  p=new ImageIcon("ͼƬ/picture1.jpg");
	private Image  p1=p.getImage();
	drawImage(){
		
	}
	drawImage(String s){
	  p=new ImageIcon(s);
		 p1=p.getImage();
	}
  protected void paintComponent(Graphics g){
	  super.paintComponents(g);
	  g.drawImage(p1,0, 0, getWidth(),getHeight(), Color.green,this);
  }
}
