package com.cts.emp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.cts.emp.dao.impl.EmployeeDAOImpl;
import com.cts.emp.model.Employee;
import com.cts.emp.service.impl.EmployeeServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {


	private EmployeeServiceImpl employeeService;
	
	public void setEmployeeServiceImpl(EmployeeServiceImpl employeeService) {
		System.out.println("inside set serviceimpl");
		
		this.employeeService=employeeService;
	}
	
	public EmployeeServiceImpl getEmployeeServiceImpl() {
		return employeeService;
	}



	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welocomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/home");
		System.out.println("welcome model object return");
		return model;
	}

	@RequestMapping(value = "/empobject", method = RequestMethod.GET)
	public ModelAndView empObject() {
		System.out.println("search emp model object return");
		return new ModelAndView("searchemp","command",new Employee());  
	}


	@RequestMapping(value = "/searchdata", method = RequestMethod.GET)
	public ModelAndView search(String sno)throws SQLException, ClassNotFoundException {
		System.out.println("entred into search controller");
		ModelAndView model = new ModelAndView();
		System.out.println("search model object created");
		Employee employee = employeeService.getEmployee(sno);
		System.out.println("service called got employee object:"+employee);
		model.addObject("employee",employee);
		model.setViewName("searchdata");
		return model; 	

	}
	

	@RequestMapping(value = "/viewallemp", method = RequestMethod.GET)
	public ModelAndView viewAllEmployess() throws SQLException, ClassNotFoundException  {		
		System.out.println("enter into viewallemployees controller");
		ModelAndView model = new ModelAndView();
		System.out.println("viewAllEmployess model object created");
		List<Employee> employeeList=employeeService.getEmployees();
		System.out.println("service called got employee list object:"+employeeList);
		model.addObject("employeeList", employeeList);
		model.setViewName("viewallemp");
		return model;
			

	}
}


