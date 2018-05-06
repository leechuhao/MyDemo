import java.util.*;
public class TestArgs {
//	private static final Integer ONE = new Integer(1);
	private static final int ONE = 1;
	public static void main (String [] args){
		Map<String,Integer> m = new HashMap<String,Integer>();
		for(int i = 0 ; i < args.length; i++ ){
//			Integer freq = (Integer) m.get(args[i]);
			int freq = m.get(args[i]) == null ? 0 : m.get(args[i]);
//			m.put(args[i],(freq == null ? ONE : new Integer(freq.intValue() + 1)));
			m.put(args[i],freq == 0 ? ONE : freq + 1);
		}
		System.out.println
			(m.size() + "distinct words detected:");
		System.out.println(m);
	}
}
