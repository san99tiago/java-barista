// EMPLOYEE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
// Santiago Garcia Arango

package oop;

public class UseEmployee {

	public static void main(String[] args) {

//		testEmployees1();
		testEmployees2();

	}

	public static void testEmployees1() {
		// Create instances of the object Employee
		Employee employee_1 = new Employee("Santiago Garcia", "Engineering", 100, 2021, 07, 28);
		Employee employee_2 = new Employee("Santiago Mendez", "Testing", 150, 2024, 12, 15);
		Employee employee_3 = new Employee("Leonardo Davinci", "Psychology", 500);

		System.out.println("\n----- INITIAL STATE OF EMPLOYEES -----");
		System.out.println(employee_1.getEmployeeInfo());
		System.out.println(employee_2.getEmployeeInfo());
		System.out.println(employee_3.getEmployeeInfo());

		// Generate salary increases
		employee_1.increseSalary(5);
		employee_2.increseSalary(10);
		employee_3.increseSalary(21);

		// Apply area changes
		employee_1.changeArea("Tech Leader");

		System.out.println("\n----- SECOND STATE OF EMPLOYEES -----");
		System.out.println(employee_1.getEmployeeInfo());
		System.out.println(employee_2.getEmployeeInfo());
		System.out.println(employee_3.getEmployeeInfo());

		// Generate salary increases
		employee_1.increseSalary(8);
		employee_2.increseSalary(6);
		employee_3.increseSalary(18);

		// Apply area changes
		employee_3.changeArea("CEO");

		System.out.println("\n----- FINAL STATE OF EMPLOYEES -----");
		System.out.println(employee_1.getEmployeeInfo());
		System.out.println(employee_2.getEmployeeInfo());
		System.out.println(employee_3.getEmployeeInfo());
	}

	public static void testEmployees2() {
		// Create instances of the object Employee in an array
		Employee[] employees = new Employee[3];

		employees[0] = new Employee("Santiago Garcia", "Engineering", 100, 2021, 07, 28);
		employees[1] = new Employee("Santiago Mendez", "Testing", 150, 2024, 12, 15);
		employees[2] = new Employee("Leonardo Davinci", "Psychology", 500);

		System.out.println("\n----- INITIAL STATE OF EMPLOYEES -----");
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getEmployeeInfo());
		}

		// Generate salary increases
		employees[0].increseSalary(5);
		employees[1].increseSalary(10);
		employees[2].increseSalary(21);

		// Apply area changes
		employees[0].changeArea("Tech Leader");

		System.out.println("\n----- SECOND STATE OF EMPLOYEES -----");
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getEmployeeInfo());
		}

		// Generate salary increases
		employees[0].increseSalary(8);
		employees[1].increseSalary(6);
		employees[2].increseSalary(18);

		// Apply area changes
		employees[2].changeArea("CEO");

		System.out.println("\n----- FINAL STATE OF EMPLOYEES -----");
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].getEmployeeInfo());
		}

	}

}
