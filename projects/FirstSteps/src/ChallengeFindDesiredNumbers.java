// CHALLENGE FIND FIRST TWO NUMBERS THAT SUM TO A DESIRED ONE IN ARRAY

public class ChallengeFindDesiredNumbers {

	static int[] myArray = { 1, 3, 5, 2, 7, 0 };

	public static void main(String[] args) {

		int desiredNumber = 10;
		boolean alreadyFound = false;

		for (int i = 0; i < myArray.length - 1; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (alreadyFound == false && myArray[i] + myArray[j] == desiredNumber) {
					System.out.print(myArray[i] + " " + myArray[j]);
					alreadyFound = true;
				}
			}
		}

	}

}
