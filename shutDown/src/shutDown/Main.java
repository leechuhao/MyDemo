package shutDown;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int leng = in.nextInt();
		List<Integer> num = new ArrayList<Integer>();
		for(int i=0; i<leng ; i++){
			num.add(in.nextInt());
		}
		ssort(num);
		for(int i=0; i<leng ; i++){
			System.out.println(num);
		}
	}
	
	public static void ssort(List<Integer> num){
//		for(int i : )
	}
}
