

import java.util.Scanner;

public class Demo02
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("请问您进入百米决赛了吗?(y/n)");
		String an=input.next();
		if(an.equals("y"))
		{
			System.out.println("请输入您的性别:(男/女)");
			String sex=input.next();
			System.out.println("请输入您的预赛时间:");
			double time=input.nextDouble();
			if((sex.equals("男")&&time<13)||(sex.equals("女")&&time<15))
			{
				System.out.println("恭喜您进入决赛,您被分在"+sex+"子组");
			}
			else
			{
				System.out.println("你并没有进入决赛,where cold,where to stay!");
			}
		}
		else
		{
			System.out.println("谢谢参与,友谊第一,比赛第二!");
		}
	}
}
