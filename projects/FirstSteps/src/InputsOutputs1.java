// LEARNING TO WORK WITH SIMPLE I/O CLASSES WITH SCANNER
// Santiago Garcia Arango

import java.util.Scanner;

public class InputsOutputs1 {

	public static void main(String[] args) {
		
		// ----- SCANNER: FIRST WAY OF WORKING WITH INPUTS/OUTPUTS -----
		// Create main class Scanner for handling user input
		Scanner my_input = new Scanner(System.in);

		// Show message on console for getting user's first name
		System.out.println("What's your first name?");

		// Apply "nextLine()" method to get user's STRING input correctly
		String first_name = my_input.nextLine();

		// Show message on console for getting user's last name
		System.out.println("What's your last name?");

		// Apply "nextLine()" method to get user's STRING input correctly
		String last_name = my_input.nextLine();
		
		// Show message on console for getting user's age
		System.out.println("What's your age?");
		
		// Apply "nextInt()" method to get user's INT input correctly
		int age = my_input.nextInt();

		// Show final result in console after getting both user's inputs
		System.out.println("\nThanks, " + first_name + " " + last_name + ". Have a nice day!");
		System.out.println("Next year, you will have " + (age + 1) + " years!");

	}

}
