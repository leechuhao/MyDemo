package myIO;

import java.io.*;

public class myBuffer {
	public static void main(String[] args) {
		String word[] = {"你好" , "吃了吗" , "再见"};
		File file = new File("bufferWord.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bfw = new BufferedWriter(fw);
			for(int i=0 ; i<word.length ; i++){
				bfw.write(word[i]);
				bfw.newLine();
			}
			bfw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(fr);
			
			for(int i=0 ; i<word.length ; i++){
				System.out.println("第 " + (i+1) + " 行: " + bfr.readLine());
			}
//			String s = null;
//			for(int i=0 ; (s=bfr.readLine()) != null ; i++){
//				System.out.println("第 " + (i+1) + " 行: " + s);
//			}
			bfr.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}	
	
}
