package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.model.ClientPhotoDAO;
import com.challenge.repository.ClientPhotoRepository;

@Service
public class ClientPhotoService {

	@Autowired
	private ClientPhotoRepository clientPhotoRepository;

	public List<ClientPhotoDAO> getClientPhotos() {
		return clientPhotoRepository.findAll();
	}

	public List<ClientPhotoDAO> getClientPhotoByIdParams(String idType, String idValue) {
		return clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);
	}

	public ClientPhotoDAO addClientPhoto(ClientPhotoDAO clientPhotoDAO) {
		List<ClientPhotoDAO> clientsWithSameIdParams = clientPhotoRepository
				.findByIdTypeAndIdValue(clientPhotoDAO.getIdType(), clientPhotoDAO.getIdValue());

		if (clientsWithSameIdParams.size() == 0) {
			return clientPhotoRepository.save(clientPhotoDAO);
		} else {
			return null;
		}

	}

	public ClientPhotoDAO updateClientPhoto(ClientPhotoDAO clientPhotoDAO, String idType, String idValue) {
		List<ClientPhotoDAO> clientToEdit = clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToEdit.size() > 0) {
			clientPhotoDAO.setId(clientToEdit.get(0).getId());
			return clientPhotoRepository.save(clientPhotoDAO);
		} else {
			return null;
		}

	}

	public String deleteClientPhotoByIdParams(String idType, String idValue) {
		List<ClientPhotoDAO> clientToDelete = clientPhotoRepository.findByIdTypeAndIdValue(idType, idValue);

		if (clientToDelete.size() > 0) {
			clientPhotoRepository.deleteById(clientToDelete.get(0).getId());
			return "[Done]";
		} else {
			return null;
		}
	}
}
