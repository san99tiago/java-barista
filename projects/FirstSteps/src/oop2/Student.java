// STUDENT WITH INHERITANCE FROM PERSON
// Santiago Garcia Arango

package oop2;

public class Student extends Person {

	private String studyField;
	private String university;

	public Student(String name, String sex, String studyField, String universiy) {

		// Call superclass (parent) to get its constructor
		super(name, sex);
		this.studyField = studyField;
		this.university = universiy;
	}

	// Getter for all information (this is an abstract class that we must use)
	public String getInfo() {
		return "* Name: " + super.getName() + " (" + super.getSex() + ")\n* Study Field: " + studyField
				+ "\n* University: " + university + "\n";
	}

	// Setter to change study field of student
	public void changeStudyField(String newStudyField) {
		studyField = newStudyField;
	}

	// Setter to change university of student
	public void changeUniversity(String newUniversity) {
		university = newUniversity;
	}

}
