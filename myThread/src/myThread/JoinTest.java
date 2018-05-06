package myThread;

import java.awt.*;
import javax.swing.*;

public class JoinTest extends JFrame{
	private Thread t1;
	private Thread t2;
	//进度条组件
	final JProgressBar pb1 =new JProgressBar();
	final JProgressBar pb2 =new JProgressBar();
	int count = 0;
	
	public JoinTest(){
		super();
		getContentPane().add(pb1, BorderLayout.NORTH);
		getContentPane().add(pb2, BorderLayout.SOUTH);
		//设置进度条显示数字字符
		pb1.setStringPainted(true);
		pb2.setStringPainted(true);
		
		t1 = new Thread(new Runnable(){
			int i = 55;
			public void run() {
				while(true){
					pb1.setValue(++i);//进度条当前值
					try {
						Thread.sleep(100);
						t2.join();
					} catch (Exception e) {
						e.printStackTrace( );
					}
					if(i == 99){
						JOptionPane.showMessageDialog(null, "软件出错，请重新启动！！");
						break;
					}
				}
			}
		});
		t1.start();
		t2 = new Thread(new Runnable(){
			int j = 0;
			public void run(){
				while(true){
					pb2.setValue(++j);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace( );
					}
					if(j == 100){
						break;
					}
				}
			}
		});
		t2.start();
	}
	
	public static void init(JFrame frame, int width, int height){
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		init(new JoinTest(), 600, 100);
	}
	
}
