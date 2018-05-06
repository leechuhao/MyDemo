package game1;
import javax.swing.*;

public class p8 {
	public static void main(String[] args){
		int guess = -1;
		int count = 0;
		int num =(int)(Math.random() * 100);
		do{
			guess = Integer.parseInt(JOptionPane.showInputDialog("guess a number between 0 and 100"));
			if(guess > num){
				JOptionPane.showMessageDialog(null, "Too hign");
			}
			if(guess < num){
				JOptionPane.showMessageDialog(null, "Too low");
			}
			count++;				
		}while(num != guess);
		JOptionPane.showMessageDialog(null, "You guessed the number ---" + num + "---in " + count + " guess(es)!!!");
	}
}
