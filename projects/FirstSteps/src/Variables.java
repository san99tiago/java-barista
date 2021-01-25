
public class Variables {

	public static void main(String[] args) {

		// Example 1: declaration and initialization in different lines
		short age;
		age = 21;
		System.out.println(age);

		age = 75;
		System.out.println(age);

		// Example 2: declaration and initialization in same line
		String color = "red";
		System.out.println(color);
		
		// Example 3: playing with variables
		int a = 9;
		int b = 3;
		double c = a - b;
		System.out.println(c);

		// Change variables by multiple methods
		c++;
		System.out.println(c);
		c = Math.pow(a, b);
		System.out.println(c);

	}

}
