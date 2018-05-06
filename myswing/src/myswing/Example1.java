package myswing;

import java.awt.*;
import javax.swing.*;

public class Example1 extends JFrame{
	public void CreateJFrame(String title){
		JFrame jf = new JFrame(title);				
		Container con = jf.getContentPane();		//获取一个容器
		JLabel jl = new JLabel("这是一个JFrame窗口");//创建标签
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(jl);								//将标签加入到容器里
		con.setBackground(Color.white);
		
		jf.setSize(600, 450);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setResizable(false);
	}
	
	public static void main(String[] args) {
		new Example1().CreateJFrame("标题");
	}
	
}
