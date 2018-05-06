
public class Ccircle{
	protected static double x=0,y=0; 
	protected static double r=1;	
	public static void Creat(double d,double e){
		x=d;
		y=e;
	}//创建对象
	public static double Area(){
		return r*r*2*3.14;
	}//面积
	public static void Reset(double i,double j,double k){
		x=i;
		y=j;
		r=k;
	}//重置
	public static double Perimeter(){
		return r*2*3.14;
	}//周长
	public static void Getcircle(){
		System.out.println("圆心坐标为"+x+","+y);
		System.out.println("半径为"+r);
		System.out.println("周长为"+Ccircle.Perimeter());
		System.out.println("面积为"+Ccircle.Area());
	}//显示参数
	
}
