package cn.bean;

import java.util.Scanner;

public class Shop {
	/*
	 * ������Ϊ�������������,��ô�����е�ÿ��Ԫ�ض��������Ķ���,����û��ʵ����
	 */
	Scanner input=new Scanner(System.in);
	String username=null;//���ڴ洢��¼�ɹ���ע��ɹ����û�
	User[] u=new User[10];//������Ϊ����,���ڴ洢�û���Ϣ
	Good[] g=new Good[10];//������Ϊ����,���ڴ洢��Ʒ��Ϣ
	
	Good[] good=new Good[100];//���ڴ洢�������Ʒ
	//��ʼ��
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
		g[0].name="TCL42��Һ���ʵ�";
		g[0].place="CHINA";
	}
	
	public void show()
	{
		init();
		System.out.println("=============================================================================");
        System.out.println("                             ��ӭ���������̳�");
        System.out.println("=============================================================================");
        System.out.println("                              --��Ʒ����--");
        System.out.println("                                 1.����");
        System.out.println("                                 2.����");	
        System.out.println("                                 3.ˮ��");
		System.out.println("��ѡ��:");
		int num=input.nextInt();
		String type=null;
		switch(num)
		{
			case 1:
				  type="����";
				  break;
			case 2:
				  type="����";
				  break;
			case 3:
				  type="ˮ��";
				  break;
			default:
				  System.out.println("�������!");
		}
		showGood(type);//��ʾ��ѯ����Ʒ
		System.out.println("������Ҫ�������Ʒ����:");
		int m=input.nextInt();
		if(username==null)
		{
			System.out.println("����û�е�¼,���¼��ע����!");
			System.out.println("--------------------------------------------------------------");
			System.out.println("                           1.��¼");
			System.out.println("                           2.ע��");
			System.out.println("��ѡ��:");
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
				System.out.println("�������,������ѡ��");
			}
		}
	}
	//ͨ��������Ʒ
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
	//��¼�ķ���
	public void login()
	{
		System.out.println("�������û���:");
		String uname=input.next();
		System.out.println("��������    ��:");
		String upwd=input.next();
		for(int i=0;i<10;i++)
		{
			if(u[i].id!=0)
			{
				if(u[i].name.equals(uname)&&u[i].password.equals(upwd))
				{
					System.out.println("��¼�ɹ�,��ӭ�û�"+uname);
					username=uname;
					break;
				}
			}
		}
	}
	//ע��ķ���
	public void register()
	{
		System.out.println("�������û���:");
		String uname=input.next();
		System.out.println("��������    ��:");
		String upwd=input.next();
		System.out.println("�������    ��:");
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
