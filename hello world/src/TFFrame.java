import java.awt.*;
import java.awt.event.*;

public class TFFrame {
	public static void main(String []args){
		new TFrame();
	}
}

class TFrame extends Frame{
	TFrame(){
		TextField tf = new TextField();
		add(tf);
		tf.addActionListener(new TFActionListener());
//		tf.setEchoChar('*');//Òþ²Ø×Ö·û
		pack();
		setVisible(true);
//	----------------------------------------
		this.addWindowListener(
				new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
	});
//	-------------------------------------------
}

class TFActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
		}
	}
}
