// CHALLENGE TO GET OPTIMAL PATH BASED ON MATRIX

public class ChallengeOptimalPath {

	static int[] myArray = { 5, 2, 9, 2, 5, 3, 5, 1, 5 };

	public static void main(String[] args) {
		// Define an array to store the best possible path
		int[] bestValues = { 0, 0, 0 };

		int j = 0; // Variable to keep adding the best values

		int currentIndex = 1; // Variable to know in which of the 3 positions we are
		// For each column, get the best path based on the position
		for (int i = 0; i < 3; i = i + 1) {
			if (currentIndex == 1) {
				int[] currentCol = { myArray[i], myArray[i + 3], myArray[i + 6] };
				currentIndex = getMinIndexFromArray(currentCol);
				bestValues[j] = currentCol[currentIndex];
			} else if (currentIndex == 0) {
				int[] currentCol = { myArray[i], myArray[i + 3], 1000000 };
				currentIndex = getMinIndexFromArray(currentCol);
				bestValues[j] = currentCol[currentIndex];
			} else if (currentIndex == 2) {
				int[] currentCol = { 1000000, myArray[i + 3], myArray[i + 6] };
				currentIndex = getMinIndexFromArray(currentCol);
				bestValues[j] = currentCol[currentIndex];
			}
			j = j + 1;
		}
		System.out.println(bestValues[0] + " " + bestValues[1] + " " + bestValues[2]);
	}

	public static int getMinIndexFromArray(int[] array) {
		int minValue = 1000000;
		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
