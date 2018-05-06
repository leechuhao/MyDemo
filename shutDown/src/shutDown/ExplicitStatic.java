package shutDown;

class Cup{
	Cup(int i){
		System.out.println("Cup(" + i + ")");
	}
	void f(int i){
		System.out.println("f(" + i + ")");
	}
}

class Cups{
	static Cup cup1;
	static Cup cup2;
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	Cups(){
		System.out.println("Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String []args){
		Cups.cup1.f(99);

//		static Cups cups1 = new Cups();
//		static Cups cups2 = new Cups();
//		这里不能用static
	}
}
