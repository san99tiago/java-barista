// FIRST PACKAGE EXAMPLE (CAR) WITH OBJECT ORIENTED PROGRAMMING
// Santiago Garcia Arango

package oop;

public class Car {

	// Create attributes (better as private) for the car object
	private int wheels;
	private String size;
	private int motor;
	private String color;
	private int total_km;

	// Constructor method must have the same name as class (ex: "Car")
	// remark: both motor and color are passed as parameters for constructor
	public Car(int motor, String color) {
		wheels = 4;
		size = "4059mm x 1735mm x 1506mm";
		this.motor = motor;
		this.color = color;
		total_km = 0;
	}

	// Getter method for wheels (remark: remember to return something)
	public int get_wheels() {
		return wheels;
	}

	// Getter method for size (remark: remember to return something)
	public String get_size() {
		return size;
	}

	// Getter method for motor (remark: remember to return something)
	public int get_motor() {
		return motor;
	}

	// Getter method for color (remark: remember to return something)
	public String get_color() {
		return color;
	}

	// Getter method for total_km (remark: remember to return something)
	public int get_total_km() {
		return this.total_km;
	}

	// Getter method for general info (remark: remember to return something)
	public String get_all_car_info() {
		return "* Car's wheels: " + String.valueOf(wheels) + "\n" + "* Car's size:   " + size + "\n"
				+ "* Car's motor:  " + String.valueOf(motor) + "\n" + "* Car's color:  " + color + "\n"
				+ "* Car's kms:    " + String.valueOf(total_km);
	}

	// Setter method for changing car color
	public void set_color(String color) {
		this.color = color; // Use "this" to reference current object attribute
	}

	// Setter method for adding kilometers of usage
	public void add_kms(int km_to_add) {
		total_km = total_km + km_to_add;
	}
	
	// Cool method
	public void honk() {
		System.out.println("\n  <<<PIIII SOUND>>>\n");
	}

}
