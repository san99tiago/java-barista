package com.challenge.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientORMTest {

	@Test
	void testClientORMWithoutAttributes() {
		ClientORM client = new ClientORM();

		assertAll("Should return default values for ClientORM objects", () -> assertEquals(0, client.getId()),
				() -> assertEquals(null, client.getName()), () -> assertEquals(null, client.getLastname()),
				() -> assertEquals(null, client.getIdType()), () -> assertEquals(null, client.getIdValue()),
				() -> assertEquals(0, client.getAge()), () -> assertEquals(null, client.getBornCity()));
	}

	@Test
	void testClientORMWithSpecificName() {
		ClientORM client = new ClientORM();

		String name = "Santiago";
		client.setName(name);
		assertEquals(client.getName(), name,
				"ClientORM Object instance with an already set name, should return given name in String format");
	}

	@Test
	void testClientORMWithSpecificLastname() {
		ClientORM client = new ClientORM();

		String lastname = "Garcia";
		client.setLastname(lastname);
		assertEquals(client.getLastname(), lastname,
				"ClientORM Object instance with an already set lastname, should return given lastname in String format");
	}

	@Test
	void testClientORMWithSpecificIdType() {
		ClientORM client = new ClientORM();

		String idType = "cc";
		client.setIdType(idType);
		assertEquals(client.getIdType(), idType,
				"ClientORM Object instance with an already set idType, should return given idType in String format");
	}

	@Test
	void testClientORMWithSpecificIdValue() {
		ClientORM client = new ClientORM();

		String idValue = "cc";
		client.setIdValue(idValue);
		assertEquals(client.getIdValue(), idValue,
				"ClientORM Object instance with an already set idValue, should return given idValue in String format");
	}

	@Test
	void testClientORMWithSpecificAge() {
		ClientORM client = new ClientORM();

		int age = 25;
		client.setAge(age);
		assertEquals(client.getAge(), age,
				"ClientORM Object instance with an already set age, should return given age in <int> format");
	}

	@Test
	void testClientORMWithSpecificBornCity() {
		ClientORM client = new ClientORM();

		String bornCity = "Cali";
		client.setBornCity(bornCity);
		assertEquals(client.getBornCity(), bornCity,
				"ClientORM Object instance with an already set bornCity, should return given bornCity in String format");
	}

	@Test
	void testClientORMReturnedInJSONFormat() {
		ClientORM client = new ClientORM();

		client.setId(424242);
		client.setName("Santi");
		client.setLastname("Tech");
		client.setIdType("cc");
		client.setIdValue("6543");
		client.setAge(21);
		client.setBornCity("Medellin");

		String expectedString = "{\"id\": \"424242\", \"name\": \"Santi\", \"lastname\": "
				+ "\"Tech\", \"idType\": \"cc\", \"idValue\": \"6543\", \"age\": "
				+ "\"21\", \"bornCity\": \"Medellin\"}";

		assertEquals(expectedString, client.toJSON(),
				"ClientORM Object instance should return correct String in JSON format");
	}

	@Test
	void testClientORMReturnedInStringFormat() {
		ClientORM client = new ClientORM();

		client.setId(424242);
		client.setName("Santi");
		client.setLastname("Tech");
		client.setIdType("cc");
		client.setIdValue("6543");
		client.setAge(21);
		client.setBornCity("Medellin");

		String expectedString = "ClientORM [id=424242, name=Santi, lastname=Tech, idType="
				+ "cc, idValue=6543, age=21, bornCity=Medellin]";

		assertEquals(expectedString, client.toString(),
				"ClientORM Object instance should return correct String format");
	}
}
