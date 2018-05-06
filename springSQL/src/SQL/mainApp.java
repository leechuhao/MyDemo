package SQL;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		studentJDBCTemplate stuJDBCTemplate = (studentJDBCTemplate)context.getBean("studentJDBCTemplate");
		
		System.out.println("------Records Creation------");
		stuJDBCTemplate.create("li", 11);
		stuJDBCTemplate.create("chu", 2);
		stuJDBCTemplate.create("hao", 12);
		
		System.out.println("------Listing Multiple Records------");
		List<student> stus = stuJDBCTemplate.listStudents();
		for(student record : stus) {
			System.out.println("id: " + record.getId());
			System.out.println("name: " + record.getName());
			System.out.println("age: " + record.getAge());
		}
		
		System.out.println("------Updating record with id = 2------");
		stuJDBCTemplate.update(2, 20);
		
		System.out.println("------Listing record with id = 2------");
		student stu = stuJDBCTemplate.getStudent(2);
		System.out.println("id: " + stu.getId());
		System.out.println("name: " + stu.getName());
		System.out.println("age: " + stu.getAge());
		
		System.out.println("deleted all records y?");
		while(sc.hasNext()) {
			 String str = sc.next();
			 System.out.println("shuru de shi " + str);
			if(str.equals("y") || str.equals("Y")) {
				for(student record : stus) {
					stuJDBCTemplate.delete(record.getId());
				}
				System.out.println("------Listing Multiple Records------");
				List<student> stus2 = stuJDBCTemplate.listStudents();
				for(student record : stus2) {
					System.out.println("id: " + record.getId());
					System.out.println("name: " + record.getName());
					System.out.println("age: " + record.getAge());
				}
			}
		}
		sc.close();
		
		
	}
}
