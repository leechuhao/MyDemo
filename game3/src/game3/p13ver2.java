package game3;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class p13ver2 extends JFrame implements MouseListener , KeyListener{
	//记录所有绘制的线
	ArrayList lines = new ArrayList();
	//记录滑道的起始点坐标
	Point2D.Double holder;
	Move move ;
	//记录键盘输入的字符
	Rectangle guy = null;
	boolean drawGuy = false;
		
	public p13ver2(){
		super("fuckin game 2!!!!!!!!!!!!!!!!!!!!!!!!!");
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		addKeyListener(this);
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		//获取数组中的所有线段
		for(int i=0 ; i<lines.size() ; i++){
			Line2D.Double temp = (Line2D.Double)lines.get(i);
			int x1 = Integer.parseInt("" + Math.round(temp.getX1()));
			int y1 = Integer.parseInt("" + Math.round(temp.getY1()));
			int x2 = Integer.parseInt("" + Math.round(temp.getX2()));
			int y2 = Integer.parseInt("" + Math.round(temp.getY2()));
			g.drawLine(x1, y1, x2, y2);
		}
		if(drawGuy){
			try{
				URL url = this.getClass().getResource("guy.png");
				Image img = Toolkit.getDefaultToolkit().getImage(url);
				g.drawImage(img, guy.x, guy.y, this);
			}catch(Exception e){}
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
	
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){
		//p开始guy进程
		if(e.getKeyChar() == 'p' || e.getKeyCode() == 'P'){
			move = new Move();
			move.start();
			move.action(true);
		}
		//q结束guy进程
		if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q'){
			move.action(false);
			drawGuy = false;
			move = null;
		}
	}
	
	public class Move extends Thread{
		//重力g，速度v
		double v;
		double g;
		boolean go = false;
		public void run(){
			if(go){
				initGuy();
				v = 0;
				g = 1;
			}
			while(go){
				try{
					//记录滑道（线路为空时表示还没有定制滑道）
					Line2D.Double lineTaken = null;
					//是否在滑道上
					boolean onLine = false;
					//第一次落在滑道上要重新设定重力g
					int firstOnLine = -1;
					for(int i = lines.size()-1 ; i >= 0 ; i--){
						Line2D.Double temp = (Line2D.Double)lines.get(i);
						if(temp.intersects(guy.x,guy.y,30,30)){
							lineTaken = temp;
							onLine = true;
							if(firstOnLine != i){
								firstOnLine = i;
								g = 0;
							}
							break;
						}
					}
					if(onLine){
						//重新获取重力g
						double mg = (lineTaken.y2 - lineTaken.y1)/50;
						//重新获取速率v
						double mv = (lineTaken.x2 - lineTaken.x1)/100;
						//加速
						if(v <= 5){
							v += mv;
						}
						if(g <= 2.5){
							g += mg;
						}else{
							g += .2;
						}
						guy.x += v;
						guy.y += g;
						Thread.sleep(75);
						repaint();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		public void action(boolean a){
			go = a;
		}
		
		public void initGuy(){
			Line2D.Double firstLine = (Line2D.Double)lines.get(0);
			//获取第一段路线的起点
			int x = Integer.parseInt("" + Math.round(firstLine.x1));
			int y = Integer.parseInt("" + Math.round(firstLine.y1));
			guy = new Rectangle(x+30 , y-20 , 30 , 30);
			drawGuy = true;
		}
	}
	
	public static void main (String[] args){
		new p13ver2();
	}
	
}
