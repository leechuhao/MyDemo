package learning;

public class OutClass {
	InnerClass in = new InnerClass();
	public void ouf(){
		in.inf();
	}
	
	class InnerClass{
		InnerClass(){
		}
		public void inf(){
			System.out.println("This is inner inf");
		}
		int y = 0;
	}
	
	public InnerClass doit(){
		System.out.println("ʹ����doit��������in.y��ֵΪ1");
		in.y = 1;
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		OutClass out = new OutClass();
		InnerClass in = out.doit();
		InnerClass in2 = out.new InnerClass();
	}
}
