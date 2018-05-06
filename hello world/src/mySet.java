import java.util.*;
//set容器是无序的、不重复的
public class mySet {
	public static void main (String [] args){
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a");s1.add("b");s1.add("c");
		s2.add("d");s2.add("a");s2.add("b");
		Set sn = new HashSet(s1);
		sn.retainAll(s2);
		Set su = new HashSet(s2);
		su.addAll(s1);
		System.out.println(sn);
		System.out.println(su);;
	}
}
