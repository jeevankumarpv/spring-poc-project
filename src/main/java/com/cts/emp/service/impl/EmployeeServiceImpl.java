/**
 * 
 */
package com.cts.emp.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.cts.emp.model.Employee;
import com.cts.emp.service.EmployeeService;
import com.cts.emp.dao.impl.EmployeeDAOImpl;

/**
 * @author 535858
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAOImpl employeeDAO;
	
	public void setEmployeeDAOImpl(EmployeeDAOImpl employeeDAO) {
		System.out.println("set daoimpl");
		this.employeeDAO=employeeDAO;
    }
	
	public EmployeeDAOImpl getEmployeeDAOImpl() {
		System.out.println("get daoimpl");
		return employeeDAO;
	}

    @Override
	public Employee getEmployee(String sno) {	
		System.out.println("entred into service getEmployee()");
		return employeeDAO.getEmployeeDAO(sno);
		
	}

	
    @Override
	public List<Employee> getEmployees() {
		System.out.println("entred into service getEmployees()");
		return employeeDAO.getEmployeesDAO();
	}

}
