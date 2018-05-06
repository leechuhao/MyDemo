import java.util.Scanner;
public class Demo01
{
	public static void main(String[] args)
	{
		/*
		 *实现指定行数的菱形
		 *冒泡算法
		 */
		Scanner input=new Scanner(System.in);
		String an=null;
		do
		{
			System.out.println("请输入菱形的行数:");
			int num=input.nextInt();
			if(num%2==0)
			{
				System.out.println("输入错误,菱形只能是奇数!");
			}
			else
			{
				int a=num/2+1;
				for(int i=1;i<=a;i++)
				{
					for(int k=1;k<=a-i;k++)
					{	
						System.out.print(" ");
					}
					for(int j=1;j<=2*i-1;j++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				int b=num-a;
				for(int i=1;i<=b;i++)
				{
					for(int k=1;k<=i;k++)
					{	
						System.out.print(" ");
					}
					for(int j=1;j<=num-2*i;j++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
			}
			System.out.println("请问要继续吗?");
			an=input.next();
		}while(an.equals("y"));
	}
}