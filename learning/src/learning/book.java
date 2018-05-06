package learning;

public class book {
	private String name;
	
	public String getName(){
		int id = 6;
		setName("javabook");
		return id + this.name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public  book getBook(){
		return this;
	}
}
