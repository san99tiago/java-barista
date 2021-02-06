// TEST CORRECT DEVELOPERS ADDED TO THE DATABASE VIA ORM
// Santiago Garcia Arango

package com.test.mvc;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class testDeveloperORM {

	public static void main(String[] args) {

		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(DeveloperORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {

			System.out.println("--- Starting testDevObj creation to add to database ---");
			DeveloperORM testDevObj = new DeveloperORM(chooseRandomName(), chooseRandomLanguage(),
					generateRandomBirthdayDate(), getCurrentDate());

			mySession.beginTransaction();
			mySession.save(testDevObj);
			mySession.getTransaction().commit();
			mySession.close();

			System.out.println("--- Added testDevObj succesfully to database ---");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}
	}

	public static String chooseRandomName() {
		String[] names = { "Santiago", "Monica", "David", "Laura", "Elkin", "Valentina", "Esteban", "Melissa", "Yesid",
				"Camila", "Daniel", "Mariana", "Miguel", "Daniela", "Jorge", "Adriana", "Carlos", "Yessica", "Alex" };
		String[] lastnames = { "Garcia", "Arango", "Hill", "Donadio", "Lopez", "Giraldo", "Guerra", "Galeano", "Yepes",
				"Ruiz", "Toro", "Mejia", "Palacio", "Diaz", "Arauca", "Villamil", "Suarez", "Maldonado", "Gutierrez" };

		String selectedName = names[(int) (Math.random() * names.length - 1)];
		String selectedLastname = lastnames[(int) (Math.random() * lastnames.length - 1)];

		return selectedName + " " + selectedLastname;
	}

	public static String chooseRandomLanguage() {
		String[] languages = { "Python", "Java", "R", "Ruby", "C", "MATLAB", "JavaScript", "PHP", "GO", "KOTLIN" };
		String selectedLanguage = languages[(int) (Math.random() * languages.length - 1)];
		return selectedLanguage;
	}

	public static LocalDate generateRandomBirthdayDate() {
		LocalDate todayLocalDate = LocalDate.now();
		int yearsToSubstract = (int) (Math.random() * 30 + 20);
		int monthsToSubstract = (int) (Math.random() * 12);
		int daysToSubstract = (int) (Math.random() * 30);
		return todayLocalDate.minusDays(daysToSubstract).minusMonths(monthsToSubstract).minusYears(yearsToSubstract);
	}

	public static LocalDate getCurrentDate() {
		LocalDate todayLocalDate = LocalDate.now();
		return todayLocalDate;
	}

}
