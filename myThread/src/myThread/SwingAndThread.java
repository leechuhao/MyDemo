package myThread;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class SwingAndThread extends JFrame{
	private JLabel jl = new JLabel( );
	private static Thread t;
	private int count = 0;
	private Container  container = getContentPane();
	
	public SwingAndThread() throws MalformedURLException{
		setBounds(300, 200, 250, 100);
		container.setLayout(null);
		URL url1 = SwingAndThread.class.getResource("0.gif");
//		URL url = new URL("http://img.lanrentuku.com/img/allimg/1212/5-121204193R0-50.gif");
		Icon icon = new ImageIcon(url1);
		jl.setIcon(icon);
		jl.setHorizontalAlignment(SwingConstants.LEFT);//讲图片设置在标签最左
		jl.setBounds(10, 10, 200, 50);
		jl.setOpaque(true);//True不会露出底层像素？？？？
		
		t = new Thread(new Runnable(){
			public void run(){
				while(count <= 200){
					jl.setBounds(count, 10, 200, 50);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace( );
						// TODO: handle exception
					}
					count += 4;
					if(count == 200){
						count =10;
					}
				}
			}
		});
		t.start();//////////////////////////////
		
		container.add(jl);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		try {
			new SwingAndThread();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	
}
