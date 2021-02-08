package com.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientORM {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "id_type")
	private String idType;

	@Column(name = "id_value")
	private String idValue;

	@Column(name = "age")
	private int age;

	@Column(name = "born_city")
	private String bornCity;

	public ClientORM() {
	}

	@Override
	public String toString() {
		return "ClientORM [id=" + id + ", name=" + name + ", lastname=" + lastname + ", idType=" + idType + ", idValue="
				+ idValue + ", age=" + age + ", bornCity=" + bornCity + "]";
	}

	public String toJSON() {
		return "{\"id\": \"" + id + "\", \"name\": \"" + name + "\", \"lastname\" :\"" + lastname + "\", \"idType\": \""
				+ idType + "\", \"idValue\": \"" + idValue + "\", \"age\": \"" + age + "\", \"bornCity\": \"" + bornCity
				+ "\"}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBornCity() {
		return bornCity;
	}

	public void setBornCity(String bornCity) {
		this.bornCity = bornCity;
	}

}
