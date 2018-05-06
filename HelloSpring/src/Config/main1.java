package Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main1 {
	public static void main(String[] args) {
		ApplicationContext con = new AnnotationConfigApplicationContext(helloWorldConfig.class);
		helloWorld hw1 = (helloWorld) con.getBean(helloWorld.class);
		hw1.setMessage("message1");
		hw1.getMessage();
		helloWorld hw2 = (helloWorld) con.getBean(helloWorld.class);
		hw2.getMessage();
		
	}
}
