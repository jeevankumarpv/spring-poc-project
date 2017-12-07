/**
 * 
 */
package com.cts.emp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.cts.emp.dao.EmployeeDAO;
import com.cts.emp.model.Employee;



/**
 * @author 535858
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	private DataSource dataSource;
	Employee employee;
	Connection con;
	
	public void setDataSource(DataSource dataSource) {
		System.out.println("set datasource");
		this.dataSource=dataSource;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public Employee getEmployeeDAO(String sno) {  
		
		System.out.println("entered into getEmployeesDAO()");
		try{
			System.out.println("entered into try block");
			System.out.println("got datasource: "+dataSource.getConnection());
			con=dataSource.getConnection();
			System.out.println("got connection object: "+con);
			Statement stmt=con.createStatement();
			System.out.println("created statement object: "+stmt);
			String query = "SELECT * FROM employee WHERE sno=" + sno;
			System.out.println("query executed: "+query);
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("got resultset object: "+rs);
			if (rs.next()) {
				System.out.println("enterd into if condition");
				employee = new Employee();
				System.out.println("employee object cretaed");
				employee.setSno(rs.getString("sno"));
				employee.setName(rs.getString("name"));
				employee.setSalary(rs.getString("salary"));
			}
		}catch(SQLException sqle){
			System.out.println("exceptio in getEmployeeDAO: "+sqle);
			sqle.getStackTrace();
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
		System.out.println("return employee object: " +employee);
		return employee;				
	}
				 	 
	
	public List<Employee> getEmployeesDAO(){
		
		System.out.println("entered into getEmployeesDAO()");
		
		ArrayList<Employee>  list = new ArrayList<Employee>();
		System.out.println("list object created in daoimpl");
		
		try{
			System.out.println("entered into try block");
			System.out.println("got datasource "+dataSource.getConnection());
			con=dataSource.getConnection();
			System.out.println("got connection object: "+con);
			Statement s = con.createStatement();
			System.out.println("created statement object: "+s);
			String query = "Select * from employee";
			System.out.println("query executed: "+query);
			ResultSet rst = s.executeQuery(query);
			System.out.println("got resultset object: "+rst);

			while(rst.next()) { 
				System.out.println("enterd into while loop");
				Employee e=new Employee();
				System.out.println("employee object cretaed");
				e.setSno(rst.getString(1));  
				e.setName(rst.getString(2));  
				e.setSalary(rst.getString(3));      
				list.add(e);
				System.out.println("employee added to list");
			}
		}		
		catch(SQLException sqle){
			System.out.println("entred into catch block");
			System.out.println("exception is: "+sqle);
			sqle.getStackTrace();
		}
		finally {
			System.out.println("entred into finally block");
			try {
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		System.out.println("return list object: " +list);
		return list;
		
		
	}  

}
