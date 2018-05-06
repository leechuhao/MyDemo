package game1;
import javax.swing.*;

public class p6 {
	public static void main(String[] args){
		boolean cont = false;
		do{
			cont = false;
			String name[] = {"Define:\"Game\"","The Dungeon Defender","Regional Math-a-thon","National <ath-a-tgon" };
			int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
			String output = "The Name of the Game is :\n";
			output += name[element];
			JOptionPane.showMessageDialog(null, output);
			String repeat = JOptionPane.showInputDialog("Again?");
			if(repeat.equals("yes")){
				cont = true;
			}
		}while(cont);
	}
}
