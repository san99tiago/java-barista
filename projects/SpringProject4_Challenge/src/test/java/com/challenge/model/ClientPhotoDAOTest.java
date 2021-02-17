package com.challenge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientPhotoDAOTest {

	@Test
	void testClientPhotoORMWithoutAttributes() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();

		assertAll("Should return default values for ClientPhotoORM objects",
				() -> assertEquals(null, clientPhoto.getId()), () -> assertEquals(null, clientPhoto.getIdType()),
				() -> assertEquals(null, clientPhoto.getIdValue()), () -> assertEquals(null, clientPhoto.getPhoto()));
	}

	@Test
	void testClientPhotoORMWithSpecificIdType() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();

		String idType = "cc";
		clientPhoto.setIdType(idType);
		assertEquals(clientPhoto.getIdType(), idType,
				"ClientPhotoORM Object instance with an already set idType, should return given idType in String format");
	}

	@Test
	void testClientPhotoORMWithSpecificIdValue() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();

		String idValue = "cc";
		clientPhoto.setIdValue(idValue);
		assertEquals(clientPhoto.getIdValue(), idValue,
				"ClientPhotoORM Object instance with an already set idValue, should return given idValue in String format");
	}

	@Test
	void testClientPhotoORMWithSpecificPhoto() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();

		String photo = "not added";
		clientPhoto.setPhoto(photo);
		assertEquals(clientPhoto.getPhoto(), photo,
				"ClientPhotoORM Object instance with an already set photo, should return given photo in String format");
	}

	@Test
	void testClientPhotoORMReturnedInJSONFormat() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setId("a1");
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("646464");
		clientPhoto.setPhoto("not added");

		String expectedString = "{\"idType\": \"cc\", \"idValue\": \"646464\", \"photo\": \"not added\"}";

		assertEquals(expectedString, clientPhoto.toJSON(),
				"ClientPhotoORM Object instance should return correct String in JSON format");
	}

	@Test
	void testClientPhotoORMReturnedInStringFormat() {
		ClientPhotoDAO clientPhoto = new ClientPhotoDAO();
		clientPhoto.setId("a1");
		clientPhoto.setIdType("cc");
		clientPhoto.setIdValue("646464");
		clientPhoto.setPhoto("not added");

		String expectedString = "ClientPhotoORM [idType=cc, idValue=646464, photo=not added]";

		assertEquals(expectedString, clientPhoto.toString(),
				"ClientPhotoORM Object instance should return correct String format");
	}

}
