package Java2;
	class Point{
		private double x;
		private double y;
		Point (double _x,double _y){
			x = _x;
			y = _y;
		}//����Բ��
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
		}//����Բ ȫҪ��
		Circle(double t){
		r = t;
		o = new Point (0.0 , 0.0);
		}//��д ������Բ��ֻ�а뾶��Բ��Ĭ��ԭ��
		Circle (Point p){
			r = 1.0;
			o = p ;
		}//��д������Բ��ֻ��Բ�㣬�뾶Ĭ��Ϊ1.0
		boolean contains(Point p){
			double x = p.getx() - o.getx();
			double y = p.gety() - o.gety();
			if( x * x + y * y > r * r )return false;
			else return true;
			}//��Բ�Ƿ����룬������return false
		public void seto(double x, double y){
			o.setx( x );
			o.sety( y );
		}//����Բ��
		public Point geto() {return o;}
		public double getr(){return r;}
		public void setr(double t){r =t;}
		public double area(){
			return r*r*3.14;
		}//���
		public double aroud(){
			return r * 2 * 3.14;
		}//�ܳ�
	}
public class MyCircle{
	public static void main (String []args){
		System.out.println("Բ��ĸ���ʹ�÷���");
	}
}
	


