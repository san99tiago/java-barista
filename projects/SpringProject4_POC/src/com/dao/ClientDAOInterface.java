package com.dao;

import com.orm.ClientORM;

public interface ClientDAOInterface {

	public String getClients();
	public boolean setNewClient(ClientORM newClient);
}
