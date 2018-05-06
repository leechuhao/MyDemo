package cn.bean;

import java.util.Scanner;

public class Shop {
	/*
	 * 用类作为数组的数据类型,那么数组中的每个元素都是这个类的对象,但是没有实例化
	 */
	Scanner input=new Scanner(System.in);
	String username=null;//用于存储登录成功或注册成功的用户
	User[] u=new User[10];//此属性为数组,用于存储用户信息
	Good[] g=new Good[10];//此属性为数组,用于存储商品信息
	
	Good[] good=new Good[100];//用于存储购买的商品
	//初始化
	public void init()
	{
		for(int i=0;i<10;i++)
		{
			u[i]=new User();
			g[i]=new Good();
		}
		
		u[0].id=1001;
		u[0].name="admin";
		u[0].password="123456";
		u[0].money=1000;
		
		g[0].id=1;
		g[0].name="TCL42吋液晶彩电";
		g[0].place="CHINA";
	}
	
	public void show()
	{
		init();
		System.out.println("=============================================================================");
        System.out.println("                             欢迎来到贵美商城");
        System.out.println("=============================================================================");
        System.out.println("                              --商品类型--");
        System.out.println("                                 1.电器");
        System.out.println("                                 2.服饰");	
        System.out.println("                                 3.水果");
		System.out.println("请选择:");
		int num=input.nextInt();
		String type=null;
		switch(num)
		{
			case 1:
				  type="电器";
				  break;
			case 2:
				  type="服饰";
				  break;
			case 3:
				  type="水果";
				  break;
			default:
				  System.out.println("输入错误!");
		}
		showGood(type);//显示查询的商品
		System.out.println("请输入要购买的商品类型:");
		int m=input.nextInt();
		if(username==null)
		{
			System.out.println("您还没有登录,请登录或注册先!");
			System.out.println("--------------------------------------------------------------");
			System.out.println("                           1.登录");
			System.out.println("                           2.注册");
			System.out.println("请选择:");
			int n=input.nextInt();
			if(n==1)
			{
				login();
			}
			else if(n==2)
			{
				register();
			}
			else
			{
				System.out.println("输入错误,请重新选择");
			}
		}
	}
	//通过类型商品
	public void showGood(String type)
	{
		for(int i=0;i<10;i++)
		{
			if(g[i].id!=0)
			{
				if(g[i].type.equals(type))
				{
					
				}
			}
		}
	}
	//登录的方法
	public void login()
	{
		System.out.println("请输入用户名:");
		String uname=input.next();
		System.out.println("请输入密    码:");
		String upwd=input.next();
		for(int i=0;i<10;i++)
		{
			if(u[i].id!=0)
			{
				if(u[i].name.equals(uname)&&u[i].password.equals(upwd))
				{
					System.out.println("登录成功,欢迎用户"+uname);
					username=uname;
					break;
				}
			}
		}
	}
	//注册的方法
	public void register()
	{
		System.out.println("请输入用户名:");
		String uname=input.next();
		System.out.println("请输入密    码:");
		String upwd=input.next();
		System.out.println("请输入金    额:");
		double mon=input.nextDouble();
		for(int i=0;i<10;i++)
		{
			if(u[i].id==0)
			{
				u[i].id=u[i-1].id+1;
				u[i].name=uname;
				u[i].password=upwd;
				u[i].money=mon;
				break;
			}
		}
	}
}
