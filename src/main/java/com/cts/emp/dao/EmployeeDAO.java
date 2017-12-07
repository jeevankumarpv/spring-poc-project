package com.cts.emp.dao;

import java.util.List;

import com.cts.emp.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmployeeDAO(String sno);
	public List<Employee> getEmployeesDAO();	

}
