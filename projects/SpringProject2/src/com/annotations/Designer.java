// Santiago Garcia Arango

package com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Understanding how "@Component" and "@Autowired" work for adding dependency injections.
 * "@Component" tag is scanned and registered in the context as a Spring bean.
 * "@Autowired" tag allows Spring to resolve and inject collaborating beans into our bean.
 * "@Scope" tag can be implemented to change design patterns to "prototype" or "singleton".
 * "@Value" tag is used with "@PropertySource(...)" to implement properties for attributes.
 */

@Component
@Scope(value="prototype")  
public class Designer extends Employee implements EmployeesInterface {

	private String mainDesignTool;
	private Report newReport;

	public Designer() {
		super();
	}

	public void setMainDesignTool(String mainDesignTool) {
		this.mainDesignTool = mainDesignTool;
	}

	@Autowired
	public void setNewReport(Report newReport) {
		this.newReport = newReport;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "\n* Main design tool: " + mainDesignTool + "\n";
	}

	@Override
	public String getReport() {
		return "...Designer report for meeting:" + newReport.getReportFinalStatement();
	}

}
