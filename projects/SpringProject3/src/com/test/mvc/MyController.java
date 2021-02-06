// Santiago Garcia Arango

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = { "/", "/mainPage" }, method = RequestMethod.GET)
	public String mainPage() {
		return "mainPage";
	}

	@RequestMapping(value = { "/staticPage", "/staticpage" }, method = RequestMethod.GET)
	public String staticPage() {
		return "redirect:/resources/staticPage.html";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm(Model model) {
		return "userForm";
	}

	@RequestMapping(value = "/finishedUserForm", method = RequestMethod.GET)
	public String finishedUserForm(HttpServletRequest request, Model model) {

		// Get parameters from the form via "request.getParameter(...)"
		String name = request.getParameter("UserName");
		String birthday = request.getParameter("UserBirthday");
		String language = request.getParameter("UserProgrammingLangugae");

		Developer devObject = new Developer();

		devObject.setName(name);
		devObject.setBirthday(birthday);
		devObject.setRegistrationDate();
		devObject.setMainLanguage(language);

//		addDeveloperToDatabase(devObject);

		// Add custom message and attribute to the "Model" of the MVC
		model.addAttribute("developerIdentifier", devObject);

		return "finishedUserForm";
	}

	private void addDeveloperToDatabase(Developer devObject) {
		// Create SessionFactory for correct ORM implementation
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(DeveloperORM.class).buildSessionFactory();

		// Create Session based on already created SessionFactory
		Session mySession = myFactory.openSession();

		try {

			System.out.println("--- Starting object: " + devObject.getName() + " creation to add to database ---");
			DeveloperORM newDevObj = new DeveloperORM(devObject.getName(), devObject.getMainLanguage(),
					devObject.getBirthday(), devObject.getRegistrationDate());

			mySession.beginTransaction();
			mySession.save(newDevObj);
			mySession.getTransaction().commit();
			mySession.close();

			System.out.println("--- Added object:" + devObject.getName() + " succesfully to database ---");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			myFactory.close();
		}
	}

}
