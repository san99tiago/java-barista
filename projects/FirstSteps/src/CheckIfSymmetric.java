// Check if given vector is symmetic

public class CheckIfSymmetric {

	static String[] myArray = {"a", "b", "c", "d", "d", "c", "b", "a"};

	public static void main(String[] args) {
		checkIfSymmetric(myArray);
	}

	public static void checkIfSymmetric(String[] array) {
		boolean isSymmetric = true;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array[array.length - 1 - i]) {
				isSymmetric = false;
			}
		}
		
		if (isSymmetric) {
			System.out.print("Symmetric");
		}
		else {
			System.out.println("Asymmetric");
		}
		
	}

}
