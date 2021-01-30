// CREATING MY OWN-TYPE EXCEPTIONS (WHEN NO DEFAULT ONE EXISTS)
// Santiago Garcia Arango

package exceptions;

import javax.swing.JOptionPane;

public class MyOwnExceptions {

	public static void main(String[] args) {

		String inputMail = JOptionPane.showInputDialog("Please enter your email:");

		// The try-catch is mandatory for our own Exception created
		try {
			checkMail(inputMail);
		} catch (WrongMailLength e) {
			e.printStackTrace();
		}
		System.out.println("\n\nProgram finished\n\n");

	}

	// The exception class is custom (look at the end of the file)
	public static void checkMail(String mail) throws WrongMailLength {
		// Variables to do a simple (raw) check of email address
		int atSign = 0;
		boolean point = false;

		// Valid mails should contain at least 5 characters in the String
		if (mail.length() < 5) {
			// This is our custom error-handling exception created at the bottom class
//			throw new WrongMailLength();
			throw new WrongMailLength("Mail is too short (needs at least 5 characters)");

		} else {
			// Check for having at one "@" (at) and at least one "." (dot) character
			for (int i = 0; i < mail.length(); i++) {
				if (mail.charAt(i) == '@') {
					atSign++;
				}
				if (mail.charAt(i) == '.') {
					point = true;
				}
			}
			if (atSign == 1 && point == true) {
				System.out.println("Correct mail.");
			} else {
				System.out.println("Incorrect mail.");
			}
		}

	}
}

// My own custom Exception class for error-handling
// remark: when creating own exceptions, we must have at least two constructors
// remark: extending "Exception" will make us create a try-catch (mandatory), when we want...
// ... to implement a method that throws this custom Exception (controllable errors).
// remark: to not make try-except mandatory, we can extend from "RuntimeException"
class WrongMailLength extends Exception {

	/**
	 * This is my own exception for handling too short mails (learning exceptions)
	 * Created by: Santiago Garcia Arango Project: Learning Java From Scratch
	 */
	private static final long serialVersionUID = 1L;

	// Constructor 1
	public WrongMailLength() {

	}

	// Constructor 2
	public WrongMailLength(String errorMessageWanted) {
		// Calling parent class constructor
		super(errorMessageWanted);
	}
}
