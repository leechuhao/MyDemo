import java.awt.*;
import java.awt.event.*;

public class Testawt {
	public static void main (String []args){
		MyFrame ff = new MyFrame("This a fuckable Frame",300,300,400,300);
		Button b1 = new Button("what the fuck!");
		Monitor bh = new Monitor();
		b1.addActionListener(bh);
		ff.add(b1);
	}
}

class MyFrame extends Frame{
	private Panel p1,p2,p3,p4;
	MyFrame (String s,int x,int y,int w,int h){
		super(s);
		setBackground(Color.YELLOW);
		setLayout(new FlowLayout(FlowLayout.LEFT,20,40));
		p1 = new Panel(null);		p2 = new Panel(null);
		p3 = new Panel(null);		p4 = new Panel(null);
		p1.setBounds(w/4,h/4,w/2,h/2);		p2.setBounds(0,h/2,w/2,h/2);
		p3.setBounds(w/2,0,w/2,h/2);		p4.setBounds(w/2,h/2,w/2,h/2);
		p1.setBackground(Color.BLUE);		p2.setBackground(Color.GREEN);
		p3.setBackground(Color.YELLOW);		p4.setBackground(Color.GRAY);
		add(p1);
//		add(p2);
//		add(p3);
//		add(p4);
		setBounds(x,y,w,h);
		setVisible(true);
	}
}

class Monitor implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("let's fuck this.");
	}
}
