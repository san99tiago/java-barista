// MULTIPLE EXCEPTIONS
// Santiago Garcia Arango

package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptions {

	private static int num = 1;
	private static int den = 1;

	public static void main(String[] args) {

		processNumerator();
		processDenominator();
		doDivision();

	}

	// remark: it is important to add the "throws", for custom exception
	public static void doDivision() {
		try {
			double result = num / den * 1.0;
			System.out.println("The result of the division is: " + String.valueOf(result));
		} catch (ArithmeticException e) {
			System.out.println("<Hey Santi, you shouldn't divide by zero>");
			e.printStackTrace();
			main(null);
		}
	}

	public static void processNumerator() {
		// Get user's input for the numerator
		try {
			num = (int) getUserInput("Enter integer numerator:");
		} catch (InputMismatchException e) {
			System.out.println("<Hey Santi, you must enter an integer number>");
			e.printStackTrace();
			processNumerator();
		}
	}

	public static void processDenominator() {
		// Get user's input for the denominator
		try {
			den = (int) getUserInput("Enter integer denominator:");
		} catch (InputMismatchException e) {
			System.out.println("<Hey Santi, you must enter an integer number>");
			e.printStackTrace();
			processDenominator();
		}
	}

	public static int getUserInput(String popUpStringInfo) {
		// Get user's input from terminal
		Scanner entry = new Scanner(System.in);
		System.out.println(popUpStringInfo);
		int number = (int) entry.nextInt();
		entry.close(); // Close Scanner instance to minimize resources
		return number;
	}

}
