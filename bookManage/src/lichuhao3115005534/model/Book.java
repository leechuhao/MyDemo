package lichuhao3115005534.model;

public class Book {
	private int id ;
	private String name ;
	private String  type ;
	private String state;
	
	public Book(){};
	
	public Book set(int id, String name, String type, String state) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.state = state;
		return this;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
