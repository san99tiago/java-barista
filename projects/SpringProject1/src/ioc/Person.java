package ioc;

public abstract class Person {

	// Attributes
	private String name;
	private String sex;

	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	// Getter for the name
	public String getName() {
		return name;
	}

	// Getter for the sex
	public String getSex() {
		return sex;
	}

}
