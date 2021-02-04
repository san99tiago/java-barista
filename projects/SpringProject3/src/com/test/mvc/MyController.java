package com.test.mvc;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = {"/", "/mainPage"}, method = RequestMethod.GET)
	public String mainPage() {
		return "mainPage";
	}

	@RequestMapping(value = {"/staticPage", "/staticpage"}, method = RequestMethod.GET)
	public String staticPage() {
		return "redirect:/resources/staticPage.html";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm() {
		return "userForm";
	}

	@RequestMapping(value = "/finishedUserForm", method = RequestMethod.GET)
	public String finishedUserForm(HttpServletRequest request, Model model) {
		// Get current date/time from server using GregorianCalendar library
		GregorianCalendar calendar = new GregorianCalendar();
		Date currentTime = calendar.getTime();

		// Get UserName parameter from the already filled form
		String name = request.getParameter("UserName");

		// Generate custom message for the user based on his response
		String modelInfo = name + ", you are amazing and you registered on: " + currentTime.toString() + "\n";

		// Add custom message and attribute to the "Model" of the MVC
		model.addAttribute("messageForUser", modelInfo);

		return "finishedUserForm";
	}

}
