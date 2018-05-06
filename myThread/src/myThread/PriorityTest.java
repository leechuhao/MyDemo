package myThread;

import java.awt.*;
import javax.swing.*;

public class PriorityTest extends JFrame{
	
	public PriorityTest(){
		super("听说会有优先级");
		Thread t1 =new Thread( );
		Thread t2 =new Thread( );
		Thread t3 =new Thread( );
		Thread t4 =new Thread( );
		final JProgressBar progressBar1 = new JProgressBar();
		final JProgressBar progressBar2 = new JProgressBar();
		final JProgressBar progressBar3 = new JProgressBar();
		final JProgressBar progressBar4 = new JProgressBar();
//		getContentPane().add(progressBar1, BorderLayout.NORTH);
//		getContentPane().add(progressBar2, BorderLayout.WEST);
//		getContentPane().add(progressBar3, BorderLayout.EAST);
//		getContentPane().add(progressBar4, BorderLayout.SOUTH);
		setLayout(new GridLayout( 4, 1, 10, 10));
		getContentPane().add(progressBar1);
		getContentPane().add(progressBar2);
		getContentPane().add(progressBar3);
		getContentPane().add(progressBar4);
		progressBar1.setStringPainted(true);
		progressBar2.setStringPainted(true);
		progressBar3.setStringPainted(true);
		progressBar4.setStringPainted(true);
		t1 = new Thread(new MyThread(progressBar1));
		t2 = new Thread(new MyThread(progressBar2));
		t3 = new Thread(new MyThread(progressBar3));
		t4 = new Thread(new MyThread(progressBar4));
		setPriority("t1", 5, t1);
		setPriority("t2", 4, t2);
		setPriority("t3", 3, t3);
		setPriority("t4", 2, t4);
	}
	
	public static void setPriority(String threadName, int priority, Thread t){
		t.setPriority(priority);
		t.setName(threadName);
		t.start();
	}

	public static void main(String[] args) {
		init(new PriorityTest(), 500, 300);
	}
	
	public static void init(JFrame frame, int width, int height){
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}	
	
	private final class MyThread implements  Runnable {
		private final JProgressBar bar;
		int i;
		
		private MyThread(JProgressBar bar){
			this.bar = bar;
		}
		public void run() {
			while(true){
				bar.setValue(i+=10);
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println("进程中断");
				}
			}
		}
	}
}
