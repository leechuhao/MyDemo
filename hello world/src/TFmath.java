import java.awt.*;
import java.awt.event.*;

public class TFmath {
	public static void main(String[]args){
		new TFFrame1().launchFrame();
	}
}

class TFFrame1 extends Frame{
	TextField num1,num2,num3;
	public void launchFrame(){
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label lb = new Label("+");
		Button b1 = new Button("=");
//		b1.addActionListener(new MyMonitor(this));
		b1.addActionListener(new MyMonitor());
		setLayout(new FlowLayout());
		add(num1);
		add(lb);
		add(num2);
		add(b1);
		add(num3);
		pack();
		setVisible(true);
		this.addWindowListener(new MyWindowMonitor());
	}
	class MyMonitor implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int n1 = Integer.parseInt(num1.getText());
			int n2 = Integer.parseInt(num2.getText());
			num3.setText(String.valueOf(n1+n2));
		}
	}
	
	class MyWindowMonitor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			setVisible(false);
			System.exit(0);
		}
	}
}

/*class MyMonitor implements ActionListener{
	TextField num1,num2,num3;
	public MyMonitor(TextField num1,TextField num2,TextField num3){
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	TFFrame1 tf = null;
	public MyMonitor(TFFrame1 tf){
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e){
		int n1 = Integer.parseInt(tf.num1.getText());
		int n2 = Integer.parseInt(tf.num2.getText());
		tf.num3.setText(String.valueOf(n1+n2));
		//tf.num3.setText(" " + (n1+n2));
	}
}*/