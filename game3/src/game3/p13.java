package game3;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;


public class p13 extends JFrame implements MouseListener{
	ArrayList lines = new ArrayList();
	Point2D.Double holder;
		
	public p13(){
		super("fuckin game 2!!!!!!!!!!!!!!!!!!!!!!!!!");
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		for(int i=0 ; i<lines.size() ; i++){
			Line2D.Double temp = (Line2D.Double)lines.get(i);
			int x1 = Integer.parseInt("" + Math.round(temp.getX1()));
			int y1 = Integer.parseInt("" + Math.round(temp.getY1()));
			int x2 = Integer.parseInt("" + Math.round(temp.getX2()));
			int y2 = Integer.parseInt("" + Math.round(temp.getY2()));
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		holder = new Point2D.Double(e.getX(), e.getY());
	}
	public void mouseReleased(MouseEvent e){
		Point2D.Double end = new Point2D.Double(e.getX(), e.getY());
		lines.add(new Line2D.Double(holder,end));
		repaint();
	}
	
	public static void main (String[] args){
		new p13();
	}
	
}
