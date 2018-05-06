package cn.demo;

import org.junit.Test;

import cn.bean.Teacher;

public class Demo
{
	@Test
	public void test01()
	{
		Teacher tea=new Teacher();
		tea.setId(1001);
		System.out.println(tea.getId()+"\t"+tea.getName());
	}
	
	@Test
	public void test02()
	{
		int[] num=new int[10];
		System.out.println(num[0]);
	}
}
