package com.challenge.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.model.ClientORM;
import com.challenge.repository.ClientRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ClientServiceTest {

	@InjectMocks
	ClientService clientService;

	@Mock
	ClientRepository clientRepository;

	@Test
	@DisplayName("Test should verify correct implementation of get clients service")
	void getClientsTest() {
		clientService.getClients();
		verify(clientRepository).findAll();
	}

	@Test
	void getClientsByIdParamsTest() {
		String idType = "cc";
		String idValue = "1234";
		clientService.getClientByIdParams(idType, idValue);
		verify(clientRepository).findByIdTypeAndIdValue(idType, idValue);
	}

	@Test
	void getClientsOlderThanTest() {
		String age = "50";
		clientService.getClientsOlderThan(age);
		verify(clientRepository).findByAgeGreaterThan(Integer.parseInt(age));
	}

	@Test
	void addClientTest() {
		// Create clientMockORM to simulate object's behavior
		ClientORM clientMockORM = mock(ClientORM.class);
		when(clientMockORM.getName()).thenReturn("Wilson");
		when(clientMockORM.getLastname()).thenReturn("Palencia");
		when(clientMockORM.getIdType()).thenReturn("cc");
		when(clientMockORM.getIdValue()).thenReturn("8888");
		when(clientMockORM.getAge()).thenReturn(50);
		when(clientMockORM.getBornCity()).thenReturn("Pasto");

		clientService.addClient(clientMockORM);
		verify(clientRepository).save(clientMockORM);
	}

	@Test
	void addClientWithAlreadyExistingClientTest() {
		// Create clientMockORM to simulate object's behavior
		ClientORM clientMockORM = mock(ClientORM.class);
		when(clientMockORM.getName()).thenReturn("Laura");
		when(clientMockORM.getLastname()).thenReturn("Rendon");
		when(clientMockORM.getIdType()).thenReturn("cc");
		when(clientMockORM.getIdValue()).thenReturn("4545");
		when(clientMockORM.getAge()).thenReturn(25);
		when(clientMockORM.getBornCity()).thenReturn("Sabaneta");

		// Create expected behavior for clientRepository when finding by id parameters
		List<ClientORM> clientsWithIdParamsMock = new ArrayList<ClientORM>();
		clientsWithIdParamsMock.add(clientMockORM);
		when(clientRepository.findByIdTypeAndIdValue("cc", "4545")).thenReturn(clientsWithIdParamsMock);

		clientService.addClient(clientMockORM);
		verify(clientRepository, never()).save(clientMockORM);
	}

	@Test
	void updateClientTest() {
		// Create clientMockORM to simulate object's behavior
		ClientORM clientMockORM = mock(ClientORM.class);
		when(clientMockORM.getName()).thenReturn("Wilson");
		when(clientMockORM.getLastname()).thenReturn("Palencia");
		when(clientMockORM.getIdType()).thenReturn("cc");
		when(clientMockORM.getIdValue()).thenReturn("8888");
		when(clientMockORM.getAge()).thenReturn(50);
		when(clientMockORM.getBornCity()).thenReturn("Pasto");

		// Create expected behavior for clientRepository when finding by id parameters
		List<ClientORM> clientsWithIdParamsMock = new ArrayList<ClientORM>();
		clientsWithIdParamsMock.add(clientMockORM);
		when(clientRepository.findByIdTypeAndIdValue("cc", "8888")).thenReturn(clientsWithIdParamsMock);

		clientService.updateClient("cc", "8888", clientMockORM);
		verify(clientRepository).save(clientMockORM);
	}

	@Test
	void updateClientWithouExistingClientToDeleteTest() {
		// Create clientMockORM to simulate object's behavior
		ClientORM clientMockORM = mock(ClientORM.class);
		when(clientMockORM.getName()).thenReturn("Wilson");
		when(clientMockORM.getLastname()).thenReturn("Palencia");
		when(clientMockORM.getIdType()).thenReturn("cc");
		when(clientMockORM.getIdValue()).thenReturn("8888");
		when(clientMockORM.getAge()).thenReturn(50);
		when(clientMockORM.getBornCity()).thenReturn("Pasto");

		when(clientRepository.findByIdTypeAndIdValue("cc", "8888")).thenReturn(new ArrayList<ClientORM>());

		clientService.updateClient("cc", "8888", clientMockORM);
		verify(clientRepository, never()).save(clientMockORM);
	}

	@Test
	void deleteClientTest() {
		// Create clientMockORM to simulate object's behavior
		ClientORM clientMockORM = mock(ClientORM.class);
		when(clientMockORM.getId()).thenReturn(8);

		// Create expected behavior for clientRepository when finding by id parameters
		List<ClientORM> clientsWithIdParamsMock = new ArrayList<ClientORM>();
		clientsWithIdParamsMock.add(clientMockORM);
		when(clientRepository.findByIdTypeAndIdValue("cc", "8888")).thenReturn(clientsWithIdParamsMock);

		clientService.deleteClientByIdParams("cc", "8888");
		verify(clientRepository).deleteById(8);
	}

	@Test
	void deleteClientWithouClientToDeleteTest() {
		when(clientRepository.findByIdTypeAndIdValue("cc", "8888")).thenReturn(new ArrayList<ClientORM>());

		clientService.deleteClientByIdParams("cc", "8888");
		verify(clientRepository, never()).deleteById(8);
	}

}
