// Santiago Garcia Arango

package ioc;

public class Boss extends Employee implements EmployeesInterface {

	// Create attributes
	private String extraBenefits;

	// Interface for dependency injection of "Reports"
	private CreateReportsInterface newReport;

	public Boss() {
		// Call superclass (parent) to get its constructor
		super();
	}

	public void setExtraBenefits(String extraBenefits) {
		this.extraBenefits = extraBenefits;
	}

	@Override
	public String getInfo() {
		return "* Name: " + super.getName() + " (" + super.getSex() + ")\n* ID / Area: " + String.valueOf(super.getId())
				+ " / " + String.valueOf(super.getArea()) + "\n* Salary: " + String.valueOf(super.getSalary())
				+ "\n* Job Ends On: " + String.valueOf(super.getJobEndsOn()) + "\n* Extra Benefits: " + extraBenefits
				+ "\n";
	}

	// Method for dependency injection (of newReport)
	// remark: check the name (in XML it is "called" without the "set")
	public void setNewReport(CreateReportsInterface newReport) {
		// Custom dependency injection for reports
		this.newReport = newReport;
	}

	@Override
	public String getReport() {
		return "...Boss report for meeting:" + newReport.getReportFinalStatement();
	}
}
