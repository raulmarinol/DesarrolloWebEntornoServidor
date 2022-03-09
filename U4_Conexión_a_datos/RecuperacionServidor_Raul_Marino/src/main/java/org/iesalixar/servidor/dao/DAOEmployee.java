package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Employee;

public interface DAOEmployee {

	public Employee getEmployee(int employeeNumber);
	public List<Employee> getAllEmployees();
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean removeEmployee(int employeeNumber);	
	public int getNumberEmployee();	
	public Employee getDatosNombre(String firstName);
}
