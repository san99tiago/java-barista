// Santiago Garcia Arango

package com.annotations;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class SpecialReport implements CreateReportsInterface {

	@Override
	public String getReportFinalStatement() {
		GregorianCalendar calendar = new GregorianCalendar();
		Date currentTime = calendar.getTime();
		return "\n<<<THIS REPORT IS SPECIAL>>>\n...This report was created on: " + currentTime.toString() + "\n";
	}

}
