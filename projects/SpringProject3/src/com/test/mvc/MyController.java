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
	public String staticPage() {
		return "staticPage";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm() {
		return "userForm";
	}

	@RequestMapping(value = "/finishedUserForm", method = RequestMethod.GET)
	public String finishedUserForm() {
		return "finishedUserForm";
	}

}
