// FAILURE EXCEPTIONS
// Santiago Garcia Arango

package exceptions;

public class OutOfBounds {

	public static void main(String[] args) {
		// Run test with or without exception (must change true/false to see)
		test1(false); // true/false (to test)
	}

	public static void test1(boolean hasException) {
		int[] myMatrix = new int[5];
		myMatrix[0] = 5;
		myMatrix[1] = 38;
		myMatrix[2] = 15;
		myMatrix[3] = 92;
		myMatrix[4] = 71;
		if (hasException) {
			System.out.println("<<<We will have an Exception...>>>\n\n");
			myMatrix[5] = 81;
		}

		System.out.print("myMatrix: [ ");
		for (int i = 0; i < 5; i++) {
			System.out.print(myMatrix[i] + ", ");
		}
		System.out.println("]");
	}
}