
public class Ccircle{
	protected static double x=0,y=0; 
	protected static double r=1;	
	public static void Creat(double d,double e){
		x=d;
		y=e;
	}//��������
	public static double Area(){
		return r*r*2*3.14;
	}//���
	public static void Reset(double i,double j,double k){
		x=i;
		y=j;
		r=k;
	}//����
	public static double Perimeter(){
		return r*2*3.14;
	}//�ܳ�
	public static void Getcircle(){
		System.out.println("Բ������Ϊ"+x+","+y);
		System.out.println("�뾶Ϊ"+r);
		System.out.println("�ܳ�Ϊ"+Ccircle.Perimeter());
		System.out.println("���Ϊ"+Ccircle.Area());
	}//��ʾ����
	
}
