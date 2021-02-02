// Santiago Garcia Arango

package ioc;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {

	// Attributes
	private String area;
	private double salary;
	private Date jobEndsOn;

	// Important: a great example of using "static" method and keeping OOP rules...
	// ... because "id" is unique for each object, but idNext must be static...
	// ... to be able to access it for future object references
	private int id;
	private static int idNext = 1;

	public Employee() {
		// Good way of having unique "id"s without breaking OOP rules...
		// ...(with static idNext and keeping private attributes for both)
		id = idNext;
		idNext++;
	}

	public Date getJobEndsOn() {
		return jobEndsOn;
	}

	public void setJobEndsOn(Date jobEndsOn) {
		this.jobEndsOn = jobEndsOn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public double getSalary() {
		return salary;
	}

	public void setJobEndsOn(String dateCustomFormat) {
		// Split input argument and convert to integers for creating date
		String[] datePosString = dateCustomFormat.split("/", 3);
		int[] datePosInt = new int[datePosString.length];
		for (int i = 0; i < datePosString.length; i++) {
			datePosInt[i] = Integer.getInteger(datePosString[i]);
		}

		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(datePosInt[0], datePosInt[1] - 1, datePosInt[2]);
		jobEndsOn = calendar.getTime();
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
