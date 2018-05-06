package game6;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class p29 extends JFrame{
	//
	ArrayList bulletsLeft = new ArrayList();
	ArrayList bulletsRight = new ArrayList();
	//
	ArrayList[] bullets = {bulletsLeft , bulletsRight};
	//
	int width = 800;
	int height = 600;
	//
	int scoreLeft = 0 ;
	int scoreRight = 0;
	JLabel left = new JLabel("score :" + scoreLeft);
	JLabel right = new JLabel("score :" + scoreRight);
	//
	ImageIcon snakeLeftImg = new ImageIcon("snakeleft.png");
	ImageIcon snakeRightImg = new ImageIcon("snakeleft.png");
	ImageIcon snakeLeftHit = new ImageIcon("snakeleft.png");
	ImageIcon snakeRightHit = new ImageIcon("snakeleft.png");
	//
	JLabel snakeLeft = new JLabel(snakeLeftImg);
	JLabel snakeRight = new JLabel(snakeRightImg);
	JLabel food = new JLabel(new ImageIcon("food.png"));
	JLabel venomLeft = new JLabel(new ImageIcon("venomLeft.png"));
	JLabel venomRight = new JLabel(new ImageIcon("venomRight.png"));
	//
	int foodX = 1;
	int foodY = 1;
	//
	Container cont;
	
	public p29(){
		//
		super("asfdasdfasdf");
		setVisible(true);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		cont = getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.BLACK);
		//
		cont.add(left);
		left.setFont(new Font("times new roman" , Font.BOLD,20));
		left.setBounds(50 , 50 , 100 , 30);
		left.setForeground(Color.WHITE);
		cont.add(right);
		right.setFont(new Font("time new roman" , Font.BOLD  , 20));
		right.setBounds(width - 150, 50 , 100 , 30);
		right.setForeground(Color.WHITE);
		//
		cont.add(snakeLeft);
		snakeLeft.setBounds(50 , height/2 , 30 , 200);
		cont.add(snakeRight);
		snakeRight.setBounds(width/2, height/2, 30, 30);
		//
		cont.add(food);
		food.setBounds(width/2, height/2, 30, 30);
		//蛇运行的进程
		SnakeThread st = new SnakeThread();
		st.start();
		//
		Attack attack = new Attack();
		attack.start();
		//
		JLabel background = new JLabel(new ImageIcon("background.jpg"));
		cont.add(background);
		background.setBounds(0, 0, 800, 600);	
	}
	
	public class Attack extends Thread{
		public void run(){
			while(true){
				try{
					int interval = (int) (Math.random() * 2000);
					Thread.sleep(interval);
					bulletsRight.add(venomRight);
					cont.add(venomRight);
					cont.setComponentZOrder(venomRight , 0);
					venomRight.setBounds(snakeRight.getX() - 30 , snakeRight.getY() + 30 , 20 , 10);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public class SnakeThread extends Thread implements KeyListener{
		public  void run(){
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
			addKeyListener(this);
			while(true){
				try{
					//两个for循环
					for(int i = 0 ; i < bullets.length ; i++){
						int distance = 0;
						if(i == 0){
							distance = 1;
						}else{
							distance = -1;
						}
						for(int j = 0 ; j < bullets[i].size() ; j++){
							JLabel temp = ((JLabel) bullets[i].get(j));
							//检测毒液是否命中了蛇
							if(i == 0){
								if(snakeRight.getBounds().intersects(temp.getX() , temp.getY() , 20 , 10)){
									snakeRight.setIcon(snakeRightHit);
									scoreLeft++;
									left.setText("score:" + scoreLeft);	
									bullets[i].remove(j);
									Thread.sleep(100);
									snakeRight.setIcon(snakeRightImg);								
								}else{
									if(snakeLeft.getBounds().intersects(temp.getX() , temp.getY() , 20 , 10)){
										snakeLeft.setIcon(snakeLeftHit);
										scoreRight++;
										right.setText("score :" + scoreRight);
										bullets[i].remove(j);
										Thread.sleep(100);
										snakeLeft.setIcon(snakeLeftImg);
									}
								}
								((JLabel) bullets[i].get(j)).setBounds(temp.getX() + distance , temp.getY() , 20 , 10);
							}
						}
						//food撞到左右侧
						if(food.getX() < 0 || food.getX() > width){
							//reset food
							food.setBounds(width/2, height/2, 30, 30);
							foodX = 1;
							foodY = 1;
							if(food.getX() < 0){
								scoreLeft++;
							}else{
								scoreRight++;
							}
							left.setText("score :" + scoreLeft);
							right.setText("score :"  + scoreRight);
						}//撞到上下侧
						else if(food.getY() > height-30 || food.getY() < 0){
							foodY = -1;
						}//诱饵碰到蛇
						else if((food.getX() < 80 && 
								food.getY() > snakeLeft.getY() && 
								food.getY() < snakeLeft.getY() + 200)|| 
								(food.getX() > width - 80 &&
								food.getY() > snakeRight.getY() && 
								food.getY() < snakeRight.getY() + 200)){
							foodX = -1;
						}
						//重新放诱饵
						food.setBounds(food.getX() - foodX , food.getY() - foodY, 30, 30);
						//自动控制右边的蛇
						if(food.getY() > snakeRight.getY() + 200){
							snakeRight.setBounds(snakeRight.getX() , snakeRight.getY() + 4 , 30 , 200);
						}
						if(food.getY() < snakeRight.getY()){
							snakeRight.setBounds(snakeRight.getX() , snakeRight.getY() - 4 , 30 , 200);
						}
						//
						Thread.sleep(4000);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == 'w'){
				snakeLeft.setBounds(snakeLeft.getX() , snakeLeft.getY() - 10 , 30 , 200);
			}
			if(e.getKeyChar() == 's'){
				snakeLeft.setBounds(snakeLeft.getX() , snakeLeft.getY() + 10 , 30 , 200);
			}
			if(e.getKeyChar() == 'q'){
				bulletsLeft.add(venomLeft);
				cont.add(venomLeft);
				cont.setComponentZOrder(venomLeft , 0);
				venomLeft.setBounds(snakeLeft.getX() + 30 , snakeLeft.getY() + 30, 20 , 10);
			}
		}
		
		public void keyReleased(KeyEvent arg0) {
			
		}

		public void keyTyped(KeyEvent arg0) {
			
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args){
		new p29();
	}
}
