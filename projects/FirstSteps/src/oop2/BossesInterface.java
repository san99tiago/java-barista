// BOSS INTERFACE FOR IMPLEMENTING IN BOSS OBJECT
// Santiago Garcia Arango

package oop2;

// remark: this Interface has a hierarchy from the EmployeesInterface
public interface BossesInterface extends EmployeesInterface {
	// The main goal of this interface is to have a mandatory method...
	// ...for all future objects that are of type "Boss"
	String createMeeting(String meetingName, int year, int month, int day);

	void redeemVacations();
}
