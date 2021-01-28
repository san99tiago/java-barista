// MULTIPLE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
// Santiago Garcia Arango

package oop2;

public class UsePeople {

	// Attributes for class usage
	private static Person[] people = new Person[5];
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
		((Employee) people[1]).changeArea("Tech Leader");

		showStateOfPeople();

		// Apply multiple changes for employees and students
		((Student) people[2]).changeStudyField("Marketing");
		((Employee) people[1]).increseSalary(8);
		((Employee) people[3]).increseSalary(6);
		((Employee) people[4]).increseSalary(18);
		((Employee) people[4]).changeArea("Human Resources");

		showStateOfPeople();

	}

	public static void createPeople() {
		// Create instances of the objects Student Employee in Person array (superclass)
		people[0] = new Student("Monica Hill", "Female", "Finance", "EIA University");
		people[0] = (Student) people[0];
		people[1] = new Employee("Santiago Garcia", "Male", "Engineering", 100, 2021, 07, 28);
		people[2] = new Student("Laura Lopez", "Female", "Management", "UPB University");
		people[3] = new Employee("Santiago Mendez", "Male", "Testing", 150, 2024, 12, 15);
		people[4] = new Employee("Susana Monsalve", "Female", "Psychology", 500);
	}

	public static void showStateOfPeople() {
		// Counter to keep trace on hay many times we have checked the people
		// automatically
		stateCounter = stateCounter + 1;

		System.out.println("\n----- STATE OF PEOPLE (ITERATION: " + String.valueOf(stateCounter) + ") -----");

		// Show the state of all employees
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getInfo());
		}

	}

}
