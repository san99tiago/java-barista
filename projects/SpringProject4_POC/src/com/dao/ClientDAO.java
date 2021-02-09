package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.orm.ClientORM;

@Repository
public class ClientDAO implements ClientDAOInterface {

	private static String hibernateConfigPathXML = "hibernate.cfg.xml";

	@Override
	@Transactional
	public String getClients() {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(ClientORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {
			// Generate Query for accessing database correctly
			Query<ClientORM> myQuery = mySession.createQuery("FROM ClientORM", ClientORM.class);
			List<ClientORM> clientsList = myQuery.getResultList();

			String clientsString = "[";

			for (int i = 0; i < clientsList.size(); i++) {
				if (i == 0) {
					clientsString = clientsString + clientsList.get(i).toJSON();
				} else {
					clientsString = clientsString + ", " + clientsList.get(i).toJSON();
				}
			}
			clientsString = clientsString + "]";

			return clientsString;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}

		return "[{\"message\": \"could not achieve get clients\"}]";
	}

	@Override
	@Transactional
	public String getClientByIdParams(String idType, String idValue) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(ClientORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {
			// Generate Query for accessing database correctly
			Query<ClientORM> myQuery = mySession.createQuery("FROM ClientORM", ClientORM.class);
			List<ClientORM> clientsList = myQuery.getResultList();

			String clientsString = "[";

			for (int i = 0; i < clientsList.size(); i++) {
				if (clientsList.get(i).getIdType().equals(idType) && clientsList.get(i).getIdValue().equals(idValue)) {
					clientsString = clientsString + clientsList.get(i).toJSON();
				}
			}
			clientsString = clientsString + "]";
			return clientsString;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}
		return "[]";

	}

	@Override
	@Transactional
	public String updateClientByIdParams(String idType, String idValue, ClientORM updatedClientORM) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(ClientORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		System.out.println("--- Starting update of client creation to add to database ---");

		try {
			mySession.beginTransaction();

			// Create Hibernate Query Language for getting specific result
			String hqlString = "FROM ClientORM cl WHERE cl.idType='" + updatedClientORM.getIdType()
					+ "' AND cl.idValue='" + updatedClientORM.getIdValue() + "'";
			@SuppressWarnings("unchecked")
			Query<ClientORM> query = mySession.createQuery(hqlString);
			List<ClientORM> clientList = query.list();

			// If the result was successful, change parameters of the updated client
			if (clientList.size() > 0 && idType.equals(updatedClientORM.getIdType())
					&& idValue.equals(updatedClientORM.getIdValue())) {
				int specificId = clientList.get(0).getId();
				ClientORM specificClient = mySession.get(ClientORM.class, specificId);
				specificClient.setName(updatedClientORM.getName());
				specificClient.setLastname(updatedClientORM.getLastname());
				specificClient.setIdType(updatedClientORM.getIdType());
				specificClient.setIdValue(updatedClientORM.getIdValue());
				specificClient.setAge(updatedClientORM.getAge());
				specificClient.setBornCity(updatedClientORM.getBornCity());
				mySession.getTransaction().commit();

				System.out.println("[SUCCEDED: Client updated correctly]");
				return "[SUCCEDED: Client updated correctly]";
			}
			System.out.println("[WARNING: There was a problem in the update of the client]");
			return "[WARNING: There was a problem in the update of the client]";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mySession.close();
			myFactory.close();
		}
		System.out.println("[WARNING: There was a problem in the update of the client]");
		return "[WARNING: There was a problem in the update of the client]";

	}

	@Override
	public boolean setNewClient(ClientORM newClientORM) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(ClientORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		// Generate Query for accessing database correctly
		Query<ClientORM> myQuery = mySession.createQuery("FROM ClientORM", ClientORM.class);
		List<ClientORM> clientsList = myQuery.getResultList();

		System.out.println("--- Starting new client creation to add to database ---");

		boolean hasClient = false;
		for (int i = 0; i < clientsList.size(); i++) {
			if (clientsList.get(i).getIdType().toString().equals(newClientORM.getIdType().toString())
					&& clientsList.get(i).getIdValue().toString().equals(newClientORM.getIdValue().toString())) {
				System.out.println(" --- User already exists ---");
				hasClient = true;
			}
		}

		// Only add new client if it is not already created
		if (hasClient == false) {
			mySession.beginTransaction();
			mySession.save(newClientORM);
			mySession.getTransaction().commit();
			mySession.close();
			System.out.println("--- Added new client succesfully to database ---");
			return true;
		}

		return false;
	}

	@Override
	@Transactional
	public String deleteClientByIdParams(String idType, String idValue) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure(hibernateConfigPathXML)
				.addAnnotatedClass(ClientORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		System.out.println("--- Starting delete of client in database ---");

		try {
			mySession.beginTransaction();

			// Create Hibernate Query Language for getting specific result
			String hqlString = "DELETE ClientORM cl WHERE cl.idType='" + idType + "' AND cl.idValue='" + idValue + "'";
			@SuppressWarnings("unchecked")
			Query<ClientORM> query = mySession.createQuery(hqlString);
			int res = query.executeUpdate();

			if (res > 0) {
				System.out.println("[SUCCEDED: Client updated correctly]");
				return "[SUCCEDED: Client deleted correctly]";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mySession.close();
			myFactory.close();
		}
		System.out.println("[WARNING: There was a problem in the delete of the client]");
		return "[WARNING: There was a problem in the delete of the client]";

	}

}
