package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.service.ClientPhotoService;
import com.challenge.service.ClientService;

@Controller
public class FrontController {

	@Autowired
	private ClientService clientService; // Dependency injection

	@Autowired
	private ClientPhotoService clientPhotoService; // Dependency injection

	@RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClients() {
		return clientService.getClients();
	}

	@RequestMapping(value = "/clientphotos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClientPhotos() {
		return clientPhotoService.getClientPhotos();
	}

//	@RequestMapping(value = "/clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String setNewClient(@RequestBody ClientORM clientORM) {
//		return ClientController.setNetClient(clientRepository, clientORM);
//	}
//
//	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String getClientByIdParams(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue) {
//		return clientDaoClass.getClientByIdParams(idType, idValue);
//	}
//
//	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String updateClientByIdParams(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue,
//			@RequestBody String updatedClientInfoJSON) {
//		ClientORM updatedClientORM = getClientFromJSON(updatedClientInfoJSON);
//
//		return clientDaoClass.updateClientByIdParams(idType, idValue, updatedClientORM);
//	}
//
//	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String deleteClientByIdParams(@PathVariable("idType") String idType,
//			@PathVariable("idValue") String idValue) {
//		return clientDaoClass.deleteClientByIdParams(idType, idValue);
//	}

}