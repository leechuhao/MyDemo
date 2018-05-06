package game1;
import javax.swing.JOptionPane;
import java.util.*;

public class p6second {
	public static void main(String[] args){
		ArrayList games = new ArrayList();
		boolean cont = false;
		do{
			cont = false;
			int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter\n" + "1 to add new gmae\n" + "2 to access games"));
			if(choice == 1){
				String name;
				name = JOptionPane.showInputDialog("Game name?");
				games.add(name);
			}
			if(choice == 2){
				int element = Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
				String output = "The Name of the Game is :\n";
				output += ((String)games.get(element));
				JOptionPane.showMessageDialog(null, output);
			}
			String repeat = JOptionPane.showInputDialog("Again?");
			if(repeat.equals("yes")){
				cont = true;
			}
		}while(cont);
	}
}

