package com.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.ClientORM;
import com.challenge.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<ClientORM> getClients() {
		// List to get all clients
		List<ClientORM> clients = new ArrayList<ClientORM>();

		// Lambda expression for adding all clients
		clientRepository.findAll().forEach(clients::add);

		return clients;
	}

	public List<ClientORM> getClientByIdParams(String idType, String idValue) {
		return clientRepository.findByIdTypeAndIdValue(idType, idValue);
	}

	public List<ClientORM> getClientsOlderThan(String age) {
		return clientRepository.findByAgeGreaterThan(Integer.parseInt(age));
	}

	public ClientORM addClient(ClientORM clientORM) {
		List<ClientORM> clientsWithSameIdParams = clientRepository.findByIdTypeAndIdValue(clientORM.getIdType(),
				clientORM.getIdValue());

		if (clientsWithSameIdParams.size() == 0) {
			return clientRepository.save(clientORM);
		} else {
			return null;
		}

	}

	public ClientORM updateClient(ClientORM clientORM, String idType, String idValue) {
		List<ClientORM> clientToEdit = clientRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToEdit.size() > 0) {
			clientORM.setId(clientToEdit.get(0).getId());
			return clientRepository.save(clientORM);
		} else {
			return null;
		}

	}

	public String deleteClientByIdParams(String idType, String idValue) {
		List<ClientORM> clientToDelete = clientRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToDelete.size() > 0) {
			clientRepository.deleteById(clientToDelete.get(0).getId());
			return "[Done]";
		} else {
			return null;
		}
	}
}
