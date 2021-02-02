package ioc;

import java.util.Date;
import java.util.GregorianCalendar;

public class Report implements CreateReportsInterface {

	@Override
	public String getReportFinalStatement() {
		GregorianCalendar calendar = new GregorianCalendar();
		Date currentTime = calendar.getTime();
		return "\n...This report was created on: " + currentTime.toString() + "\n";
	}

}
