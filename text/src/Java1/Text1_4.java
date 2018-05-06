package Java1;
import java.util.Scanner;

public class Text1_4 {
	static int i=0,j=0,t=0;
	public static void main (String args[]){
		int a[]=new int[10];
		Scanner sc = new Scanner(System.in);//ÊäÈëÊı×Ö
		for(i=0;i<10;i++)a[i] = sc.nextInt();
		for(i=0;i<9;i++){
			for(j=0;j<9;j++){
				if(a[j]>a[j+1])
				{t=a[j];a[j]=a[j+1];a[j+1]=t;}
				}
			}
		for(i=0;i<10;i++)
			System.out.print(a[i]+"  ");
	}
}
