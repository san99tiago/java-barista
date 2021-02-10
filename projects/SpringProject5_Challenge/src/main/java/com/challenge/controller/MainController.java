package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.model.ClientPhotoORM;
import com.challenge.repository.ClientPhotoRepository;


@Controller
public class MainController {

	@Autowired
	private ClientPhotoRepository clientPhotoRepository; // Dependency injection

	@RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClients() {
		return "TESTING";
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setNewClientBtId(@RequestBody ClientPhotoORM clientPhotoORM) {
		clientPhotoRepository.save(clientPhotoORM);
		return "TESTING CLIENT: " + clientPhotoORM.getId() + "!!!";
	}
	
	

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