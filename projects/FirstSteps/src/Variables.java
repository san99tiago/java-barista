// PLAYING WITH VARIABLES IN JAVA
// Santiago Garcia Arango

public class Variables {

	public static void main(String[] args) {

		System.out.println("\n------BASIC VARIABLES EXAMPLES------");
		short age; // Example 1: declaration and initialization in different lines
		age = 21;
		System.out.println(age);

		age = 75;
		System.out.println(age);

		String color = "red"; // Example 2: declaration and initialization in same line
		System.out.println(color);

		System.out.println("\n------MATH CLASS EXAMPLES------");
		final int a = 9;
		final int b = 3;
		double c = a - b;
		System.out.println("Initial a: " + a);
		System.out.println("Initial b: " + b);
		System.out.println("Initial c: " + c);

		// Change "c" variable multiple times in different ways
		c++;
		System.out.println("New c (after c++): " + c);
		c = Math.pow(a, b); // Convert to double (for correct arguments in "pow" method)
		System.out.println("Final c [after c = Math.pow(a, b)]: " + c);
		c = c + Math.PI;
		System.out.println("Final c [after c = c + Math.PI]: " + c);
		c = Math.round(c);
		System.out.println("Final c [after c = Math.round(c)]: " + c);
		c = Math.sqrt(c);
		System.out.println("Final c [after c = Math.sqrt(c)]: " + c);

		System.out.println("\n------STRING CLASS EXAMPLES------");
		String my_name = "Santiago Garcia Arango";
		System.out.println("my_name: " + my_name);
		System.out.println("my_name.length(): " + my_name.length());
		System.out.println("my_name.charAt(0): " + my_name.charAt(0));
		System.out.println("my_name.charAt(1): " + my_name.charAt(1));
		System.out.println("my_name.charAt(2): " + my_name.charAt(2));
		System.out.println("my_name.charAt(my_name.length() - 1): " + my_name.charAt(my_name.length() - 1));
		System.out.println("my_name.substring(0, 7): " + my_name.substring(0, 8));

	}

}
