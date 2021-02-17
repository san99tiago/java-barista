package com.challenge.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.model.ClientPhotoDAO;
import com.challenge.repository.ClientPhotoRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClientPhotoServiceTest {

	@InjectMocks
	ClientPhotoService clientPhotoService;

	@Mock
	ClientPhotoRepository clientPhotoRepository;

	@Test
	@DisplayName("Test should verify correct implementation of get clientphotos service")
	void getClientPhotosTest() {
		clientPhotoService.getClientPhotos();
		verify(clientPhotoRepository).findAll();
	}

	@Test
	void getClientPhotosByIdParamsTest() {
		String idType = "cc";
		String idValue = "1234";
		clientPhotoService.getClientPhotoByIdParams(idType, idValue);
		verify(clientPhotoRepository).findByIdTypeAndIdValue(idType, idValue);
	}

	@Test
	void addClientPhotoTest() {
		// Create clientPhotoMockORM to simulate object's behavior
		ClientPhotoDAO clientPhotoMockORM = mock(ClientPhotoDAO.class);
		when(clientPhotoMockORM.getIdType()).thenReturn("cc");
		when(clientPhotoMockORM.getIdValue()).thenReturn("1111");
		when(clientPhotoMockORM.getPhoto()).thenReturn("not added");

		clientPhotoService.addClientPhoto(clientPhotoMockORM);
		verify(clientPhotoRepository).save(clientPhotoMockORM);
	}

	@Test
	void addClientPhotoWithAlreadyExistingClientPhotoTest() {
		// Create clientPhotoMockORM to simulate object's behavior
		ClientPhotoDAO clientPhotoMockORM = mock(ClientPhotoDAO.class);
		when(clientPhotoMockORM.getIdType()).thenReturn("cc");
		when(clientPhotoMockORM.getIdValue()).thenReturn("1111");
		when(clientPhotoMockORM.getPhoto()).thenReturn("not added");

		// Create expected behavior for clientPhotoRepository when finding by id
		// parameters
		List<ClientPhotoDAO> clientsWithIdParamsMock = new ArrayList<ClientPhotoDAO>();
		clientsWithIdParamsMock.add(clientPhotoMockORM);
		when(clientPhotoRepository.findByIdTypeAndIdValue("cc", "1111")).thenReturn(clientsWithIdParamsMock);

		clientPhotoService.addClientPhoto(clientPhotoMockORM);
		verify(clientPhotoRepository, never()).save(clientPhotoMockORM);
	}

	@Test
	void updateClientPhotoTest() {
		// Create clientPhotoMockORM to simulate object's behavior
		ClientPhotoDAO clientPhotoMockORM = mock(ClientPhotoDAO.class);
		when(clientPhotoMockORM.getIdType()).thenReturn("cc");
		when(clientPhotoMockORM.getIdValue()).thenReturn("1111");
		when(clientPhotoMockORM.getPhoto()).thenReturn("not added");

		// Create expected behavior for clientPhotoRepository when finding by id
		// parameters
		List<ClientPhotoDAO> clientPhotosWithIdParamsMock = new ArrayList<ClientPhotoDAO>();
		clientPhotosWithIdParamsMock.add(clientPhotoMockORM);
		when(clientPhotoRepository.findByIdTypeAndIdValue("cc", "1111")).thenReturn(clientPhotosWithIdParamsMock);

		clientPhotoService.updateClientPhoto(clientPhotoMockORM, "cc", "1111");
		verify(clientPhotoRepository).save(clientPhotoMockORM);
	}

	@Test
	void updateClientPhotoWithoutExistingClientPhotoTest() {
		// Create clientPhotoMockORM to simulate object's behavior
		ClientPhotoDAO clientPhotoMockORM = mock(ClientPhotoDAO.class);
		when(clientPhotoMockORM.getIdType()).thenReturn("cc");
		when(clientPhotoMockORM.getIdValue()).thenReturn("1111");
		when(clientPhotoMockORM.getPhoto()).thenReturn("not added");

		when(clientPhotoRepository.findByIdTypeAndIdValue("cc", "1111")).thenReturn(new ArrayList<ClientPhotoDAO>());

		clientPhotoService.updateClientPhoto(clientPhotoMockORM, "cc", "1111");
		verify(clientPhotoRepository, never()).save(clientPhotoMockORM);
	}

	@Test
	void deleteClientPhotoTest() {
		// Create clientPhotoMockORM to simulate object's behavior
		ClientPhotoDAO clientPhotoMockORM = mock(ClientPhotoDAO.class);
		when(clientPhotoMockORM.getId()).thenReturn("abcd1234");

		// Create expected behavior for clientPhotoRepository when finding by id
		// parameters
		List<ClientPhotoDAO> clientPhotosWithIdParamsMock = new ArrayList<ClientPhotoDAO>();
		clientPhotosWithIdParamsMock.add(clientPhotoMockORM);
		when(clientPhotoRepository.findByIdTypeAndIdValue("cc", "2222")).thenReturn(clientPhotosWithIdParamsMock);

		clientPhotoService.deleteClientPhotoByIdParams("cc", "2222");
		verify(clientPhotoRepository).deleteById("abcd1234");
	}

	@Test
	void deleteClientPhotoWithouExistingClientPhotoTest() {
		when(clientPhotoRepository.findByIdTypeAndIdValue("cc", "2222")).thenReturn(new ArrayList<ClientPhotoDAO>());

		clientPhotoService.deleteClientPhotoByIdParams("cc", "2222");
		verify(clientPhotoRepository, never()).deleteById("abcd1234");
	}

}
