// INPUT-MISSMATCH OWN CREATED EXCEPTION
// Santiago Garcia Arango

package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMissmatchError {

	public static void main(String[] args) {

		try {
			test();
		} catch (InputMismatchException e) {
			System.out.println(e.toString());
			System.out.println("<Age wasn't loaded correctly. Try again later>");
		}
		System.out.println("Program execution ended.");

	}

	// remark: it is important to add the "throws", for custom exception
	public static void test() throws InputMismatchException {
		// Get user's input from terminal
		@SuppressWarnings("resource")
		Scanner entry = new Scanner(System.in);
		System.out.println("What's your age?");
		int age = entry.nextInt();
		System.out.println("Age added correctly.");
		System.out.println("Hey Santi, next year you will be " + String.valueOf(age + 1) + " years!");
	}
}
