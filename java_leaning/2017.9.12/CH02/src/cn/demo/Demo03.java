
import java.util.Scanner;

public class Demo03
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("�������һ����:");
		double fn=input.nextDouble();		
		System.out.println("������ڶ�����:");
		double sn=input.nextDouble();
		System.out.println("��������  ��  ��:");
		String oper=input.next();
		double result=0;
		switch(oper)
		{
			case "+":
				result=fn+sn;
				System.out.println("��������:"+result);
				break;
			case "-":
			    result=fn-sn;
			    System.out.println("��������:"+result);
			    break;
			case "*":
			    result=fn*sn;
			    System.out.println("��������:"+result);
			    break;
			case "/":
			    if(sn==0)
			    {
			    	System.out.println("��������Ϊ��");
			    }
			    else
			    {
			    	result=fn/sn;
				    System.out.println("��������:"+result);
			    }
			   break;
			case "%":
				if(sn==0)
			    {
			    	System.out.println("��������Ϊ��");
			    }
			    else
			    {
			    	result=fn%sn;
				    System.out.println("��������:"+result);
			    }
			    break;
		    default:
		    	System.out.println("������������!");
		}
	}
}
