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
	//�ӵ�ͼƬ
	ImageIcon shipBullet = new ImageIcon("shipBullets.png");
	ImageIcon enemyBullet = new ImageIcon("enemyBullets.png");
	//�ӵ�����
	ArrayList playerBullets = new ArrayList();
	ArrayList enemyBullets = new ArrayList();
	//��������
	ArrayList enemies = new ArrayList();
	//�ɴ�ͼƬ
	ImageIcon shipImg = new ImageIcon("ship.png");
	ImageIcon shipHit = new ImageIcon("shipHit.png");
	ImageIcon enemyImg = new ImageIcon("enemy.png");
	ImageIcon enemyHit = new ImageIcon("enemyHit.png");
	//�ӵ���
	JLabel powerup = new JLabel( new ImageIcon("powerup.pmg"));
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	
}
