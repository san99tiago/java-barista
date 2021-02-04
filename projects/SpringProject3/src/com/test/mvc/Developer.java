// Santiago Garcia Arango

package com.test.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Developer extends Person {

	Date registrationDate;
	String mainLanguage;

	public Developer() {
		super();
	}

	public String getRegistrationDate() {
		return registrationDate.toString();
	}

	public void setRegistrationDate() {
		try {
			this.registrationDate = getDateWithoutTimeUsingFormat();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getDateWithoutTimeUsingFormat() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		return formatter.parse(formatter.format(new Date()));
	}

	public String getMainLanguage() {
		return mainLanguage;
	}

	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

}
