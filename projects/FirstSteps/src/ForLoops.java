import java.util.Iterator;

// BASIC FOR LOOPS IN JAVA
// Santiago Garcia Arango

public class ForLoops {

	public static void main(String[] args) {
		
		// Generate random number between 1 and 100
		int random_number = (int)(Math.random() * 99 + 1);
		
//		System.out.println(random_number);
		
		// Show specific iteration in console
		for (int i=0; i<random_number; i++) {
			System.out.println(i + ". My name is Santiago Garcia!");
		}
		
	}

}
