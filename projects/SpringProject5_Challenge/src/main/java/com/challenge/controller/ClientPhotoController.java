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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/clientPhotos")
@Api(tags = "clientPhotos")
public class ClientPhotoController {

	@Autowired
	private ClientPhotoService clientPhotoService; // Dependency injection

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get all clientPhotos.")
	public List<ClientPhotoORM> getClientPhotos() {
		return clientPhotoService.getClientPhotos();
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get clientPhoto by ID parameters.", notes = "Both (idType) and (idValue) are mandatory.")
	public List<ClientPhotoORM> getClientPhotoByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientPhotoService.getClientPhotoByIdParams(idType, idValue);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Add new clientPhoto.", notes = "If the clientPhto exists, it won't create duplicates.")
	public ClientPhotoORM addClientPhoto(@RequestBody ClientPhotoORM clientPhotoORM) {
		return clientPhotoService.addClientPhoto(clientPhotoORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Update existing clientPhoto by ID parameters.", notes = "If the clientPhoto doesn't exist, it won't create a new one.")
	public ClientPhotoORM updateClientPhoto(@RequestBody ClientPhotoORM clientPhotoORM, @PathVariable String idType,
			@PathVariable String idValue) {
		return clientPhotoService.updateClientPhoto(idType, idValue, clientPhotoORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Delete existing clientPhoto by ID parameters.", notes = "It will only return a (Done) message, when the clientPhoto existed.")
	public String deleteClientPhotoByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientPhotoService.deleteClientPhotoByIdParams(idType, idValue);
	}
}
