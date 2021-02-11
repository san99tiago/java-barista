package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.model.ClientPhotoORM;
import com.challenge.service.ClientPhotoService;

@Controller
@RequestMapping(value = "/clientPhotos")
public class ClientPhotoController {

	@Autowired
	private ClientPhotoService clientPhotoService; // Dependency injection

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ClientPhotoORM> getClientPhotos() {
		return clientPhotoService.getClientPhotos();
	}
	
	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ClientPhotoORM> getClientPhotoByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientPhotoService.getClientPhotoByIdParams(idType, idValue);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ClientPhotoORM addClientPhoto(@RequestBody ClientPhotoORM clientPhotoORM) {
		return clientPhotoService.addClientPhoto(clientPhotoORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ClientPhotoORM updateClientPhoto(@RequestBody ClientPhotoORM clientPhotoORM, @PathVariable String idType,
			@PathVariable String idValue) {
		return clientPhotoService.updateClientPhoto(idType, idValue, clientPhotoORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteClientPhotoByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientPhotoService.deleteClientPhotoByIdParams(idType, idValue);
	}
}
