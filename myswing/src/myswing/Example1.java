package myswing;

import java.awt.*;
import javax.swing.*;

public class Example1 extends JFrame{
	public void CreateJFrame(String title){
		JFrame jf = new JFrame(title);				
		Container con = jf.getContentPane();		//��ȡһ������
		JLabel jl = new JLabel("����һ��JFrame����");//������ǩ
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(jl);								//����ǩ���뵽������
		con.setBackground(Color.white);
		
		jf.setSize(600, 450);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setResizable(false);
	}
	
	public static void main(String[] args) {
		new Example1().CreateJFrame("����");
	}
	
}
