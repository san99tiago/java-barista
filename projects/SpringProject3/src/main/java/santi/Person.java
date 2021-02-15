// Santiago Garcia Arango

package main.java.santi;

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

	public void setBirthday(String birthday) throws RuntimeException{
		try {
			// Convert from String input, to specific int[] array
			int[] datePosInt = convertCustomBirthdayString(birthday);
			this.birthday = LocalDate.of(datePosInt[0], (datePosInt[1]), datePosInt[2]);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public int[] convertCustomBirthdayString(String birthday) throws RuntimeException {
		// Split input argument and convert to integers for creating date
		String[] datePosString = birthday.split("/");

		if (datePosString.length != 3) {
			throw new RuntimeException("Incorrect birthday String format");
		}

		int[] datePosInt = new int[datePosString.length];
		for (int i = 0; i < datePosString.length; i++) {
			datePosInt[i] = Integer.parseInt(datePosString[i]);
		}

		if (datePosInt[0] < 0) {
			throw new RuntimeException("Incorrect year input");
		}

		if (datePosInt[1] < 1 || datePosInt[1] > 12) {
			throw new RuntimeException("Incorrect month input");
		}

		if (datePosInt[2] < 1 || datePosInt[2] > 31) {
			throw new RuntimeException("Incorrect day input");
		}

		return datePosInt;
	}

}
