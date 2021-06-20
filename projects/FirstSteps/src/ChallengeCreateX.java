// DRAW AN X BASED ON INPUT N

public class ChallengeCreateX {

	static int n;

	public static void main(String[] args) {
		n = 10;
		if (n == 0) {
			System.out.println("ERROR");
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j || i + j == n - 1) {
						System.out.print("X");
					} else {
						System.out.print("_");
					}
				}
				System.out.println("");
			}
		}
	}

}
