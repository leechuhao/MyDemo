package lichuhao3115005534.model;

public class admin {
	private int id;
	private String account;
	private String password;
	
	public admin() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public admin set(int id, String account, String password){
		this.id = id;
		this.account = account;
		this.password = password;
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
