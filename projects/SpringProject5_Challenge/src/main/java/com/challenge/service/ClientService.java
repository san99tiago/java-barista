package com.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.ClientORM;
import com.challenge.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public String getClients() {
		Iterable<ClientORM> clients = clientRepository.findAll();

		String returnString = "[";
		for (ClientORM c : clients) {
			returnString = returnString + c.toJSON();
		}
		returnString = returnString + "]";

		return returnString;
	}

	public String setNetClient(ClientRepository clientRepository, ClientORM clientORM) {
		clientRepository.save(clientORM);
		return "NOT DEVELOPED YET";
	}
}
