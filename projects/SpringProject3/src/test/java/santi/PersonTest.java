package test.java.santi;

import main.java.santi.Person;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPersonWithoutSpecificName() {
		Person person = new Person();
		assertEquals(person.getName(), null, "Person Object instance without setting a name, should return <null>");
	}

	@Test
	void testPersonWithoutSpecificBirthday() {
		Person person = new Person();
		assertEquals(person.getBirthday(), null,
				"Person Object instance without setting a birthday, should return <null>");
	}

	@Test
	void testPersonWithSpecificName() {
		Person person = new Person();
		String name = "Santiago";
		person.setName(name);
		assertEquals(person.getName(), name,
				"Person Object instance with an already set name, should return given name in String format");
	}

	@Test
	void testConvertCustomBirthdayStringOk() {
		Person person = new Person();
		try {
			String birthday = "1999/12/20";
			int[] resultBirthday = person.convertCustomBirthdayString(birthday);
			int[] expectedBirthday = { 1999, 12, 20 };
			assertArrayEquals(resultBirthday, expectedBirthday);
		} catch (Exception e) {
			fail("Convert custom birthday should return an array of integers from given String");
		}
	}

	@Test
	void testExceptionConvertCustomBirthdayStringWrongBirthdayStringFormat() {
		assertThrows(RuntimeException.class, () -> {
			Person person = new Person();
			String birthday = "1999-12-20";
			System.out.println(person.convertCustomBirthdayString(birthday));
		});
	}

	@Test
	void testExceptionConvertCustomBirthdayStringWrongYearInput() {
		assertThrows(RuntimeException.class, () -> {
			Person person = new Person();
			String birthday = "-1999/12/20";
			System.out.println(person.convertCustomBirthdayString(birthday));
		});
	}

	@Test
	void testExceptionConvertCustomBirthdayStringWrongMonthInputLower() {
		assertThrows(RuntimeException.class, () -> {
			Person person = new Person();
			String birthday = "1999/0/20";
			System.out.println(person.convertCustomBirthdayString(birthday));
		});
	}

	@Test
	void testExceptionConvertCustomBirthdayStringWrongMonthInputUpper() {
		assertThrows(RuntimeException.class, () -> {
			Person person = new Person();
			String birthday = "1999/13/20";
			System.out.println(person.convertCustomBirthdayString(birthday));
		});
	}

	@Test
	void testPersonWithSpecificBirthday() {
		Person person = new Person();
		String birthday = "2000/12/31";
		person.setBirthday(birthday);
		LocalDate expectedBirthday = LocalDate.of(2000, 12, 31);
		assertEquals(person.getBirthday(), expectedBirthday,
				"Person Object instance with an already set birthday, should return given birthday in String format");
	}

}
