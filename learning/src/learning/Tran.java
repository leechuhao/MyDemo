package learning;

public class Tran {
	static int avg(int number1 , int number2) throws Myexception{
		if(number1<0 || number2<0){
			throw new Myexception("����ʹ�ø���������");
		}
		
		if(number1>100 || number2>100){
			throw new Myexception("��ֵ����100������");
		}
		return (number1 + number2)/2 ;
	}
	
	public static void main(String[] args) {
		try{
			int result = avg(10,51);
			System.out.println(result);
		}catch(Myexception e){
			System.out.println(e);
		}
	}
}
