package com.challenge.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "base64")
public class ClientPhotoDAO {

	@Id
	private String id;

	private String idValue;
	private String idType;
	private String photo;

	public ClientPhotoDAO() {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClientPhotoORM [idType=" + idType + ", idValue=" + idValue + ", photo=" + photo + "]";
	}
	
	public String toJSON() {
		return "{\"idType\": \"" + idType + "\", \"idValue\": \"" + idValue + "\", \"photo\": \"" + photo + "\"}";	};
}