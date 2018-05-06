package Java4;

import java.awt.*;
import java.awt.event.*;

public class Test4_1 {
	public static void main (String []args){
		new MyFrame().launchFrame();;
	}
}

class MyFrame extends Frame{
	String s = "�밴��ť";
	Label lb = new Label(s);
	Button b1 = new Button("���");
	public void launchFrame(){
		b1.addActionListener(new MyMonitor());
		setLayout(new FlowLayout());
		add(b1);add(lb);
		setBounds(300,300,300,100);
		setVisible(true);
		this.addWindowListener(new MyWindowMonitor());
	}
	class MyMonitor implements ActionListener{
		public void actionPerformed(ActionEvent e){
			s = e.getActionCommand();
			lb.setText(s);
			if(s == "�ټ�")s = "���";
			else /*if(s == "���")*/s = "�ټ�";
			b1.setLabel(s);
		}
	}
	
	class MyWindowMonitor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			setVisible(false);
			System.exit(0);
		}
	}
}
