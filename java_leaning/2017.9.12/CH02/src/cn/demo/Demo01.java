

import java.util.Scanner;

public class Demo01 
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		/*
		 * 如果运算符输入错误,是否可以给机会继续输入新的运算符
		 */
		Scanner input=new Scanner(System.in);
		System.out.println("请输入第一个数:");
		double fn=input.nextDouble();		
		System.out.println("请输入第二个数:");
		double sn=input.nextDouble();
		System.out.println("请输入运  算  符:");
		String oper=input.next();
		double result=0;
		if(oper.equals("+"))
		{
			result=fn+sn;
			System.out.println("运算结果是:"+result);
		}
		else if(oper.equals("-"))
		{
			result=fn-sn;
			System.out.println("运算结果是:"+result);
		}
		else if(oper.equals("*"))
		{
			result=fn*sn;
			System.out.println("运算结果是:"+result);
		}
		else if(oper.equals("/"))
		{
			if(sn==0)
			{
				System.out.println("除数不嗯呢该为零!");
			}
			else
			{
				result=fn/sn;
				System.out.println("运算结果是:"+result);
			}
		}
		else if(oper.equals("%"))
		{
			if(sn==0)
			{
				System.out.println("除数不嗯呢该为零!");
			}
			else
			{
				result=fn%sn;
				System.out.println("运算结果是:"+result);
			}
		}
		else
		{
			System.out.println("运算符输入错误!");
		}
	}
}
