package shutDown;

import java.util.Scanner;

public class MagicCoin {
	public void machine(int i){
		if (i == 0){
			System.out.print("");
		}else if(i%2 == 0){
				machine(i/2 -1);
				System.out.print("2");
			}else{
				machine((i-1)/2);
				System.out.print("1");
			}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		MagicCoin mc = new MagicCoin();
		mc.machine(i);
	}
}
