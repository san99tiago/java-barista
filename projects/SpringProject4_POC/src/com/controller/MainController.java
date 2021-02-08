package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ClientDAO;

@Controller
public class MainController {

	@Autowired
	private ClientDAO clientDaoClass; // Dependency injection for ClientDAO

	@RequestMapping(value = "/getClients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClients() {
		return clientDaoClass.getClients();
	}

	@GetMapping("/getClientById/idType/{idType}/idValue/{idValue}")
	@ResponseBody
	public String getClientBtId(@PathVariable("idType") String idType, @PathVariable("idValue") String idValue) {
		return "This JSON response is not developed yet";
	}

}
