// LEARNING TO WORK WITH SIMPLE I/O CLASSES WITH SWING
// Santiago Garcia Arango

import javax.swing.*;

public class InputsOutputs2 {

	public static void main(String[] args) {

		// ----- SWING: SECOND WAY OF WORKING WITH INPUTS/OUTPUTS -----

		String first_name = JOptionPane.showInputDialog("What's your first name?");
		String last_name = JOptionPane.showInputDialog("What's your last name?");
		String age = JOptionPane.showInputDialog("What's your age?");

		// Show final result in console after getting both user's inputs
		// Remark: it's important to convert age from String to Integer with...
		// ... "Integer.parseInt()"
		System.out.println("\nThanks, " + first_name + " " + last_name + ". Have a nice day!");
		System.out.println("Next year, you will have " + (Integer.parseInt(age) + 1) + " years!");

	}

}
