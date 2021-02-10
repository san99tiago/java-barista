package com.challenge.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "base64")
public class ClientPhotoORM {

	@Id
	private int id;

	private String idValue;
	private String idType;
	private String photo;

	public ClientPhotoORM() {
	}

	public ClientPhotoORM(String idType, String idValue, String photo) {
		this.idType = idType;
		this.idValue = idValue;
		this.photo = photo;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String iidType) {
		this.idType = iidType;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClientPhotoORM [id=" + id + ", idValue=" + idValue + ", idType=" + idType + ", photo=" + photo + "]";
	}

}