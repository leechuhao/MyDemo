

import java.util.Scanner;

public class Demo02
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("������������׾�������?(y/n)");
		String an=input.next();
		if(an.equals("y"))
		{
			System.out.println("�����������Ա�:(��/Ů)");
			String sex=input.next();
			System.out.println("����������Ԥ��ʱ��:");
			double time=input.nextDouble();
			if((sex.equals("��")&&time<13)||(sex.equals("Ů")&&time<15))
			{
				System.out.println("��ϲ���������,��������"+sex+"����");
			}
			else
			{
				System.out.println("�㲢û�н������,where cold,where to stay!");
			}
		}
		else
		{
			System.out.println("лл����,�����һ,�����ڶ�!");
		}
	}
}
