package com.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.challenge.service.ClientPhotoService;

@Controller
@RequestMapping(value = "/clientphotos")
public class ClientPhotoController {

	@Autowired
	private ClientPhotoService clientPhotoService; // Dependency injection

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getClientPhotos() {
		return clientPhotoService.getClientPhotos();
	}
}
