// Santiago Garcia Arango

package com.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseEmployeesWithAnnotations {

	public static void main(String[] args) {

		test2();

	}

	public static void test1() {
		// Load main "context" for the application, using XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Create Designer object (check annotations "@..." to see working principles)
		Designer sabi1 = context.getBean("designer", Designer.class);
		Designer sabi2 = context.getBean("designer", Designer.class);

		// Test cool methods
		System.out.println(sabi1.getInfo());
		System.out.println(sabi1.getReport());

		// Show if the objects are different or the same (singleton vs prototype)
		// remark: this will change based on the "@Scope" annotation on top of class
		System.out.println("\nShowing objects <sabi1> and <sabi2>:\n" + sabi1 + "\n" + sabi2);
		if (sabi1 == sabi2) {
			System.out.println("--> sabi1 is exactly the same object as sabi2!");
		} else {
			System.out.println("--> sabi1 is a different object, than sabi2!");
		}

		// Close context to avoid over-using resources
		context.close();
	}

	public static void test2() {
		// For this test, we don't need anymore the XML configuration, because we...
		// ... created the "ConfigEmployees.java" to get the same result
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigEmployees.class);
		
		// Create objects (check annotations "@..." to see working principles)
		Designer sabi1 = context.getBean("designer", Designer.class);
		Designer sabi2 = context.getBean("designer", Designer.class);
		Director moni = context.getBean("director", Director.class);

		// Test cool methods
		System.out.println(sabi1.getInfo());
		System.out.println(sabi1.getReport());
		System.out.println(sabi2.getInfo());
		System.out.println(sabi2.getReport());
		System.out.println(moni.getInfo());
		System.out.println(moni.getReport());

		// Show if the objects are different or the same (singleton vs prototype)
		// remark: this will change based on the "@Scope" annotation on top of class
		System.out.println("\nShowing objects <sabi1> and <sabi2>:\n" + sabi1 + "\n" + sabi2);
		if (sabi1 == sabi2) {
			System.out.println("--> sabi1 is exactly the same object as sabi2!");
		} else {
			System.out.println("--> sabi1 is a different object, than sabi2!");
		}
		// Close context to avoid over-using resources
		context.close();
	}

}
