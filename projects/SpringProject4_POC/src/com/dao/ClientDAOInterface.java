package com.dao;

import com.orm.ClientORM;

public interface ClientDAOInterface {

	public String getClients();
	boolean setNewClient(ClientORM newClientORM);
}
