// Sample exercise to count total boxes

public class CountBoxes {

	static int elementcount = 9;

	public static void main(String[] args) {
		getTotalBoxes(elementcount);
	}

	public static void getTotalBoxes(int elementcount) {
		int bigBoxes = elementcount / 5;
		int smallBoxes = elementcount - bigBoxes * 5;
		System.out.print(smallBoxes);
	}
}
