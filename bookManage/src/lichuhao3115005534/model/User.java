package lichuhao3115005534.model;

public class User {
	private int id ;
	private String name ;
	private String password;
	private String sex;
	private String dept;
	
	
	public User(){};
	
	public User set(int id, String name, String password, String sex, String dept) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.dept = dept;
		return this;
	}
	
	public int getId() {
		return id;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
