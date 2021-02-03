// Santiago Garcia Arango

package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Director extends Employee implements EmployeesInterface {

	private String mainAbility;
	private SpecialReport newReport;

	public Director() {
		super();
	}

	public void setMainAbility(String mainAbility) {
		this.mainAbility = mainAbility;
	}

	@Autowired
	public void setNewReport(SpecialReport newReport) {
		this.newReport = newReport;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "\n* Main Ability: " + mainAbility + "\n";
	}

	@Override
	public String getReport() {
		return "...Director report for meeting:" + newReport.getReportFinalStatement();
	}

}
