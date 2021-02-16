package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.ClientPhotoORM;
import com.challenge.repository.ClientPhotoRepository;

@Service
public class ClientPhotoService {

	@Autowired
	private ClientPhotoRepository clientPhotoRepository;

	public List<ClientPhotoORM> getClientPhotos() {
		return clientPhotoRepository.findAll();
	}

	public List<ClientPhotoORM> getClientPhotoByIdParams(String idType, String idValue) {
		return clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);
	}

	public ClientPhotoORM addClientPhoto(ClientPhotoORM clientPhotoORM) {
		List<ClientPhotoORM> clientsWithSameIdParams = clientPhotoRepository
				.findByIdTypeAndIdValue(clientPhotoORM.getIdType(), clientPhotoORM.getIdValue());

		if (clientsWithSameIdParams.size() == 0) {
			return clientPhotoRepository.save(clientPhotoORM);
		} else {
			return null;
		}

	}

	public ClientPhotoORM updateClientPhoto(ClientPhotoORM clientPhotoORM, String idType, String idValue) {
		List<ClientPhotoORM> clientToEdit = clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToEdit.size() > 0) {
			clientPhotoORM.setId(clientToEdit.get(0).getId());
			return clientPhotoRepository.save(clientPhotoORM);
		} else {
			return null;
		}

	}

	public String deleteClientPhotoByIdParams(String idType, String idValue) {
		List<ClientPhotoORM> clientToDelete = clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToDelete.size() > 0) {
			clientPhotoRepository.deleteById(clientToDelete.get(0).getId());
			return "[Done]";
		} else {
			return null;
		}
	}
}
