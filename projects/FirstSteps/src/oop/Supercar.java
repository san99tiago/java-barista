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

	// Getter method for general info
	public String get_all_car_info() {
		return ">>>CAR INFO:\n* Car's wheels: " + String.valueOf(wheels) + "\n* Car's size: " + size
				+ "\n* Car's motor: " + String.valueOf(motor) + "\n* Car's color: " + color + "\n* Car's kms: "
				+ String.valueOf(total_km) + "\n* Turbo Type: " + turboType + "\n* Supercar type: " + supercarType
				+ "\n";
	}

	// Setter method for changing turboType for "Supercar"
	public void setTurboType(String newTurboType) {
		turboType = newTurboType;
	}

	// Cool method
	public void honk() {
		System.out.println("    <<<RRUMMMRRUMM SOUND>>>\n");
	}

}
