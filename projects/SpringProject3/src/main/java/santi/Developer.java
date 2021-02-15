// Santiago Garcia Arango

package main.java.santi;

import java.time.LocalDate;

public class Developer extends Person {

	LocalDate registrationDate;
	String mainLanguage;

	public Developer() {
		super();
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate() {
		this.registrationDate = LocalDate.now();
	}

	public String getMainLanguage() {
		return mainLanguage;
	}

	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

}
