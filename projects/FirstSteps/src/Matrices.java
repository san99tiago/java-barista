// TWO DIMENSIONAL ARRAYS (MATRICES) IN JAVA
// Santiago Garcia Arango

import javax.swing.JOptionPane;

public class Matrices {

	public static void main(String[] args) {

		// Get user's input for rows and columns
		String rows_string = JOptionPane.showInputDialog("Enter desired matrix rows...");
		int rows = Integer.parseInt(rows_string);

		String columns_string = JOptionPane.showInputDialog("Enter desired matrix columns...");
		int columns = Integer.parseInt(columns_string);

		int[][] my_matrix = new int[rows][columns];

		// Create matrix of given rows/columns with random numbers
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {

				my_matrix[i][j] = (int) (Math.random() * 9);

			}
		}

		// Show generated matrix
		for (int i = 0; i < rows; i++) {

			System.out.println("");
			for (int j = 0; j < columns; j++) {

				System.out.print(" " + my_matrix[i][j] + " ");

			}
		}

	}

}
