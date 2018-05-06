package Config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main2 {
	public static void main(String[] args) {
		ConfigurableApplicationContext con = new AnnotationConfigApplicationContext(config2.class);
			
		con.start();
	    helloWorld obj = (helloWorld) con.getBean(helloWorld.class);
	    obj.getMessage();
	    con.stop();
	}
}
