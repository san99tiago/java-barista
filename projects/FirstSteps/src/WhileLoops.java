// BASIC WHILE LOOPS IN JAVA
// Santiago Garcia Arango

import javax.swing.JOptionPane;

public class WhileLoops {

	public static void main(String[] args) {

		String real_password = "Santiago";
		String user_password = "";
		boolean first_flag = false; // Variable to only show error message after first try

		while (real_password.equals(user_password) == false) {

			// Only show incorrect password message after first user's input
			if (first_flag == true) {

				System.out.println("Incorrect password, keep trying!");

			}

			// After first try, turn on first_flag for showing user's errors
			first_flag = true;

			// Keep getting user's password until he/she gets it correctly
			user_password = JOptionPane.showInputDialog("What's your password?");

		}

		System.out.println("\n\n ------- YES, CORRECT PASSWORD! --------");

	}

}
