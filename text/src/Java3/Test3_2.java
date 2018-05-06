package Java3;

public class Test3_2 {
	public static void main (String []args){
		 
	}
}

abstract class Shape{
	String name = null;
	public void Shape(String n){name = n;}
	public double GetArea(){return 0;}
	public double GetLength(){return 0;}
}

final class Circle extends Shape{
	double radius ;
	public Circle(double r) {this.radius = r;}
	public double GetArea(){
		if(radius <= 0)return -1;
		return radius*radius*3.14;
		}
	public double GetLength(){
		if(radius <= 0)return -1;
		return radius*2*3.14;
		}
}

final class Rectangle extends Shape{
	double length ;double width ;
	public Rectangle (double l,double w){length = l;width = w;}
	public double GetArea(){
		if(this.length <= 0||this.width <= 0)return -1;
		return length*width;
		}
	public double GetLength(){
		if(this.length <= 0||this.width <= 0)return -1;
		return (length+width)*2;
		}
}

