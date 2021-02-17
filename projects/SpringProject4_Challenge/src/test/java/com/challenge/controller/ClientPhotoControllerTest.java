package com.challenge.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.model.ClientPhotoDAO;
import com.challenge.service.ClientPhotoService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ClientPhotoControllerTest {

	@InjectMocks
	ClientPhotoController clientPhotoPhotoController;

	@Mock
	private ClientPhotoService clientPhotoPhotoService;

	@Test
	void getClientPhotosWithMultipleClientPhotosTest() {
		List<ClientPhotoDAO> clientPhotoPhotos = new ArrayList<ClientPhotoDAO>();
		clientPhotoPhotos.add(new ClientPhotoDAO());
		clientPhotoPhotos.add(new ClientPhotoDAO());

		when(clientPhotoPhotoService.getClientPhotos()).thenReturn(clientPhotoPhotos);
		assertEquals(clientPhotoPhotos.get(0), clientPhotoPhotoController.getClientPhotos().get(0));
		assertEquals(clientPhotoPhotos.get(1), clientPhotoPhotoController.getClientPhotos().get(1));
		verify(clientPhotoPhotoService, times(2)).getClientPhotos();
	}

	@Test
	void getClientPhotosWithoutAnyClientPhotosTest() {
		when(clientPhotoPhotoService.getClientPhotos()).thenReturn(new ArrayList<ClientPhotoDAO>());
		assertEquals(0, clientPhotoPhotoController.getClientPhotos().size());
		verify(clientPhotoPhotoService).getClientPhotos();
	}

	@Test
	void addClientPhotoTest() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("1919");
		clientPhoto.setPhoto("image101");

		when(clientPhotoPhotoService.addClientPhoto(clientPhoto)).thenReturn(clientPhoto);
		assertEquals("image101", clientPhotoPhotoController.addClientPhoto(clientPhoto).getPhoto());
		verify(clientPhotoPhotoService).addClientPhoto(clientPhoto);
	}

	@Test
	void addClientPhotoThatAlreadyExistsTest() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("1919");
		clientPhoto.setPhoto("image101");

		when(clientPhotoPhotoService.addClientPhoto(clientPhoto)).thenReturn(null);
		assertEquals(null, clientPhotoPhotoController.addClientPhoto(clientPhoto));
		verify(clientPhotoPhotoService).addClientPhoto(clientPhoto);
	}

	@Test
	void updateClientPhotoTest() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("3322");
		clientPhoto.setPhoto("image387");

		when(clientPhotoPhotoService.updateClientPhoto(clientPhoto, "cc", "image387")).thenReturn(clientPhoto);
		assertEquals("image387",
				clientPhotoPhotoController.updateClientPhoto(clientPhoto, "cc", "image387").getPhoto());
		verify(clientPhotoPhotoService).updateClientPhoto(clientPhoto, "cc", "image387");
	}

	@Test
	void updateClientPhotoThatDoesNotExistTest() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("9010");
		clientPhoto.setPhoto("image387");

		when(clientPhotoPhotoService.updateClientPhoto(clientPhoto, "cc", "9010")).thenReturn(null);
		assertEquals(null, clientPhotoPhotoController.updateClientPhoto(clientPhoto, "cc", "9010"));
		verify(clientPhotoPhotoService).updateClientPhoto(clientPhoto, "cc", "9010");
	}

	@Test
	void deleteClientTest() {
		when(clientPhotoPhotoService.deleteClientPhotoByIdParams("cc", "8778")).thenReturn("[Done]");
		assertEquals("[Done]", clientPhotoPhotoController.deleteClientPhotoByIdParams("cc", "8778"));
		verify(clientPhotoPhotoService).deleteClientPhotoByIdParams("cc", "8778");
	}

	@Test
	void deleteClientThatDoesNotExistTest() {
		when(clientPhotoPhotoService.deleteClientPhotoByIdParams("cc", "8778")).thenReturn(null);
		assertEquals(null, clientPhotoPhotoController.deleteClientPhotoByIdParams("cc", "8778"));
		verify(clientPhotoPhotoService).deleteClientPhotoByIdParams("cc", "8778");
	}

}
