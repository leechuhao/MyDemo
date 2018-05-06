package shutDown;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int count = 0;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(machine(i, Integer.MAX_VALUE));
		
	}
	
	static int machine(int s, int lm) {
		int m=0;
		//m=s的最大因子
		if(s == 1)	return 0;
		for(int i=1; (i<s)&(i<=lm); i++){
			if(s%i == 0) m = i;
		}
//		System.out.println("1");
		return machine(s-m, m)+1;
	}
	
}
