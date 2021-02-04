// Santiago Garcia Arango

package com.test.mvc;

import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

	private String name;
	private Date birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday.toString();
	}

	public void setBirthday(String birthday) {
		// Convert from String input, to specific int[] array
		int[] datePosInt = convertCustomBirthdayString(birthday);

		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(datePosInt[0], (datePosInt[1] - 1), datePosInt[2]);
		this.birthday = calendar.getTime();
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
