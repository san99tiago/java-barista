package com.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String mainPage() {
		return "mainPage";
	}
	
	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect() {
		return "staticPage.html";
	}
	
}
