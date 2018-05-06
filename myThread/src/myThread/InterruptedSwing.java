package myThread;

import java.awt.*;
import javax.swing.*;

public class InterruptedSwing extends JFrame{
	Thread t;
	
	public InterruptedSwing(){
		super();
		final JProgressBar pb = new JProgressBar();		
		getContentPane().add(pb, BorderLayout.NORTH);
		pb.setStringPainted(true);
		
		t = new Thread(new Runnable() {
			int i = 50;
			public void run() {
				while(true){
					pb.setValue(++i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						System.out.println("当前程序中断！！");
						break;
					}
				}
			}
		});
		t.start();
		t.interrupt();//会抛出InterruptedException 
		
	}
	
	public static void init(JFrame frame, int width, int height){
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}	
	
	public static void main(String[] args) {
		init(new InterruptedSwing(), 100, 100);
	}
}
