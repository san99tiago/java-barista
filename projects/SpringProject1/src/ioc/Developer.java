// Santiago Garcia Arango

package ioc;

public class Developer extends Employee implements EmployeesInterface {

	// Attributes
	private String mainLanguage;

	// Interface for dependency injection of "Reports"
	private CreateReportsInterface newReport;

	public Developer(CreateReportsInterface newReport) {
		// Call superclass (parent) to get its constructor
		super();

		// Custom dependency injection for reports
		this.newReport = newReport;
	}

	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

	@Override
	public String getInfo() {
		return "* Name: " + super.getName() + " (" + super.getSex() + ")\n* ID / Area: " + String.valueOf(super.getId())
				+ " / " + String.valueOf(super.getArea()) + "\n* Salary: " + String.valueOf(super.getSalary())
				+ "\n* Job Ends On: " + String.valueOf(super.getJobEndsOn()) + "\n* Main Language: " + mainLanguage
				+ "\n";
	}

	@Override
	public String getReport() {
		return "...Developer report for " + mainLanguage + ":" + newReport.getReportFinalStatement();
	}
}
