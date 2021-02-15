// Santiago Garcia Arango

package com.main.mvc;

import java.time.LocalDate;

public class Person {

	private String name;
	private LocalDate birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		// Convert from String input, to specific int[] array
		int[] datePosInt = convertCustomBirthdayString(birthday);
		this.birthday = LocalDate.of(datePosInt[0], (datePosInt[1]), datePosInt[2]);
	}

	public int[] convertCustomBirthdayString(String birthday) {
		// Split input argument and convert to integers for creating date
		String[] datePosString = birthday.split("/", 3);
		int[] datePosInt = new int[datePosString.length];
		for (int i = 0; i < datePosString.length; i++) {
			datePosInt[i] = Integer.parseInt(datePosString[i]);
		}
		return datePosInt;
	}

}
