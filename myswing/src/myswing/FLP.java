package myswing;

import java.awt.*;
import javax.swing.*;

public class FLP extends JFrame{
	public FLP(){
		setTitle("Á÷²¼¾Ö");
		Container con = getContentPane();
		setLayout(new FlowLayout(1 ,10 ,10));		
		for(int i=0 ; i<10 ; i++){
			con.add(new Button("Button" + i));
		}
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FLP();
	}
}
