package Hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp3 {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("Bean3.xml");
		javaCollection jc = (javaCollection) con.getBean("javaCollection");
		jc.getaddressList();
		jc.getaddressSet();
		jc.getaddressMap();
		jc.getaddressProp();
	}
}
