package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomer;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployee;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;
/**
 * Servlet implementation class AddCustomer
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCustomer dao = new DAOCustomerImpl();
		
		ArrayList<Customer> customerList = (ArrayList<Customer>) dao.getAllCustomers();

		request.setAttribute("customerList", customerList);
		

		request.getRequestDispatcher("/WEB-INF/view/Admin/addCustomer.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String employeeNumber= request.getParameter("employeeNumber");
		String lastName= request.getParameter("lastName");
		String firstName= request.getParameter("firstName");
		String extension= request.getParameter("extension");
		String email= request.getParameter("email");
		String officeCode= request.getParameter("officeCode");
		String reportsTo= request.getParameter("reportsTo");
		String jobTitle= request.getParameter("jobTitle");
	
		
		Integer employeeNumberI = Integer.valueOf(employeeNumber);
		Integer reportsToI = Integer.valueOf(reportsTo);
		
		
		
		DAOEmployee dao = new DAOEmployeeImpl();
		
		Employee e = new Employee(employeeNumberI, lastName, firstName, extension, email, officeCode, reportsToI, jobTitle);
		
		dao.insertEmployee(e);
		
		
		DAOEmployee daoEmployee = new DAOEmployeeImpl();

		ArrayList<Employee> employeeeList = (ArrayList<Employee>) daoEmployee.getAllEmployees();

		request.setAttribute("employeeeList", employeeeList);
		
		request.getRequestDispatcher("/WEB-INF/view/Admin/listaEmpleados.jsp").forward(request, response);
		
	}

}

