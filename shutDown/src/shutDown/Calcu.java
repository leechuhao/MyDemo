package shutDown;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.swing.JOptionPane;

public class Calcu {
	public static void main(String[] args) throws IOException{
		StringReader in = new StringReader(read("Calcu.class"));
		
	}
	
	public static String read(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s ;
		StringBuffer sb = new StringBuffer();
		while((s = in.readLine()) != null){
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
}
