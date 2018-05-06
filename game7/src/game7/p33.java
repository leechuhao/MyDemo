package game7;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class p33 extends JFrame implements KeyListener ,MouseMotionListener{
	Container cont;
	int currentLevel = 1;
	int numEnemies = 1;
	//子弹图片
	ImageIcon shipBullet = new ImageIcon("shipBullets.png");
	ImageIcon enemyBullet = new ImageIcon("enemyBullets.png");
	//子弹数组
	ArrayList playerBullets = new ArrayList();
	ArrayList enemyBullets = new ArrayList();
	//敌人数组
	ArrayList enemies = new ArrayList();
	//飞船图片
	ImageIcon shipImg = new ImageIcon("ship.png");
	ImageIcon shipHit = new ImageIcon("shipHit.png");
	ImageIcon enemyImg = new ImageIcon("enemy.png");
	ImageIcon enemyHit = new ImageIcon("enemyHit.png");
	//子弹包
	JLabel powerup = new JLabel( new ImageIcon("powerup.pmg"));
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	
}
