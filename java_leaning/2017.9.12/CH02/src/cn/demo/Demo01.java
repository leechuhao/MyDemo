

import java.util.Scanner;

public class Demo01 
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		/*
		 * ���������������,�Ƿ���Ը�������������µ������
		 */
		Scanner input=new Scanner(System.in);
		System.out.println("�������һ����:");
		double fn=input.nextDouble();		
		System.out.println("������ڶ�����:");
		double sn=input.nextDouble();
		System.out.println("��������  ��  ��:");
		String oper=input.next();
		double result=0;
		if(oper.equals("+"))
		{
			result=fn+sn;
			System.out.println("��������:"+result);
		}
		else if(oper.equals("-"))
		{
			result=fn-sn;
			System.out.println("��������:"+result);
		}
		else if(oper.equals("*"))
		{
			result=fn*sn;
			System.out.println("��������:"+result);
		}
		else if(oper.equals("/"))
		{
			if(sn==0)
			{
				System.out.println("���������ظ�Ϊ��!");
			}
			else
			{
				result=fn/sn;
				System.out.println("��������:"+result);
			}
		}
		else if(oper.equals("%"))
		{
			if(sn==0)
			{
				System.out.println("���������ظ�Ϊ��!");
			}
			else
			{
				result=fn%sn;
				System.out.println("��������:"+result);
			}
		}
		else
		{
			System.out.println("������������!");
		}
	}
}
