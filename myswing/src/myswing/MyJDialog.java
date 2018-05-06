package myswing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MyJDialog extends JDialog{
	public MyJDialog(MyFrame frame){
		super(frame , "dialog窗口" , true);
		Container con = getContentPane();
		con.add(new JLabel("对话框"));
		setBounds(120,120,120,120);
	}
}

class MyFrame extends JFrame{
	public static void main(String[] args) {
		new MyFrame();
	}
	
	public  MyFrame(){
		Container con = getContentPane();
		con.setLayout(null);
		JLabel jl = new JLabel("JFrame窗口");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		con.add(jl);
		JButton jb = new JButton("按钮");
		jb.setBounds(10,10,100,21);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new MyJDialog(MyFrame.this).setVisible(true);
			}
		});
		con.add(jb);
		jl.setVisible(true);
		jl.setSize(600, 450);
		
	}
}

