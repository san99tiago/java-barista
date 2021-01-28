// MULTIPLE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
// Santiago Garcia Arango

package oop2;

import java.util.Arrays;

public class UsePeople {

	// Attributes for class usage
	private static Person[] people = new Person[6];
	private static int stateCounter = 0;

	public static void main(String[] args) {
		testPeople();
	}

	public static void testPeople() {

		// Fill arrays of people with both students and employees objects
		createPeople();

		showStateOfPeople();

		// Apply multiple changes for employees and students
		// remark: we MUST "downcast" objects to access specific methods that are...
		// ... not available in the superclass Person
		((Student) people[0]).changeStudyField("Computer Science");
		((Student) people[2]).changeUniversity("EAFIT University");
		((Employee) people[1]).increseSalary(5);
		((Employee) people[3]).increseSalary(10);
		((Employee) people[4]).increseSalary(21);
		((Boss) people[5]).increseSalary(15);
		((Employee) people[1]).changeArea("Tech Leader");

		showStateOfPeople();

		// Apply multiple changes for employees and students
		((Student) people[2]).changeStudyField("Marketing");
		((Employee) people[1]).increseSalary(8);
		((Employee) people[3]).increseSalary(6);
		((Employee) people[4]).increseSalary(18);
		((Boss) people[5]).increseSalary(10);
		((Employee) people[4]).changeArea("Human Resources");

		showStateOfPeople();

		((Employee) people[1]).giveBonus(150);
		((Employee) people[3]).giveBonus(100);
		((Employee) people[4]).giveBonus(30);
		((Boss) people[5]).giveBonus(500);

		((Boss) people[5]).createMeeting("Play Catan with me.", 2029, 9, 3);
		((Boss) people[5]).redeemVacations();

	}

	public static void createPeople() {
		// Create instances of the objects Student Employee in Person array (superclass)
		people[0] = new Student("Monica Hill", "Female", "Finance", "EIA University");
		people[0] = (Student) people[0];
		people[1] = new Employee("Santiago Garcia", "Male", "Engineering", 100, 2021, 7, 28);
		people[2] = new Student("Laura Lopez", "Female", "Management", "UPB University");
		people[3] = new Employee("Santiago Mendez", "Male", "Testing", 150, 2024, 12, 15);
		people[4] = new Employee("Ximena Monsalve", "Female", "Psychology", 300);
		people[5] = new Boss("Elizabeth Hoyos", "Female", "Engineering", 800, 2030, 9, 25, "New PC/year", 150);
	}

	public static void showStateOfPeople() {
		// Counter to keep trace on hay many times we have checked the people
		// automatically
		stateCounter = stateCounter + 1;

		// Create a clone of the people's array, to avoid changing original order
		Person[] peopleOrdered = people.clone();

		// Sort array of People (the copy) by their name before printing results
		// remark: for using this method, we MUST guarantee that the object Person...
		// ...implements from the "Comparable" interface
		Arrays.sort(peopleOrdered);

		System.out.println("\n----- STATE OF PEOPLE (ITERATION: " + String.valueOf(stateCounter) + ") -----");

		// Show the state of all employees
		for (int i = 0; i < peopleOrdered.length; i++) {
			System.out.println(peopleOrdered[i].getInfo());
		}

	}

}
