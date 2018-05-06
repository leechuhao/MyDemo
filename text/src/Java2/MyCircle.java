package Java2;
	class Point{
		private double x;
		private double y;
		Point (double _x,double _y){
			x = _x;
			y = _y;
		}//创建圆点
	public double getx() {return x;}
	public double gety() {return y;}
	public void setx(double i){ x = i ;}
	public void sety(double i){ y = i ;}
	}
	
	class Circle{
		private Point o;
		private double r;
		Circle(Point p,double t){
			o = p;
			r = t;
		}//创建圆 全要素
		Circle(double t){
		r = t;
		o = new Point (0.0 , 0.0);
		}//重写 “创建圆”只有半径，圆心默认原点
		Circle (Point p){
			r = 1.0;
			o = p ;
		}//重写“创建圆”只有圆点，半径默认为1.0
		boolean contains(Point p){
			double x = p.getx() - o.getx();
			double y = p.gety() - o.gety();
			if( x * x + y * y > r * r )return false;
			else return true;
			}//两圆是否相离，若相离return false
		public void seto(double x, double y){
			o.setx( x );
			o.sety( y );
		}//重设圆点
		public Point geto() {return o;}
		public double getr(){return r;}
		public void setr(double t){r =t;}
		public double area(){
			return r*r*3.14;
		}//面积
		public double aroud(){
			return r * 2 * 3.14;
		}//周长
	}
public class MyCircle{
	public static void main (String []args){
		System.out.println("圆类的各种使用方法");
	}
}
	


