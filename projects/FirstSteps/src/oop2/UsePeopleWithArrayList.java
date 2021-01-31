//MULTIPLE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
//BETTER WAY OF STORING PEOPLE WITH ARRAYLISTS
//Santiago Garcia Arango

package oop2;

import java.util.ArrayList;
import java.util.Collections;

public class UsePeopleWithArrayList {

	// Attributes for class usage
	private static ArrayList<Person> people = new ArrayList<Person>();
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
		// ... not available in the superclass Person (only in subclasses)
		((Student) people.get(0)).changeStudyField("Computer Science");
		((Student) people.get(2)).changeUniversity("EAFIT University");
		((Employee) people.get(1)).increseSalary(5);
		((Employee) people.get(3)).increseSalary(10);
		((Employee) people.get(4)).increseSalary(21);
		((Boss) people.get(5)).increseSalary(15);
		((Employee) people.get(1)).changeArea("Tech Leader");

		showStateOfPeople();

		// Apply multiple changes for employees and students
		((Student) people.get(2)).changeStudyField("Marketing");
		((Employee) people.get(1)).increseSalary(8);
		((Employee) people.get(3)).increseSalary(6);
		((Employee) people.get(4)).increseSalary(18);
		((Boss) people.get(5)).increseSalary(10);
		((Employee) people.get(4)).changeArea("Human Resources");

		showStateOfPeople();

		((Employee) people.get(1)).giveBonus(150);
		((Employee) people.get(3)).giveBonus(100);
		((Employee) people.get(4)).giveBonus(30);
		((Boss) people.get(5)).giveBonus(500);

		((Boss) people.get(5)).createMeeting("Play Catan with me.", 2029, 9, 3);
		((Boss) people.get(5)).redeemVacations();

	}

	public static void createPeople() {
		// Create instances of the objects Student Employee in Person array (superclass)
		people.add(new Student("Monica Hill", "Female", "Finance", "EIA University"));
		people.add(new Employee("Santiago Garcia", "Male", "Engineering", 100, 2021, 7, 28));
		people.add(new Student("Laura Lopez", "Female", "Management", "UPB University"));
		people.add(new Employee("Santiago Mendez", "Male", "Testing", 150, 2024, 12, 15));
		people.add(new Employee("Ximena Monsalve", "Female", "Psychology", 300));
		people.add(new Boss("Elizabeth Hoyos", "Female", "Engineering", 800, 2030, 9, 25, "New PC/year", 150));
	}

	public static void showStateOfPeople() {
		// Counter to keep trace on hay many times we have checked the people
		// automatically
		stateCounter = stateCounter + 1;

		// Create a new ArrayList of the original people's ArrayList, to avoid...
		// ...changing the original order (for the methods implemented at the beggining)
		ArrayList<Person> peopleOrdered = new ArrayList<Person>(people);

		// Sort ArrayList of "People" (the copy) by their name before printing results
		// remark: for using this method, we MUST guarantee that the object Person...
		// ...implements from the "Comparable" interface (to know "how" to sort)
		Collections.sort(peopleOrdered);
		System.out.println("\n----- STATE OF PEOPLE (ITERATION: " + String.valueOf(stateCounter) + ") -----");

		// Show the state of all employees
		for (int i = 0; i < peopleOrdered.size(); i++) {
			System.out.println(peopleOrdered.get(i).getInfo());
		}

	}

}
