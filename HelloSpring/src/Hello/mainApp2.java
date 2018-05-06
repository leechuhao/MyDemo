package Hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp2 {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("Bean2.xml");
		textEditor te = (textEditor) con.getBean("textEditor");
		te.checkSpelling();
	}
}
