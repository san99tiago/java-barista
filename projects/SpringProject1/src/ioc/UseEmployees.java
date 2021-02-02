package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UseEmployees {

	public static void main(String[] args) {
		// Load main "context" for the application, using XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Create Developer and Boss objects, with conditions specified in the context
		Developer santi = (Developer) context.getBean("myDeveloperObject", EmployeesInterface.class);
		Boss eli = (Boss) context.getBean("myBossObject", EmployeesInterface.class);

		// Test main methods for both objects (to see their correct different result)
		System.out.println(santi.getInfo());
		System.out.println(santi.getReport());
		System.out.println(eli.getInfo());
		System.out.println(eli.getReport());

		context.close();

	}
}
