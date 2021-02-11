package com.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.ClientPhotoORM;
import com.challenge.repository.ClientPhotoRepository;

@Service
public class ClientPhotoService {

	@Autowired
	private ClientPhotoRepository clientPhotoRepository;

	public  String getClientPhotos() {
		Iterable<ClientPhotoORM> clientphotos = clientPhotoRepository.findAll();

		String returnString = "[";
		for (ClientPhotoORM c : clientphotos) {
			returnString = returnString + c.toJSON();
		}
		returnString = returnString + "]";

		return returnString;
	}

	public String setNetClientPhoto(ClientPhotoORM clientPhotoORM) {
//		clientRepository.save(clientPhotoORM);
		return "NOT DEVELOPED YET";
	}
}
