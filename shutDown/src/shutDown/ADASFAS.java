package shutDown;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ADASFAS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int[] num = new int[a];
		for(int i=0 ; i<a ; i++){
			num[i] = in.nextInt();
		}
//		int[] c = {1, 5, 3, 3, 4, 2};
//		num = c;
		System.out.println(ssort(b, num));
	}
	
	public static int ssort(int b,int[]num){
		Arrays.sort(num);
		HashSet<HashSet<Integer>> hhs = new HashSet<>();
		List<Integer> list = new ArrayList<Integer>(); 
		for(int i=0 ; i<num.length; i++){
			list.add(num[i]);
			System.out.print(num[i]);
		}
	    for (int i=0; i<list.size(); i++) {  
	    	Integer high = list.get(i)+b,  small = list.get(i)-b;
	    	for(int j=0 ; j<list.size() ; j++){
				if(list.get(j).equals(high) ){
					HashSet<Integer> hs = new HashSet<>();
					hs.add(list.get(i));
					hs.add(list.get(j));
					hhs.add(hs);
				}
				if(list.get(j).equals(small)){
					HashSet<Integer> hs = new HashSet<>();
					hs.add(list.get(i));
					hs.add(list.get(j));
					hhs.add(hs);
				}
			}
	    }  
	    System.out.println(hhs);
	    return hhs.size();
	}
}
