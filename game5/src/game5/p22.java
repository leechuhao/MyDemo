package game5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class p22 extends JFrame implements ActionListener{
	JButton spots[] = new JButton[9];
	int turn = 1;
	ImageIcon red = new ImageIcon("red.png");
	ImageIcon blue = new ImageIcon("blue.png");
	ImageIcon blank = new ImageIcon("blank.png");
	
	public p22(){
		super("井字棋");
		setSize(315,340);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		Container con = getContentPane();
		con.setLayout(null);
		//
		int newLine = 0;
		int lineCount = 0;
		for(int i = 0 ; i < spots.length ; i++){
			spots[i] = new JButton(blank);
			//
			if(i == 3 || i ==6){
				newLine++;
				lineCount = 0;
			}
			//
			spots[i].setBounds(lineCount * 100, newLine * 100, 100, 100);
			con.add(spots[i]);
			//
			spots[i].addActionListener(this);
			lineCount++;
		}
	}
	
	public void reset(){
		for(int i = 0 ; i < spots.length ; i++){
			spots[i].setIcon(blank);
			spots[i].addActionListener(this);
		}
		turn = 1;
	}
	
	public void actionPerformed(ActionEvent e){
		//
		for(int i = 0 ; i <= spots.length ; i++){
			if(e.getSource() == spots[i]){
				if(turn % 2 ==0){
					spots[i].setIcon(red);
				}else{
					spots[i].setIcon(blue);
				}
				//
				spots[i].removeActionListener(this);
				break;
			}			
		}
		turn++;
		checkWin();
	}
	
	public void checkWin(){
		int draw = 0;
		
		for(int i =0 ; i < 3 ; i++){
			//垂直
			if(spots[i].getIcon().equals(red) && 
					spots[i + 3].getIcon().equals(red) && 
					spots[i +6].getIcon().equals(red)){
				JOptionPane.showMessageDialog(null, "red WIN");
				reset();
				break;
			}
			//
			if(spots[i].getIcon().equals(blue) && 
					spots[i + 3].getIcon().equals(blue) && 
					spots[i +6].getIcon().equals(blue)){
				JOptionPane.showMessageDialog(null, "blue WIN");
				reset();
				break;
			}
			//水平
			if(spots[i * 3].getIcon().equals(red) &&
					spots[(i * 3) + 1].getIcon().equals(red) &&
					spots[(i * 3) + 2].getIcon().equals(red)){
				JOptionPane.showMessageDialog(null, "red WIN");
				reset();
				break;
			}
			//
			if(spots[i * 3].getIcon().equals(blue) &&
					spots[(i * 3) + 1].getIcon().equals(blue) &&
					spots[(i * 3) + 2].getIcon().equals(blue)){
				JOptionPane.showMessageDialog(null, "blue WIN");
				reset();
				break;
			}
		}
		//对角线
		for(int i = 0 ; i < 3 ; i += 2){
			//
			if(spots[i].getIcon().equals(red) &&
					spots[4].getIcon().equals(red) &&
					spots[8 - i].getIcon().equals(red)){
				JOptionPane.showMessageDialog(null, "red WIN");
				reset();
				break;
			}
			//
			if(spots[i].getIcon().equals(blue) &&
					spots[4].getIcon().equals(blue) &&
					spots[8 - i].getIcon().equals(blue)){
				JOptionPane.showMessageDialog(null, "blue WIN");
				reset();
				break;
			}
		}
		//平局
		for(int i = 0 ; i < spots.length ; i++){
			if(spots[i].getIcon().equals(blank)){
				draw++;
			}
		}
		if(draw == 0){
			JOptionPane.showMessageDialog(null, "draw!!!!!!!!!!!!");
			reset();
		}
	}
	
	public static void main (String[] args){
		p22 t = new p22();
	}

}
