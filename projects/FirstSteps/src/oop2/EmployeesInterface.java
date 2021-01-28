// EMPLOYEES INTERFACE FOR IMPLEMENTING IN EMPLOYEE OBJECT
// Santiago Garcia Arango

package oop2;

public interface EmployeesInterface {
	// The main goal of this interface is to have a mandatory method...
	// ...for all future objects that are of type "Employees" (or inherit from it)
	double giveBonus(double bonusAmount);

	double BASE_BONUS_AMOUNT = 100;
}
