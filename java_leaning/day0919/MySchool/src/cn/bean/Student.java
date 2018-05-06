package cn.bean;

public class Student extends User
{
	/*
	 * 学生信息类
	 */
	private String collage;
	private int grade;
	public Student()
	{
		super();
	}
	public Student(int id, String name, String sex, String address,
			String birth, String collage, int grade)
	{
		super(id,name,sex,address,birth);
		this.collage = collage;
		this.grade = grade;
	}
	public void setCollage(String collage)
	{
		this.collage = collage;
	}
	public int getGrade()
	{
		return grade;
	}
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
}
