package myDraw;

import java.awt.Graphics;

import javax.swing.*;

public class DrawCircle extends JFrame{
	private final int OVAL_WIDTH = 80;
	private final int OVAL_HEIGHT = 80;
	
	public DrawCircle(){
		super();
		initialize();
	}
	
	private void initialize(){
		this.setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new drawPanel());
		this.setTitle("»æÍ¼ÊµÀý1");
	}
	
	class drawPanel extends JPanel{
		public void paint(Graphics g){
			super.paint(g);
			g.drawOval(10, 10, OVAL_WIDTH, OVAL_HEIGHT);
			g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT);
			g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT);
			g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT);
			g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT);
		}
	}
	
	public static void main(String[] args) {
		new DrawCircle().setVisible(true);
	}
	
}
