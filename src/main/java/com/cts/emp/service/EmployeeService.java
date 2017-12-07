package com.cts.emp.service;

import java.util.List;

import com.cts.emp.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(String sno);
	public List<Employee> getEmployees();

}
