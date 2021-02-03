// Santiago Garcia Arango

package com.annotations;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;

public class Employee extends Person {

	private String area;

	private double salary;

	private Date jobEndsOn;

	@Value("${business_name:Not Defined}")
	private String businessName;

	private int id;

	private static int idNext = 1;

	public Employee() {
		id = idNext;
		idNext++;
	}

	public Date getJobEndsOn() {
		return jobEndsOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getArea() {
		return area;
	}

	public double getSalary() {
		return salary;
	}

	public String getBusinessName() {
		return businessName;
	}

	public String getInfo() {
		return "* Name: " + super.getName() + " (" + super.getSex() + ")\n* ID / Area: " + String.valueOf(getId())
				+ " / " + String.valueOf(getArea()) + "\n* Salary: " + String.valueOf(getSalary())
				+ "\n* Business name: " + getBusinessName() + "\n* Job Ends On: " + String.valueOf(getJobEndsOn());
	}

	public void setJobEndsOn(String dateCustomFormat) {

		// Split input argument and convert to integers for creating date
		String[] datePosString = dateCustomFormat.split("/", 3);
		int[] datePosInt = new int[datePosString.length];
		for (int i = 0; i < datePosString.length; i++) {
			datePosInt[i] = Integer.parseInt(datePosString[i]);
		}

		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(datePosInt[0], (datePosInt[1] - 1), datePosInt[2]);
		jobEndsOn = calendar.getTime();
	}

}
