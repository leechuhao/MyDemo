public class Cat {
	private static int sid = 0 ;
	private String name;
	int id;
	Cat(String name){
		this.name = name;
		id = sid++;
	}
	public void info (){
		System.out.println("My name is " + name + " NO." + id);
	}
	public static void main (String []agrs){
		//Cat.sid = 100;
		Cat mimi = new Cat("mimi");
		Cat pipi = new Cat("pipi");
		mimi.info();
		pipi.info();
	}
}
