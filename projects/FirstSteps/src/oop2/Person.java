// FIRST SUPERCLASS OBJECT THAT WILL EXTEND FOR EMPLOYEES AND STUDENTS
// Santiago Garcia Arango

package oop2;

// remark: abstract because of the abstract method "getInfo()"
// remark: implements "Comparable" to be able to sort by name later
public abstract class Person implements Comparable<Object> {

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

	// Create method for the correct usage of "Comparable" interface
	// ... this is to be able to "sort" Person objects by our own attributes...
	// ...(in this case, by their names)
	public int compareTo(Object otherObject) {
		Person otherPerson = (Person) otherObject;

		if (this.name.compareTo(otherPerson.name) > 0) {
			return 1;
		}
		if (this.name.compareTo(otherPerson.name) < 0) {
			return -1;
		}
		return 0;
	}

}
