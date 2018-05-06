package game4;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.applet.AudioClip;

public class p21 extends JFrame implements ActionListener {
	//存放25个按钮的数组
	JButton[][] spots = new JButton[5][5];
	//标签
	JLabel score = new JLabel();
	
	int maxDelay = 1000;
	double hits = 0;
	double turns = 0;
	double maxTurn = 0;
	//按钮图标
	ImageIcon alive = new ImageIcon("Alive.jpg");
	//游戏进程
	T runner = null;
	URL sci = null,dr = null;
	AudioClip scientific = null,door = null;
	
	
	public p21 (){
		super("game 4");
		setSize(350,325);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			sci = this.getClass().getResource("sci.mp3");
			dr = this.getClass().getResource("dr.mp3");
			scientific = JApplet.newAudioClip(sci);
			door = JApplet.newAudioClip(dr);
		}catch(Exception e){
			e.printStackTrace();
		}
		//设置maxTurn的次数
		maxTurn = Double.parseDouble(JOptionPane.showInputDialog
				("How many chances do you\n" + "want to kill the devil!!"));
		//添加按钮和标签
		Container cont = getContentPane();
		cont.setLayout(new FlowLayout());
		//设置标题图片
		JLabel title = new JLabel(new ImageIcon("titel.jpg"));
		cont.add(title);
		//生成按钮并绘制到游戏窗口
		for(int i = 0 ; i < spots.length ; i++){
			for( int j = 0 ; j < spots[0].length ; j++){
				//创建JButton
				spots[i][j] = new JButton(alive);
				//将创建的JButton添加到JFrame
				cont.add(spots[i][j]);
				//设置按钮为禁用状态
				spots[i][j].setEnabled(false);
				//添加动作监听器
				spots[i][j].addActionListener(this);
			}
		}
		//在标签里显示游戏分数
		score.setText("Turn" + turns + "/" + maxTurn + ".Current Score:" + ((int) ((hits / maxTurn) * 10)));
		cont.add(score);
		setContentPane(cont);
		//运行线程
		runner = new T();
		runner.start();
	}
	
	private class T extends Thread{
		public void run(){
			//永久循环
			while(true){
				//判断点击次数是否达到maxTurn
				if(turns >= maxTurn){
					//游戏结束，弹出对话框显示游戏分数
					JOptionPane.showMessageDialog(null,
							"the game is over \n\n" + "you hit " + hits + 
							"\ndevil in " + turns + " turns.\n" + "\nyour score is " + ((int) (((hits * 10000) / turns))),
							"gameover" , JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				//点击次数递增
				turns++;
				//随机生成一个等待时间（取值范围为0~1.5秒）
				int timeDelay = (int) (Math.random() * 1500);
				try{
					//线程暂停
					Thread.sleep(timeDelay);
				}catch(Exception e){
					e.printStackTrace();
				}
				//随机选择一个按钮
				int devil = (int) (Math.random() * 5);
				int devil2 = (int) (Math.random() * 5);
				//设置按钮为启用状态
				spots[devil][devil2].setEnabled(true);
				try{
					//线程暂停1秒
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				//重新设置为禁用状态
				spots[devil][devil2].setEnabled(false);
				//显示游戏分数
				score.setText("Turn" + turns + "/" + maxTurn + 
						".Current Score:" + ((int) ((hits * 10000) / maxTurn)));
			}
		}
	}

	//检查已启用的按钮是否按下
	public void actionPerformed(ActionEvent e) {		
		//如果被点击一次，则间隔时间减少，增加难度
		maxDelay -= 100;
		scientific.play();
		//增加游戏分数
		hits++;
		//游戏暂停0.5秒
		try{
			runner.sleep(500);
			Thread.sleep(500);
		}catch(Exception ee){
			
		}
	}

	public static void main(String[] args){
		new p21();
	}
}
