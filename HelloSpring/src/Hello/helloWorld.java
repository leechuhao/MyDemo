package Hello;

public class helloWorld {
	private String msg;
	public void setMessage(String message){
		this.msg = message;
	}
	
	public void getMessage(){
		System.out.println("your message: " + msg);
	}
	
	public void init(){
		System.out.println("Bean is going through init.");
	}
	public void destroy(){
		System.out.println("Bean will destroy now.");
	}
}
