package Hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class mainApp {
	public static void main(String[] args){
		ConfigurableApplicationContext con = new ClassPathXmlApplicationContext("Beans.xml");
		helloWorld obj = (helloWorld)con.getBean("helloWorld");
//		obj.setMessage("怎么不行了");
		obj.getMessage();
		
		con.close();
	}
}
