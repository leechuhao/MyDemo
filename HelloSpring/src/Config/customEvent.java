package Config;

import org.springframework.context.ApplicationEvent;

public class customEvent extends ApplicationEvent{

	public customEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "My Custom Event";
	}

}
