package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.servic.EmpService;

@Controller
public class EmpCRUDController {

	EmpService empserv;

	@Autowired
	public EmpCRUDController(EmpService empserv) {
		this.empserv = empserv;
	}

	/**
	 * e selects the Add New Employee view to render by returning its name.
	 */
	@RequestMapping(value = "/emplist", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("Employees list in new project");

		// get all employees from DAO
		List<Employee> empList = empserv.listAll();

		// set it to the model
		model.addAttribute("elist", empList);

		// call the view
		return "emplist";
	}

	@RequestMapping(value = "/k", method = RequestMethod.GET)
	public String employeeLogin(Model model) {
		System.out.println("empLogin JSP Requested");
		return "login";
	}

	@RequestMapping(value = "/empdetails", method = RequestMethod.POST)
	public String getAllDetailsEmployee(Model model, @RequestParam("email") String email) {

		System.out.println("this is sp_orm controller getting employes method ");
		// get all employees from DAO
		Employee empdetails = empserv.getByEmail(email);

		// set it to the model
		model.addAttribute("empdet", empdetails);

		// call the view
		return "front";
	}

	@GetMapping("/ajax/{page}")
	public String getPageContent(@PathVariable("page") String page) {
		return page;

	}

}
