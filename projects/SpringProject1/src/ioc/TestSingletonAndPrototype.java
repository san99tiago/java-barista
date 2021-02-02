//Santiago Garcia Arango

package ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSingletonAndPrototype {

	public static void main(String[] args) {
		// Load main "context" for the application, using XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

		// Create Developer and Boss objects (conditions specified in the XML context)
		Developer santi1 = context.getBean("myDeveloperObject", Developer.class);
		Developer santi2 = context.getBean("myDeveloperObject", Developer.class);
		Boss eli1 = context.getBean("myBossObject", Boss.class);
		Boss eli2 = context.getBean("myBossObject", Boss.class);

		// Show that both pair of objects are doing the same, but when we compare...
		// ...them, the "singleton" is exactly the same and the "prototype" is not
		System.out.println(santi1.getInfo());
		System.out.println(santi2.getInfo());
		System.out.println(eli1.getInfo());
		System.out.println(eli2.getInfo());
		
		// Show if the objects are different or the same (singleton vs prototype)
		System.out.println("\nShowing objects <santi1> and <santi2>:\n" + santi1 + "\n" + santi2);
		if (santi1 == santi2) {
			System.out.println("--> santi1 is exactly the same object as santi2!");
		} else {
		System.out.println("--> santi1 is a different object, than santi2!");
		}
		System.out.println("\nShowing objects <eli1> and <eli2>:\n" + eli1 + "\n" + eli2);
		if (eli1 == eli2) {
			System.out.println("--> eli1 is exactly the same object as eli2!");
		} else {
			System.out.println("--> eli1 is a different object, than eli2!");
		}

		// Close context to avoid over-using resources
		context.close();

	}
}
