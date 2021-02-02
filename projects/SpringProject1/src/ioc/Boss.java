package ioc;

import java.util.Date;
import java.util.GregorianCalendar;

public class Boss extends Person implements EmployeesInterface {

	// Create attributes
	private String area;
	private double salary;
	private Date jobEndsOn;
	private String extraBenefits;

	// Interface for dependency injection of "Reports"
	private CreateReportsInterface newReport;

	// Important: a great example of using "static" method and keeping OOP rules...
	// ... because "id" is unique for each object, but idNext must be static...
	// ... to be able to access it for future object references
	private int id;
	private static int idNext = 1;

	public Boss(CreateReportsInterface newReport, String name, String sex, String area, double salary, int year,
			int month, int day, String extraBenefits, double extraDonationMoney) {

		// Call superclass (parent) to get its constructor
		super(name, sex);

		this.area = area;
		this.salary = salary;

		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		jobEndsOn = calendar.getTime();

		// Good way of having unique "id"s without breaking OOP rules...
		// ...(with static idNext and keeping private attributes for both)
		id = idNext;
		idNext++;
		this.extraBenefits = extraBenefits;

		// Custom dependency injection for reports
		this.newReport = newReport;
	}

	@Override
	public String getInfo() {
		return "* Name: " + super.getName() + " (" + super.getSex() + ")\n* ID / Area: " + String.valueOf(id) + " / "
				+ String.valueOf(area) + "\n* Salary: " + String.valueOf(salary) + "\n* Job Ends On: "
				+ String.valueOf(jobEndsOn) + "\n* Extra Benefits: " + extraBenefits + "\n";
	}

	@Override
	public String getReport() {
		return "...Boss report for meeting:" + newReport.getReportFinalStatement();
	}
}
