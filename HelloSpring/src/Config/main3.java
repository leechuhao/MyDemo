package Config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main3 {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(config3.class);    
		customEventPublisher cvp = (customEventPublisher) context.getBean(customEventPublisher.class);
		cvp.publish();  
		cvp.publish();
	}
}
