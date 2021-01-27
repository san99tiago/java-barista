package oop;

public class UseCar {

	// "main" indicates that it's the first class/method to run in a program
	public static void main(String[] args) {

		// Instantiate of "Car" to create an instance or object of the type "Car"
		Car chevrolet = new Car();
		
		System.out.println(" ---------- MY CAR AT THE BEGGINGING ---------");
		System.out.println(chevrolet.get_all_car_info());
		
		
		System.out.println("\n ...Adding Kms and changing color...\n");
		chevrolet.add_kms(500);
		chevrolet.set_color("black");
		chevrolet.add_kms(1000);
		
		System.out.println(" ---------- MY CAR AFTER USAGE ---------");
		System.out.println(chevrolet.get_all_car_info());

		
	}

}
