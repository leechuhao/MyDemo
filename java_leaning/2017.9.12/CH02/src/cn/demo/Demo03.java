
import java.util.Scanner;

public class Demo03
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("请输入第一个数:");
		double fn=input.nextDouble();		
		System.out.println("请输入第二个数:");
		double sn=input.nextDouble();
		System.out.println("请输入运  算  符:");
		String oper=input.next();
		double result=0;
		switch(oper)
		{
			case "+":
				result=fn+sn;
				System.out.println("运算结果是:"+result);
				break;
			case "-":
			    result=fn-sn;
			    System.out.println("运算结果是:"+result);
			    break;
			case "*":
			    result=fn*sn;
			    System.out.println("运算结果是:"+result);
			    break;
			case "/":
			    if(sn==0)
			    {
			    	System.out.println("除数不能为零");
			    }
			    else
			    {
			    	result=fn/sn;
				    System.out.println("运算结果是:"+result);
			    }
			   break;
			case "%":
				if(sn==0)
			    {
			    	System.out.println("除数不能为零");
			    }
			    else
			    {
			    	result=fn%sn;
				    System.out.println("运算结果是:"+result);
			    }
			    break;
		    default:
		    	System.out.println("运算符输入错误!");
		}
	}
}
