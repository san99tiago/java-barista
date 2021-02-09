package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ClientDAO;
import com.google.gson.Gson;
import com.orm.ClientORM;

@Controller
public class MainController {

	@Autowired
	private ClientDAO clientDaoClass; // Dependency injection

	@RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClients() {
		return clientDaoClass.getClients();
	}

	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClientByIdParams(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue) {
		return clientDaoClass.getClientByIdParams(idType, idValue);
	}

	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateClientByIdParams(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue,
			@RequestBody String updatedClientInfoJSON) {
		ClientORM updatedClientORM = getClientFromJSON(updatedClientInfoJSON);

		return clientDaoClass.updateClientByIdParams(idType, idValue, updatedClientORM);
	}

	@RequestMapping(value = "/clients/idType/{idType}/idValue/{idValue}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteClientByIdParams(@PathVariable("idType") String idType,
			@PathVariable("idValue") String idValue) {
		return clientDaoClass.deleteClientByIdParams(idType, idValue);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setNewClientBtId(@RequestBody String newClientInfoJSON) {
		ClientORM newClientORM = getClientFromJSON(newClientInfoJSON);

		// Response String based on the success of adding new client
		String responseString;

		// Add newClient to the database (if not repeated)
		boolean resultBoolean = clientDaoClass.setNewClient(newClientORM);

		if (resultBoolean == true) {
			responseString = "[SUCCEDED ... " + newClientORM.toString() + " ... added successfuly]";
		} else {
			responseString = "[FAILED (WARNING) ... " + newClientORM.toString()
					+ " ... did NOT match rules to be added]";
		}

		return responseString;
	}

	public ClientORM getClientFromJSON(String clientInfoJSON) {
		// Map JSON to ClientORM object with "Gson" google library
		Gson g = new Gson();

		try {
			ClientORM client = g.fromJson(clientInfoJSON, ClientORM.class);
			return client;
		} catch (Exception e) {
			System.out.println("---> Could NOT convert JSON to Object <---");
			e.printStackTrace();
			return null;
		}
	}

}
