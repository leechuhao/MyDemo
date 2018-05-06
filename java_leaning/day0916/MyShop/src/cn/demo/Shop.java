package cn.demo;

import java.util.Scanner;

public class Shop
{
	/*
	 * �̳���
	 */
	Scanner input=new Scanner(System.in);
	User[] u=new User[10];//�洢�û���Ϣ
	Good[] g=new Good[10];//�洢��Ʒ��Ϣ
	Good[] good=new Good[10];//�洢�������Ʒ��Ϣ
	User user=null;
	//��ʼ������
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
		g[0].name="TCL42��Һ���ʵ�";
		g[0].place="China";
		g[0].price=4500;
		g[0].number=10;
		g[0].type="����";
		
		g[1].id=2;
		g[1].name="�����ӽ��ܱ���";
		g[1].place="Genmany";
		g[1].price=5000;
		g[1].number=5;
		g[1].type="����";
		
		g[2].id=3;
		g[2].name="PEAK3������Ь";
		g[2].place="China";
		g[2].price=500;
		g[2].number=10;
		g[2].type="����";
		
		g[3].id=4;
		g[3].name="NIKE3������Ь";
		g[3].place="USA";
		g[3].price=1000;
		g[3].number=10;
		g[3].type="����";
		
		g[4].id=5;
		g[4].name="�츻ʿƻ��";
		g[4].place="China";
		g[4].price=8;
		g[4].number=100;
		g[4].type="ˮ��";
		
		g[5].id=6;
		g[5].name="���߹�";
		g[5].place="USA";
		g[5].price=15;
		g[5].number=50;
		g[5].type="ˮ��";
	}
	//������չʾ
	public void show()
	{
		init();
		System.out.println("=============================================================================================");
		System.out.println("                                      ��ӭ���������̳�");		
		System.out.println("=============================================================================================");
		showGoodType();
	}
	//��Ʒ���ͺ�ѡ����Ϣ
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
				System.out.println("-----------------------------��Ʒ����--------------------------------");
				System.out.println("                             1.����");
				System.out.println("                             2.����");
				System.out.println("                             3.ˮ��");
				System.out.println("��ѡ��:");
				int m=input.nextInt();
				if(m==1)
				{
					type="����";
				}
				else if(m==2)
				{
					type="����";
				}
				else if(m==3)
				{
					type="ˮ��";
				}
				else
				{
					System.out.println("�������,����������!");
					an="y";
				}
			}while(an.equals("y"));
			String ans=null;
			do
			{
				showGood(type);
				System.out.println("��������Ҫ�������Ʒ���:");
				int num=input.nextInt();
				if(user==null)
				{
					System.out.println("����û�е�¼,���¼��ע����!");
					userView();
				}
				System.out.println("������Ҫ���������:");
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
				System.out.println("����Ҫ��������"+type+"��?");
				ans=input.next();
			}while(ans.equals("y"));
			System.out.println("����Ҫ����������?");
			answer=input.next();
		}while(answer.equals("y"));
	}
	//��Ʒ��Ϣ
	public void showGood(String type)
	{
		System.out.println("���\t����\tԭ����\t�۸�\t����");
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
		System.out.println("----------------------------�û���¼/ע����Ϣ-------------------------------");
		System.out.println("                                  1.��¼");
		System.out.println("                                  2.ע��");
		System.out.println("��ѡ��:");
		int m=input.nextInt();
		if(m==1)
		{
			login();
			if(user!=null)
			{
				System.out.println("��¼�ɹ�,��ӭ�û�"+user.username);
			}
		}
		else
		{
			register();
			if(user!=null)
			{
				System.out.println("ע��ɹ�,��ӭ���û�"+user.username);
			}
		}
	}
	
	public void login()
	{
		System.out.println("�������û���:");
		String name=input.next();
		System.out.println("��������     ��:");
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
		System.out.println("�������û���:");
		String name=input.next();
		System.out.println("��������     ��:");
		String pwd=input.next();
		System.out.println("�������     ��:");
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
