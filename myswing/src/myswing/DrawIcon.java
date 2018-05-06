package myswing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.*;

public class DrawIcon implements Icon{
	private int width;
	private int height;	
	
	public DrawIcon(int width , int height){
		this.width = width;
		this.height = height;
	}

	@Override
	public int getIconHeight() {
		return this.height;
	}

	@Override
	public int getIconWidth() {
		return this.width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.fillOval(x, y, width, height);		
	}
	
	public void testing( DrawIcon ic){		
//		JLabel jl = new JLabel("测试" , ic , SwingConstants.CENTER);
		JLabel jl = new JLabel("测试2");
		jl.setIcon(ic);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
//		URL url = new DrawIcon.class.getResource(null);
//		Icon ic = new ImageIcon(url);
//		jl.setOpaque(true);					//设置标签为不透明状态
		JFrame jf = new JFrame();
		Container con = jf.getContentPane();
		jf.add(jl);
		jf.setVisible(true);
		jf.setSize(120, 120);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DrawIcon ic = new DrawIcon(15 , 15);
		ic.testing(ic);
	}
	
	
}


