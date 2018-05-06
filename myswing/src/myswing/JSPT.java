package myswing;

import java.awt.*;
import javax.swing.*;

public class JSPT extends JFrame{
	public JSPT(){
		Container con = getContentPane();
		JTextArea ta = new JTextArea(20	,20);
		JScrollPane sp = new JScrollPane(ta);
		con.add(sp);
		setTitle("有滚动条的文字编辑器");
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSPT();
	}
}
