package com.dao;

import com.orm.ClientORM;

public interface ClientDAOInterface {

	public boolean setNewClient(ClientORM newClientORM);
	public String getClients();
<<<<<<< HEAD
	public boolean setNewClient(ClientORM newClient);

=======
	public String getClientByIdParams(String idType, String idValue);
	public String updateClientByIdParams(String idType, String idValue, ClientORM updatedClientORM);
	public String deleteClientByIdParams(String idType, String idValue);
>>>>>>> spring
}
