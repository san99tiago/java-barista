// BOSS WITH INHERITANCE FROM EMPLOYEE
// Santiago Garcia Arango

package oop2;

import java.util.Date;
import java.util.GregorianCalendar;

public class Boss extends Employee implements BossesInterface {

	private String extraBenefits;
	private double extraDonationMoney;

	public Boss(String name, String sex, String area, double salary, int year, int month, int day, String extraBenefits,
			double extraDonationMoney) {

		// Call superclass (parent) to get its constructor
		super(name, sex, area, salary, year, month, day);

		this.extraBenefits = extraBenefits;
		this.extraDonationMoney = extraDonationMoney;

	}

	// Getter for all information (this is an abstract class that we must use)
	@Override
	public String getInfo() {
		return super.getInfo() + "* Extra Benefits: " + extraBenefits + "\n* Extra Donation Money: "
				+ String.valueOf(extraDonationMoney) + "\n";
	}

	// Method that must be implemented from the "BossesInterface"
	@Override
	public String createMeeting(String meetingName, int year, int month, int day) {
		// Remark: for GregorianCalendar objects, months start on zero
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		final Date meetingDate;
		meetingDate = calendar.getTime();

		// Create final message, print it in console and return it as well
		final String message = "<---New meeting--->\n  -->created by: " + getName() + "\n  -->For: " + meetingName
				+ "\n  -->Date: " + String.valueOf(meetingDate) + "\n";
		System.out.println(message);
		return message;
	}

	// Method that must be implemented from the "BossesInterface"
	@Override
	public void redeemVacations() {
		System.out.println("<Boss " + super.getName() + " reedeemed vacations>");
	}

	// Method that must be implemented from the "BossesInterface" (extended from...
	// ..."EmployeesInterface") (we overwrite to give special privileges to bosses
	@Override
	public double giveBonus(double bonusAmount) {
		// Create bonus from constant given by the EmployeesInterface and the parameter
		// bonusAmount and add extra bonus for bosses only
		double extraBonusForBosses = 250;
		double totalBonus = super.giveBonus(bonusAmount) + extraBonusForBosses;
		System.out.println("<Boss " + super.getName() + ", got a bonus of " + String.valueOf(totalBonus) + ">");
		return totalBonus;
	}

}
