package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/clients/idType/{idType}/idValue/{idValue}")
	@ResponseBody
	public String getClientBtId(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue) {
		return "This JSON response is not developed yet";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setNewClientBtId(@RequestBody String newClientInfoJSON) {
		// Map JSON to ClientORM object with "Gson" google library
		Gson g = new Gson();

		ClientORM newClientORM;
		try {
			newClientORM = g.fromJson(newClientInfoJSON, ClientORM.class);
		} catch (Exception e) {
			System.out.println("---> Could NOT convert JSON to Object <---");
			e.printStackTrace();
			return "[WARNING: The JSON in the body didn't follow the rules for adding new Clients.]";
		}

		// Response String based on the success of adding new client
		String responseString;

		// Add newClient to the database (if not repeated)
		boolean resultBoolean = clientDaoClass.setNewClient(newClientORM);

		if (resultBoolean == true) {
			responseString = "[SUCCEDED ... " + newClientORM.toString() + " ... added successfuly]";
		} else {
			responseString = "[FAILED (WARNING) ... " + newClientORM.toString() + " ... did NOT match rules to be added]";
		}

		return responseString;
	}

}
