package cn.demo;

import java.util.Scanner;

public class Shop
{
	/*
	 * 商城类
	 */
	Scanner input=new Scanner(System.in);
	User[] u=new User[10];//存储用户信息
	Good[] g=new Good[10];//存储商品信息
	Good[] good=new Good[10];//存储购买的商品信息
	User user=null;
	//初始化数据
	public void init()
	{
		for(int i=0;i<10;i++)
		{
			u[i]=new User();
			g[i]=new Good();
			good[i]=new Good();
		}
		
		u[0].id=1001;
		u[0].username="admin";
		u[0].password="123456";
		u[0].money=1000;
		
		u[1].id=1002;
		u[1].username="root";
		u[1].password="123456";
		u[1].money=2000;
		
		g[0].id=1;
		g[0].name="TCL42吋液晶彩电";
		g[0].place="China";
		g[0].price=4500;
		g[0].number=10;
		g[0].type="电器";
		
		g[1].id=2;
		g[1].name="西门子节能冰箱";
		g[1].place="Genmany";
		g[1].price=5000;
		g[1].number=5;
		g[1].type="电器";
		
		g[2].id=3;
		g[2].name="PEAK3代篮球鞋";
		g[2].place="China";
		g[2].price=500;
		g[2].number=10;
		g[2].type="服饰";
		
		g[3].id=4;
		g[3].name="NIKE3代篮球鞋";
		g[3].place="USA";
		g[3].price=1000;
		g[3].number=10;
		g[3].type="服饰";
		
		g[4].id=5;
		g[4].name="红富士苹果";
		g[4].place="China";
		g[4].price=8;
		g[4].number=100;
		g[4].type="水果";
		
		g[5].id=6;
		g[5].name="红蛇果";
		g[5].place="USA";
		g[5].price=15;
		g[5].number=50;
		g[5].type="水果";
	}
	//主界面展示
	public void show()
	{
		init();
		System.out.println("=============================================================================================");
		System.out.println("                                      欢迎来到贵美商城");		
		System.out.println("=============================================================================================");
		showGoodType();
	}
	//商品类型和选择信息
	public void showGoodType()
	{
		String an=null;
		String type=null;
		String answer=null;
		do
		{
			do
			{
				an="n";
				System.out.println("-----------------------------商品类型--------------------------------");
				System.out.println("                             1.电器");
				System.out.println("                             2.服饰");
				System.out.println("                             3.水果");
				System.out.println("请选择:");
				int m=input.nextInt();
				if(m==1)
				{
					type="电器";
				}
				else if(m==2)
				{
					type="服饰";
				}
				else if(m==3)
				{
					type="水果";
				}
				else
				{
					System.out.println("输入错误,请重新输入!");
					an="y";
				}
			}while(an.equals("y"));
			String ans=null;
			do
			{
				showGood(type);
				System.out.println("请输入您要购买的商品编号:");
				int num=input.nextInt();
				if(user==null)
				{
					System.out.println("您还没有登录,请登录或注册先!");
					userView();
				}
				System.out.println("请输入要购买的数量:");
				int n=input.nextInt();
				for(int i=0;i<10;i++)
				{
					if(g[i].id==num)
					{
						if(good[i].name==null)
						{
							good[i]=g[i];
							good[i].number=n;
							g[i].number=g[i].number-n;
							break;
						}
					}
				}
				System.out.println("请问要继续购买"+type+"吗?");
				ans=input.next();
			}while(ans.equals("y"));
			System.out.println("请问要继续购物吗?");
			answer=input.next();
		}while(answer.equals("y"));
	}
	//商品信息
	public void showGood(String type)
	{
		System.out.println("编号\t名称\t原产地\t价格\t数量");
		for(int i=0;i<10;i++)
		{
			if(g[i].id!=0&&g[i].type.equals(type))
			{
				System.out.println(g[i].id+"\t"+g[i].name+"\t"+g[i].place+"\t"+g[i].price+"\t"+g[i].number);
			}
		}
	}
	
	public void userView()
	{
		System.out.println("----------------------------用户登录/注册信息-------------------------------");
		System.out.println("                                  1.登录");
		System.out.println("                                  2.注册");
		System.out.println("请选择:");
		int m=input.nextInt();
		if(m==1)
		{
			login();
			if(user!=null)
			{
				System.out.println("登录成功,欢迎用户"+user.username);
			}
		}
		else
		{
			register();
			if(user!=null)
			{
				System.out.println("注册成功,欢迎新用户"+user.username);
			}
		}
	}
	
	public void login()
	{
		System.out.println("请输入用户名:");
		String name=input.next();
		System.out.println("请输入密     码:");
		String pwd=input.next();
		for(int i=0;i<10;i++)
		{
			if(u[i].id!=0)
			{
				if(u[i].username.equals(name)&&u[i].password.equals(pwd))
				{
					user=u[i];
					break;
				}
			}
		}
	}
	
	public void register()
	{
		System.out.println("请输入用户名:");
		String name=input.next();
		System.out.println("请输入密     码:");
		String pwd=input.next();
		System.out.println("请输入金     额:");
		double money=input.nextDouble();
		for(int i=0;i<10;i++)
		{
			if(u[i].id==0)
			{
				u[i].id=u[i-1].id+1;
				u[i].username=name;
				u[i].password=pwd;
				u[i].money=money;
				user=u[i];
				break;
			}
		}
	}
}
