package game1;
import javax.swing.*;

public class g2 {
	public static void main(String[]args) throws Exception{
		
//		String input = JOptionPane.showInputDialog("What`s your name?");
//		//弹出输入框
//		System.out.printf("%s",input);
/////////////////////////////////////////////////////////////////////////////		
//		String input;
//		input = JOptionPane.showInputDialog("Enter the secret message:");
//		if(input.equals("ggsmd")){
//			System.out.println("u are right!!");
//		}
//		else{
//			System.out.println("gg思密达");
//		}
///////////////////////////////////////////////////////////////////////////////		
		int i,j,k,l = 0;
		i = (int)(Math.random()*4);
		j = (int)(Math.random()*10);
		k = (int)(Math.random()*10);
		System.out.println("\n\n");
		if(i==0){	
			System.out.println(j + "*" + k);
			l = j*k;
			}
		else if(i==1){
			System.out.println(j + "/" + k);
			l = j/k;
			}
		else if(i==2){
			System.out.println(j + "+" + k);
			l = j+k;
			}
		else if(i==3){
			System.out.println(j + "-" + k);
			l = j-k;
			}
		else if(i==4){	
			System.out.println(j + "%" + k);
			l = j%k;
			}
		System.out.println("**********************\n");
		System.out.println("3..........");
		Thread.sleep(1000);
		System.out.println("2..........");
		Thread.sleep(1000);
		System.out.println("1..........");
		Thread.sleep(1000);
		System.out.println("answer:" + l);
	}
}
