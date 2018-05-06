package learning;

public class StaticClass extends classA.classB{
	public StaticClass(classA a){
		a.super();
	}
	
	
	public static void main(String[] args) {
		classA a = new classA();
		new StaticClass(a);
	}
}
	
	class classA{
		class classB{
			
		}
	}
