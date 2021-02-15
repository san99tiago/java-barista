package com.main.mvc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TestReadDatabase {

	private static String hibernateConfigPathXML = "hibernate.cfg.xml";
	private static List<DeveloperORM> developersList;

	public static void main(String[] args) {

		System.out.println("----- SHOWING ALL DEVELOPERS -----");
		showResults(getDevelopersByHQL("FROM DeveloperORM"));

		System.out.println("----- SHOWING DEVELOPERS WITH LANGUAGE \"PYHTON\" -----");
		showResults(getDevelopersByHQL("FROM DeveloperORM dev where dev.main_language='Python'"));

		System.out.println("----- SHOWING DEVELOPERS WITH LANGUAGE \"JAVA OR JAVASCRIPT\" -----");
		showResults(getDevelopersByHQL(
				"FROM DeveloperORM dev where dev.main_language='Java' or dev.main_language='JavaScript'"));

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

}
