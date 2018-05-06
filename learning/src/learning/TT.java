package learning;

import javax.swing.JOptionPane;

public class TT {
	public static void add(){
		double a = 0 ,b = 0 ,c = 0;
		a = Double.parseDouble(JOptionPane.showInputDialog("Please enter a"));
		b = Double.parseDouble(JOptionPane.showInputDialog("Please enter b"));
		c = a + b;
		JOptionPane.showMessageDialog(null, "c = a + b = " + a + " + " + b + " = " + c);
	}
	
	public static void main(String[] args) {
		add();
	}
 
}
