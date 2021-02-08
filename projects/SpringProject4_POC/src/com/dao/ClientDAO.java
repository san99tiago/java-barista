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
	}

}
