package game4;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.applet.AudioClip;

public class p21 extends JFrame implements ActionListener {
	//���25����ť������
	JButton[][] spots = new JButton[5][5];
	//��ǩ
	JLabel score = new JLabel();
	
	int maxDelay = 1000;
	double hits = 0;
	double turns = 0;
	double maxTurn = 0;
	//��ťͼ��
	ImageIcon alive = new ImageIcon("Alive.jpg");
	//��Ϸ����
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
		//����maxTurn�Ĵ���
		maxTurn = Double.parseDouble(JOptionPane.showInputDialog
				("How many chances do you\n" + "want to kill the devil!!"));
		//��Ӱ�ť�ͱ�ǩ
		Container cont = getContentPane();
		cont.setLayout(new FlowLayout());
		//���ñ���ͼƬ
		JLabel title = new JLabel(new ImageIcon("titel.jpg"));
		cont.add(title);
		//���ɰ�ť�����Ƶ���Ϸ����
		for(int i = 0 ; i < spots.length ; i++){
			for( int j = 0 ; j < spots[0].length ; j++){
				//����JButton
				spots[i][j] = new JButton(alive);
				//��������JButton��ӵ�JFrame
				cont.add(spots[i][j]);
				//���ð�ťΪ����״̬
				spots[i][j].setEnabled(false);
				//��Ӷ���������
				spots[i][j].addActionListener(this);
			}
		}
		//�ڱ�ǩ����ʾ��Ϸ����
		score.setText("Turn" + turns + "/" + maxTurn + ".Current Score:" + ((int) ((hits / maxTurn) * 10)));
		cont.add(score);
		setContentPane(cont);
		//�����߳�
		runner = new T();
		runner.start();
	}
	
	private class T extends Thread{
		public void run(){
			//����ѭ��
			while(true){
				//�жϵ�������Ƿ�ﵽmaxTurn
				if(turns >= maxTurn){
					//��Ϸ�����������Ի�����ʾ��Ϸ����
					JOptionPane.showMessageDialog(null,
							"the game is over \n\n" + "you hit " + hits + 
							"\ndevil in " + turns + " turns.\n" + "\nyour score is " + ((int) (((hits * 10000) / turns))),
							"gameover" , JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				//�����������
				turns++;
				//�������һ���ȴ�ʱ�䣨ȡֵ��ΧΪ0~1.5�룩
				int timeDelay = (int) (Math.random() * 1500);
				try{
					//�߳���ͣ
					Thread.sleep(timeDelay);
				}catch(Exception e){
					e.printStackTrace();
				}
				//���ѡ��һ����ť
				int devil = (int) (Math.random() * 5);
				int devil2 = (int) (Math.random() * 5);
				//���ð�ťΪ����״̬
				spots[devil][devil2].setEnabled(true);
				try{
					//�߳���ͣ1��
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				//��������Ϊ����״̬
				spots[devil][devil2].setEnabled(false);
				//��ʾ��Ϸ����
				score.setText("Turn" + turns + "/" + maxTurn + 
						".Current Score:" + ((int) ((hits * 10000) / maxTurn)));
			}
		}
	}

	//��������õİ�ť�Ƿ���
	public void actionPerformed(ActionEvent e) {		
		//��������һ�Σ�����ʱ����٣������Ѷ�
		maxDelay -= 100;
		scientific.play();
		//������Ϸ����
		hits++;
		//��Ϸ��ͣ0.5��
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
