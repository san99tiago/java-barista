// ONE DIMENSIONAL ARRAYS (VECTORS) IN JAVA
// Santiago Garcia Arango

import javax.swing.JOptionPane;

public class Vectors {

	public static void main(String[] args) {

		String n_string = JOptionPane.showInputDialog("Enter desired vector size");
		int n = Integer.parseInt(n_string);

		// --------- FIRST WAY OF CREATING 1D-MATRICES -----------
		// Create vector of desired size with random numbers between 0-10
		// remark: parenthesis could be "before" of "after" the variable name
		int[] my_vector_1 = new int[n];
		for (int i = 0; i < n; i++) {

			my_vector_1[i] = (int) (Math.random() * 10);

		}

		// Show resulting vector by displaying each item
		System.out.print("\nFIRST VECTOR (random): [");
		for (int i = 0; i < n; i++) {
			System.out.print(" " + my_vector_1[i] + " ");
		}
		System.out.print("]");

		// --------- SECOND WAY OF CREATING 1D-MATRICES -----------
		int[] my_vector_2 = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };

		// Show resulting vector by displaying each item
		System.out.print("\nSECOND VECTOR (Fibonacci): [");
		for (int i = 0; i < my_vector_2.length; i++) {
			System.out.print(" " + my_vector_2[i] + " ");
		}
		System.out.print("]");

		// ----------- CREATING STRING 1D-ARRAY EXAMPLE -----------
		String[] my_languages = new String[5];
		my_languages[0] = "Python";
		my_languages[1] = "JavaScript";
		my_languages[2] = "MATLAB";
		my_languages[3] = "C";
		my_languages[4] = "Java";

		System.out.print("\nMY LANGUAGES: [");
		for (String lang : my_languages) {
			System.out.print(lang + ", ");
		}
		System.out.print("]");

	}
}
