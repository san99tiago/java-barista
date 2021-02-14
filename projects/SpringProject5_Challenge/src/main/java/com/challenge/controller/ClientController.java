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

import com.challenge.model.ClientORM;
import com.challenge.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/clients")
@Api(tags = "clients")
public class ClientController {

	@Autowired
	private ClientService clientService; // Dependency injection

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get all clients.")
	public List<ClientORM> getClients() {
		return clientService.getClients();
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get client by ID parameters.", notes = "Both (idType) and (idValue) are mandatory.")
	public List<ClientORM> getClientByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientService.getClientByIdParams(idType, idValue);
	}

	@RequestMapping(value = "/olderThan/{age}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get clientas that are older than given age.", notes = "Given age is not included in result range.")
	public List<ClientORM> getClientsOlderThan(@PathVariable String age) {
		return clientService.getClientsOlderThan(age);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Add new clients.", notes = "If the client exists, it won't create duplicates.")
	public ClientORM addClient(@RequestBody ClientORM clientORM) {
		return clientService.addClient(clientORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Update existing client by ID parameters.", notes = "If the client doesn't exist, it won't create a new one.")
	public ClientORM updateClient(@RequestBody ClientORM clientORM, @PathVariable String idType,
			@PathVariable String idValue) {
		return clientService.updateClient(idType, idValue, clientORM);
	}

	@RequestMapping(value = "/idType/{idType}/idValue/{idValue}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Delete existing client by ID parameters.", notes = "It will only return a (Done) message, when the client existed.")
	public String deleteClientByIdParams(@PathVariable String idType, @PathVariable String idValue) {
		return clientService.deleteClientByIdParams(idType, idValue);
	}

}