package game2;
import java.awt.*;
import javax.swing.*;


public class MyGUI extends JFrame {
	
	//	public void paint �ڳ����һ�����е�ʱ��ִ�У�֮����Լ�repaint();
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillRect(100, 100, 500, 250);
	}
	
	
	public MyGUI(){
		super("tile goes here");
		setSize(900,680);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main (String[] args){
		new MyGUI();
	}
}
