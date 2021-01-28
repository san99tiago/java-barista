// FIRST SUPERCLASS OBJECT THAT WILL EXTEND FOR EMPLOYEES AND STUDENTS
// Santiago Garcia Arango

package oop2;

// remark: abstract because of the abstract method "getInfo()"
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

	// Abstract method to guarantee that will be implemented in children classes
	public abstract String getInfo();

}
