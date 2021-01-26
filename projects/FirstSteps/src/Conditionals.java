// CONDITIONALS IN JAVA
// Santiago Garcia Arango

import javax.swing.JOptionPane;

public class Conditionals {

	public static void main(String[] args) {

		String age_string = JOptionPane.showInputDialog("What's your age?");
		int age = Integer.parseInt(age_string);

		if (age >= 21) {

			System.out.println("You are an adult worldwide!");

		} else if (age >= 18) {

			System.out.println("You are an adult in most latin-american countries!");

		} else {

			System.out.println("You are NOT an adult!");

		}

	}

}
