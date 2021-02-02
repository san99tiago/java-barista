// Santiago Garcia Arango

package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UseEmployees {

	public static void main(String[] args) {
		// Load main "context" for the application, using XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Create Developer and Boss objects (conditions specified in the XML context)
		Developer santi = context.getBean("myDeveloperObject", Developer.class);
		Boss eli = context.getBean("myBossObject", Boss.class);

		// Test cool methods for both objects (to see their correct different result)
		System.out.println(santi.getInfo());
		System.out.println(santi.getReport());
		System.out.println(eli.getInfo());
		System.out.println(eli.getReport());

		// Close context to avoid over-using resources
		context.close();

	}
}
