package cn.bean;

public class User
{
	/*
	 * 用户信息类
	 */
	private int id;
	private String name;
	private String sex;
	private String address;
	private String birth;
	public User()
	{
		super();
	}
	public User(int id, String name, String sex, String address, String birth)
	{
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.birth = birth;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getBirth()
	{
		return birth;
	}
	public void setBirth(String birth)
	{
		this.birth = birth;
	}
}
