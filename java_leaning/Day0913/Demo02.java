import java.util.Scanner;
public class Demo02
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int[] a=new int[5];
		for(int i=0;i<5;i++)
		{
			System.out.println("�������"+(i+1)+"������:");
			a[i]=input.nextInt();
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4-i;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("�����:");
		for(int i=0;i<5;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}