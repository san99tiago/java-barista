// EMPLOYEE EXAMPLE WITH OBJECT-ORIENTED-PROGRAMMING
// Santiago Garcia Arango

package oop;

import java.util.*;

public class Employee {

	// Create attributes (better as private) for the employee object
	private String name;
	private double salary;
	private Date jobEndsOn;

	// Constructor method must have the same name as class (ex: "Employee")
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		jobEndsOn = calendar.getTime();
	}
	
	// Getter for all information of employee
	public String getEmployeeInfo() {
		return "* name: " + name + "\n" + "* Salary: " +  String.valueOf(salary) + "\n"
				+ "* Job Ends On:  " + String.valueOf(jobEndsOn) + "\n";	
	}
	
	// Setter for applying raise to employee's salary
	public void increseSalary(double percentage) {
		salary = salary * (1 + percentage/100);
	}

}
