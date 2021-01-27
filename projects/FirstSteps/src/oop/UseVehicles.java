// LEARNING INHERITANCE (USE "SUPERCAR" FROM "CAR" CLASS)
// Santiago Garcia Arango

package oop;

public class UseVehicles {

	public static void main(String[] args) {

		// Create both objects instances ("Car" and "Supercar")
		Car myCar = new Car(1600, "gray");
		Supercar mySupercar = new Supercar(3400, "red", "V12-super", "A-class-champion");

		System.out.println(" ---------- MY VEHICLES AT THE BEGGINGING ---------");
		System.out.println(myCar.get_all_car_info());
		System.out.println(mySupercar.get_all_car_info());

		System.out.println("\n--> ...Adding Kms, honk-sounds and changing stuff...\n");
		myCar.add_kms(500);
		myCar.honk();
		myCar.set_color("black");
		myCar.add_kms(1000);
		mySupercar.add_kms(5000);
		mySupercar.honk();
		mySupercar.set_color("black");
		mySupercar.setTurboType("V-18-hyper");
		mySupercar.add_kms(2500);

		System.out.println(" ---------- MY VEHICLES AT THE END ---------");
		System.out.println(myCar.get_all_car_info());
		System.out.println(mySupercar.get_all_car_info());

	}

}
