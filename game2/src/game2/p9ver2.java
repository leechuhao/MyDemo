package game2;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.applet.*;

public class p9ver2 extends JFrame{
	URL url1 = null,	url2 = null,	url3 = null,	url4 = null,	url5 = null,
			url6 = null,	url7 = null,	url8 = null;
	Image img1,img2,img3,img4,img5,img6,img7,img8;
	//
	URL urlt = null;
	Image title = null;
	//
	final int wid = 900 ,hei = 650;
	boolean winner = false;
	double p1speed = .5,	p2speed =  .5;
	int p1Laps = 0,p2Laps = 0;
	//
	final int UP = 0,RIGHT = 1,DOWN = 2,LEFT = 3;
	int p1Direction = UP;
	int p2Direction = UP;
	
	Rectangle left = new Rectangle(0,0,wid/9,hei);
	Rectangle right = new Rectangle((wid/9) * 9,0,wid/9,hei);
	Rectangle top = new Rectangle(0,0,wid,hei/9);
	Rectangle bottom = new Rectangle(0,(hei/9)*9,(wid/9)*10,hei/9);
	Rectangle center = new Rectangle((int)((wid/9)*2.5),(int)((hei/9)*2.5),(int)((wid/9)*5),(hei/9)*4);
	
	Rectangle obstacle = new Rectangle(wid/2,(int)((hei/9)*7),wid/10,hei/9);
	Rectangle obstacle2 = new Rectangle(wid/3,(int)((hei/9)*5),wid/10,hei/4);
	Rectangle obstacle3 = new Rectangle(2*(wid/3),(int)((hei/9)*5),wid/10,hei/4);
	Rectangle obstacle4 = new Rectangle(wid/4,hei/9,wid/30,hei/9);
	Rectangle obstacle5 = new Rectangle(wid/2,(int)((hei/9)*1.5),wid/30,hei/4);
	
	Rectangle finish = new Rectangle(wid/9,(hei/2)-hei/9,(int)((wid/9)*1.5),hei/70);
	Rectangle line0 = new Rectangle(wid/9,hei/2,(int)((wid/9)*1.5)/2,hei/140);
	Rectangle line1 = new Rectangle(((wid/9)+((int)((wid/9)*1.5)/2)),(hei/2)+(hei/10),(int)((wid/9)*1.5)/2,hei/140);
	
	Rectangle p1 = new Rectangle(wid/9,hei/2,wid/30,hei/30);
	Rectangle p2 = new Rectangle(((wid/9)+((int)((wid/9)*1.5)/2)),(hei/2)+(hei/10),wid/30,hei/30);

	public p9ver2 (){
		super("what the fuck is this game?????");
		setSize(wid/9*10,hei/9*10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//
		try{
			url1 = this.getClass().getResource("1.jpg");
			url2 = this.getClass().getResource("2.jpg");
			url3 = this.getClass().getResource("3.jpg");
			url4 = this.getClass().getResource("4.jpg");
			url5 = this.getClass().getResource("5.jpg");
			url6 = this.getClass().getResource("6.jpg");
			url7 = this.getClass().getResource("7.jpg");
			url8 = this.getClass().getResource("8.jpg");
			urlt = this.getClass().getResource("9.jpg");	
		}catch(Exception e){}
		//
		img1 = Toolkit.getDefaultToolkit().getImage(url1);
		img2 = Toolkit.getDefaultToolkit().getImage(url2);
		img3 = Toolkit.getDefaultToolkit().getImage(url3);
		img4 = Toolkit.getDefaultToolkit().getImage(url4);
		img5 = Toolkit.getDefaultToolkit().getImage(url5);
		img6 = Toolkit.getDefaultToolkit().getImage(url6);
		img7 = Toolkit.getDefaultToolkit().getImage(url7);
		img8 = Toolkit.getDefaultToolkit().getImage(url8);
		title = Toolkit.getDefaultToolkit().getImage(urlt);
		
		JOptionPane.showMessageDialog(null, "now we start");
		
		Move1 m1 = new Move1();
		Move2 m2 = new Move2();
		m1.start();
		m2.start();	
		//
		try{
			URL eng = this.getClass().getResource("6666.mp3");
			AudioClip snd = JApplet.newAudioClip(eng);
			snd.loop();//循环播放   snd.paly()播放一次
		}catch(Exception e){}
	}
	
	
	
	public void paint(Graphics g){
		super.paint(g);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, wid, hei);
		
		g.setColor(Color.GREEN);
		g.fillRect(left.x, left.y, left.width, left.height);
		g.fillRect(right.x, right.y, right.width, right.height);
		g.fillRect(top.x, top.y, top.width, top.height);
		g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
		g.fillRect(center.x, center.y, center.width, center.height);
		g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
		g.fillRect(obstacle2.x, obstacle2.y, obstacle2.width, obstacle2.height);
		g.fillRect(obstacle3.x, obstacle3.y, obstacle3.width, obstacle3.height);
		g.fillRect(obstacle4.x, obstacle4.y, obstacle4.width, obstacle4.height);
		g.fillRect(obstacle5.x, obstacle5.y, obstacle5.width, obstacle5.height);
		
		g.setColor(Color.WHITE);
		g.fillRect(line0.x, line0.y, line0.width, line0.height);
		g.fillRect(line1.x, line1.y, line1.width, line1.height);
		
		g.setColor(Color.YELLOW);
		g.fillRect(finish.x, finish.y, finish.width, finish.height);
		//
		g.drawImage(title, center.x + 10, center.y + 10, this);
		//p1
		if(p1Direction == UP){
			g.drawImage(img5, p1.x, p1.y, this);
		}
		if(p1Direction == DOWN){
			g.drawImage(img8, p1.x, p1.y, this);
		}
		if(p1Direction == LEFT){
			g.drawImage(img7, p1.x, p1.y, this);
		}
		if(p1Direction == RIGHT){
			g.drawImage(img6, p1.x, p1.y, this);
		}
		/////p2
		if(p2Direction == UP){
			g.drawImage(img1, p2.x, p2.y, this);
		}
		if(p2Direction == DOWN){
			g.drawImage(img4, p2.x, p2.y, this);
		}
		if(p2Direction == LEFT){
			g.drawImage(img3, p2.x, p2.y, this);
		}
		if(p2Direction == RIGHT){
			g.drawImage(img2, p2.x, p2.y, this);
		}
	}
	
	
	private class Move1 extends Thread implements KeyListener {
		public void run(){
			addKeyListener(this);
			while(true){
				try{
					repaint();
					//碰撞
					if(p1.intersects(left)||p1.intersects(right)||p1.intersects(top)||p1.intersects(bottom)||
							p1.intersects(obstacle)||p1.intersects(obstacle2)||
							p1.intersects(obstacle3)||p1.intersects(obstacle4)||p1.intersects(obstacle5)||
							p1.intersects(p2)){
						p1speed = -4;
					}
					if(p1.intersects(center)){
						p1speed = -2.5;
					}
					//圈数
					if(p1.intersects(finish) && p1Direction == UP){
						p1Laps++;
					}
					if(p1Laps >= 24){
						if(!winner){
							winner = true;
							JOptionPane.showMessageDialog(null, "Play1 win this game!!!");
							break;
						}else {
							JOptionPane.showMessageDialog(null, "Play1 lose\n" + "Play2 win");
							break;
						}
					}
					//加速
					if(p1speed <= 5){
						p1speed += .2;
					}
					//方向
					if(p1Direction == UP){
						p1.y -= (int)p1speed;
					}
					if(p1Direction == DOWN){
						p1.y += (int)p1speed;
					}
					if(p1Direction == LEFT){
						p1.x -= (int)p1speed;
					}
					if(p1Direction == RIGHT){
						p1.x += (int)p1speed;
					}
					//每次行驶间隔
					Thread.sleep(75);
				}catch(Exception e){
					break;
				}
				
			}
		}
		
		
		
		
		public void keyPressed(KeyEvent e){	}
		public void keyReleased(KeyEvent e){}
		public void keyTyped (KeyEvent e){
			if(e.getKeyChar() == 'a'){
				p1Direction = LEFT;
			}
			if(e.getKeyChar() == 's'){
				p1Direction = DOWN;
			}
			if(e.getKeyChar() == 'w'){
				p1Direction = UP;
			}
			if(e.getKeyChar() == 'd'){
				p1Direction = RIGHT;
			}
		}
	}
	
	
	
	
	private class Move2 extends Thread implements KeyListener{
		public void run(){
			addKeyListener(this);
			while(true){
				try{
					repaint();
					//碰撞
					if(p2.intersects(left)||p2.intersects(right)||p2.intersects(top)||p2.intersects(bottom)||
							p2.intersects(obstacle)||p2.intersects(obstacle2)||p2.intersects(obstacle3)||
							p2.intersects(obstacle4)||p2.intersects(obstacle5)){
						p2speed = -4;
					}
					if(p2.intersects(center)){
						p2speed = -2.5;
					}
					//圈数
					if(p2.intersects(finish) && p2Direction == UP){
						p2Laps++;
					}
					if(p2Laps >= 32){
						if(!winner){
							winner = true;
							JOptionPane.showMessageDialog(null, "Play2 win this game!!!");
							break;
						}else {
							JOptionPane.showMessageDialog(null, "Play2 lose\n" + "Play1 win");
							break;
						}
					}
					//加速
					if(p2speed <= 5){
						p2speed += .2;
					}
					//方向
					if(p2Direction == UP){
						p2.y -= (int)p2speed;
					}
					if(p2Direction == DOWN){
						p2.y += (int)p2speed;
					}
					if(p2Direction == LEFT){
						p2.x -= (int)p2speed;
					}
					if(p2Direction == RIGHT){
						p1.x += (int)p2speed;
					}
					//每次行驶间隔
					Thread.sleep(75);
				}catch(Exception e){
					break;
				}
			}
		}
		public void keyPressed(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
		public void keyTyped(KeyEvent event){
			if(event.getKeyChar() == 'j'){
				p2Direction = LEFT;
			}
			if(event.getKeyChar() == 'k'){
				p2Direction = DOWN;
			}
			if(event.getKeyChar() == 'i'){
				p2Direction = UP;
			}
			if(event.getKeyChar() == 'l'){
				p2Direction = RIGHT;
			}
		}
	}
	
	public static void main (String[] args){
		new p9ver2();
	}
}
