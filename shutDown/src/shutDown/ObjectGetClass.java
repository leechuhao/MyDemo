package shutDown;

public class ObjectGetClass {
	
	static void f(Character... args){
		System.out.println(args.getClass());
		System.out.println("length " + args.length);
	}

	static void g(int ... i){
		System.out.println(i.getClass());
		System.out.println("length " + i.length);
	}

	public static void main(String[] args) {
		System.out.println(args.length );
		f('a');
		f();
		g(1);
		g();
	}

}
