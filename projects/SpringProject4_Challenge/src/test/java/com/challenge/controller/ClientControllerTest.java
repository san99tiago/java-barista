package com.challenge.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.model.ClientORM;
import com.challenge.service.ClientService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClientControllerTest {

	@InjectMocks
	ClientController clientController;

	@Mock
	private ClientService clientService;

	@Test
	void getClientsWithMultipleClientsTest() {
		List<ClientORM> clients = new ArrayList<ClientORM>();
		clients.add(new ClientORM());
		clients.add(new ClientORM());

		when(clientService.getClients()).thenReturn(clients);
		assertEquals(clients.get(0), clientController.getClients().get(0));
		assertEquals(clients.get(1), clientController.getClients().get(1));
		verify(clientService, times(2)).getClients();
	}

	@Test
	void getClientsWithoutAnyClientsTest() {
		when(clientService.getClients()).thenReturn(new ArrayList<ClientORM>());
		assertEquals(0, clientController.getClients().size());
		verify(clientService).getClients();
	}

	@Test
	void getClientByIdParamsWithClientResultTest() {
		List<ClientORM> clients = new ArrayList<ClientORM>();
		clients.add(new ClientORM());

		when(clientService.getClientByIdParams("cc", "2222")).thenReturn(clients);
		assertEquals(clients.get(0), clientController.getClientByIdParams("cc", "2222").get(0));
		verify(clientService).getClientByIdParams("cc", "2222");
	}

	@Test
	void getClientByIdParamsWithoutAnyClientResultTest() {
		when(clientService.getClientByIdParams("cc", "3333")).thenReturn(new ArrayList<ClientORM>());
		assertEquals(0, clientController.getClientByIdParams("cc", "3333").size());
		verify(clientService).getClientByIdParams("cc", "3333");
	}

	@Test
	void getClientsOlderThanWithClientResultTest() {
		List<ClientORM> clients = new ArrayList<ClientORM>();
		clients.add(new ClientORM());
		clients.add(new ClientORM());

		when(clientService.getClientsOlderThan("50")).thenReturn(clients);
		assertEquals(clients.get(0), clientController.getClientsOlderThan("50").get(0));
		assertEquals(clients.get(1), clientController.getClientsOlderThan("50").get(1));
		verify(clientService, times(2)).getClientsOlderThan("50");
	}

	@Test
	void getClientsOlderThanWithoutAnyClientResultTest() {
		when(clientService.getClientsOlderThan("90")).thenReturn(new ArrayList<ClientORM>());
		assertEquals(0, clientController.getClientsOlderThan("90").size());
		verify(clientService).getClientsOlderThan("90");
	}

	@Test
	void addClientTest() {
		ClientORM client = new ClientORM();
		client.setName("Santi");

		when(clientService.addClient(client)).thenReturn(client);
		assertEquals("Santi", clientController.addClient(client).getName());
		verify(clientService).addClient(client);
	}

	@Test
	void addClientThatAlreadyExistsTest() {
		ClientORM client = new ClientORM();
		client.setName("Santi");

		when(clientService.addClient(client)).thenReturn(null);
		assertEquals(null, clientController.addClient(client));
		verify(clientService).addClient(client);
	}

	@Test
	void updateClientTest() {
		ClientORM client = new ClientORM();
		client.setName("Santi");
		client.setIdType("cc");
		client.setIdValue("1234");

		when(clientService.updateClient(client, "cc", "1234")).thenReturn(client);
		assertEquals("Santi", clientController.updateClient(client, "cc", "1234").getName());
		verify(clientService).updateClient(client, "cc", "1234");
	}

	@Test
	void updateClientThatDoesNotExistTest() {
		ClientORM client = new ClientORM();
		client.setName("Santi");

		when(clientService.updateClient(client, "cc", "8778")).thenReturn(null);
		assertEquals(null, clientController.updateClient(client, "cc", "8778"));
		verify(clientService).updateClient(client, "cc", "8778");
	}

	@Test
	void deleteClientTest() {
		when(clientService.deleteClientByIdParams("cc", "8778")).thenReturn("[Done]");
		assertEquals("[Done]", clientController.deleteClientByIdParams("cc", "8778"));
		verify(clientService).deleteClientByIdParams("cc", "8778");
	}

	@Test
	void deleteClientThatDoesNotExistTest() {
		when(clientService.deleteClientByIdParams("cc", "8778")).thenReturn(null);
		assertEquals(null, clientController.deleteClientByIdParams("cc", "8778"));
		verify(clientService).deleteClientByIdParams("cc", "8778");
	}

}
