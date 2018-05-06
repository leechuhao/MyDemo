package myReflect;

public class Demo1 {
	String s;
	int i ,i1 ,i2;
	
	private Demo1(){
		
	}
	
	protected  Demo1(String s , int i) {
		this.s = s;
		this.i = i;
	}
	
	public Demo1(String...strings) throws NumberFormatException{
		if(0 < strings.length){
			i = Integer.valueOf(strings[0]);
		}
		if(1 < strings.length){
			i1 = Integer.valueOf(strings[1]);
		}
		if(2 < strings.length){
			i2 = Integer.valueOf(strings[2]);
		}
	}
	
	public void print(){
		System.out.println("s=" + s);
		System.out.println("i=" + i);
		System.out.println("i1=" + i1);
		System.out.println("i2=" + i2);
	}
	
	
}
