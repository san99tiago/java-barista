// EMPLOYEE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
// Santiago Garcia Arango

package oop;

import java.util.*;

public class Employee {

	// Create attributes (better as private) for the employee object
	private String name;
	private String area;
	private double salary;
	private Date jobEndsOn;

	// Important: a great example of using "static" method and keeping OOP rules...
	// ... because "id" is unique for each object, but idNext must be static...
	// ... to be able to access it for future object references
	private int id;
	private static int idNext = 1;

	// Constructor 1 (for overloading and "extending" arguments handling)
	public Employee(String name, String area, double salary, int year, int month, int day) {

		this.name = name;
		this.area = area;
		this.salary = salary;

		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		jobEndsOn = calendar.getTime();

		// Good way of having unique "id"s without breaking OOP rules...
		// ...(with static idNext and keeping private attributes for both)
		id = idNext;
		idNext++;
	}

	// Constructor 2 (for overloading and "extending" arguments handling)
	public Employee(String name, String area, double salary) {

		// Extend main constructor with default date (after that, we change the date)
		this(name, area, salary, 0, 0, 0);

		// Set default job's end date one year after creation (overwrite jobEndsOn)
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.YEAR, 1);
		jobEndsOn = calendar.getTime();

	}

	// Getter for all information of employee
	public String getEmployeeInfo() {
		return "* name: " + name + "\n* ID: " + String.valueOf(id) + "\n* Area: " + String.valueOf(area)
				+ "\n* Salary: " + String.valueOf(salary) + "\n* Job Ends On: " + String.valueOf(jobEndsOn) + "\n";
	}

	// Setter for applying raise to employee's salary
	public void increseSalary(double percentage) {
		salary = salary * (1 + percentage / 100);
	}

	// Setter for changing area of employee
	public void changeArea(String new_area) {
		area = new_area;
	}

}
