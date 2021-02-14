// LEARNING INHERITANCE (CREATE "SUPERCAR" FROM "CAR" CLASS)
// Santiago Garcia Arango

package oop;

public class Supercar extends Car {

	private String turboType;
	private String supercarType;

	public Supercar(int motor, String color, String turboType, String supercarType) {
		// Call superclass (parent) to get its constructor
		super(motor, color);

		// Add extra attributes that only "Supercar" will have
		this.turboType = turboType;
		this.supercarType = supercarType;
	}

	// Getter method for general info overwriting "Car" already created method
	@Override
	public String get_all_car_info() {
		// Call superclass already created info method (to re-use valuable code)
		String general_info = super.get_all_car_info();

		// Add extra info that only "SuperCar" has
		return "\n" + general_info + "\n* Turbo Type:    " + turboType + "\n* Supercar type: " + supercarType + "\n";
	}

	// Setter method for changing turboType for "Supercar"
	public void setTurboType(String newTurboType) {
		turboType = newTurboType;
	}

	// Cool method
	@Override
	public void honk() {
		System.out.println("\n    <<<RRUMMMRRUMM SOUND>>>\n");
	}

}
