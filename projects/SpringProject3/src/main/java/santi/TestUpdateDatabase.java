package main.java.santi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestUpdateDatabase {

	private static String hibernateConfigPathXML = "hibernate.cfg.xml";
	private static List<DeveloperORM> developersList;

	public static void main(String[] args) {

		System.out.println("----- SHOWING ALL DEVELOPERS -----");
		showResults(getDevelopersByHQL("FROM DeveloperORM"));

		changeDevelopersName("Santiago Garcia", "Santi Garci");

		System.out.println("----- SHOWING ALL DEVELOPERS -----");
		showResults(getDevelopersByHQL("FROM DeveloperORM"));

		changeDevelopersName("Santi Garci", "Santiago Garcia");

		System.out.println("----- SHOWING ALL DEVELOPERS -----");
		showResults(getDevelopersByHQL("FROM DeveloperORM"));

	}

	public static void showResults(List<DeveloperORM> listToIterate) {
		for (DeveloperORM specificDeveloperORM : listToIterate) {
			System.out.println(specificDeveloperORM);
		}
	}

	public static List<DeveloperORM> getDevelopersByHQL(String hqlString) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(DeveloperORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {
			mySession.beginTransaction();

			// Create Hibernate Query Language for getting specific result
			@SuppressWarnings("unchecked")
			Query<DeveloperORM> query = mySession.createQuery(hqlString);
			developersList = query.list();

			mySession.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}
		return developersList;
	}

	public static void changeDevelopersName(String originalName, String finalName) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(DeveloperORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {
			mySession.beginTransaction();

			// Create Hibernate Query Language for getting specific result
			String hqlString = "FROM DeveloperORM dev WHERE dev.name='" + originalName + "'";
			@SuppressWarnings("unchecked")
			Query<DeveloperORM> query = mySession.createQuery(hqlString);
			developersList = query.list();

			// If the result was successful, change name to the new one
			if (developersList.size() > 0) {
				int specificId = developersList.get(0).getId();
				DeveloperORM specificDev = mySession.get(DeveloperORM.class, specificId);
				specificDev.setName(finalName);
				mySession.getTransaction().commit();

				System.out.println("\n>>> Successfully changed '" + originalName + "' to '" + finalName + "'\n");
			}

			mySession.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}
	}

}
