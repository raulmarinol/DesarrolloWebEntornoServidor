package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomer;
import org.iesalixar.servidor.dao.DAOCustomerImpl;
import org.iesalixar.servidor.dao.DAOEmployee;
import org.iesalixar.servidor.dao.DAOEmployeeImpl;
import org.iesalixar.servidor.dao.DAOOffice;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class AddPaymentServlet
 */
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployee dao = new DAOEmployeeImpl();
		int codEmployee = dao.getNumberEmployee();
		
		DAOOffice daoOffice = new DAOOfficeImpl();
		ArrayList<Office> officeList = (ArrayList<Office>) daoOffice.getAllOffices();
		
		DAOEmployee daoEmpoyee = new DAOEmployeeImpl(); 
		ArrayList<Employee> employeeList = (ArrayList<Employee>) daoEmpoyee.getAllEmployees();

		request.setAttribute("employeeNumber", codEmployee);
		request.setAttribute("officeList", officeList);
		request.setAttribute("employeeList", employeeList);
		

		request.getRequestDispatcher("/WEB-INF/view/Admin/addEmployee.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String customerNumber= request.getParameter("customerNumber");
		String customerName= request.getParameter("customerName");
		String contactLastName= request.getParameter("contactLastName");
		String contactFirstName= request.getParameter("contactFirstName");
		String phone= request.getParameter("phone");
		String addressLine1= request.getParameter("addressLine1");
		String addressLine2= request.getParameter("addressLine2");
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		String postalCode= request.getParameter("postalCode");
		String country= request.getParameter("country");
		String salesRepEmployeeNumber= request.getParameter("salesRepEmployeeNumber");
		String creditLimit= request.getParameter("creditLimit");
	
		
		Integer customerNumberI = Integer.valueOf(customerNumber);
		Integer salesRepEmployeeNumberI = Integer.valueOf(salesRepEmployeeNumber);
		Double creditLimitD = Double.valueOf(creditLimit);
		
		boolean actualizado;
		
		
		DAOCustomer dao = new DAOCustomerImpl();
		
		Customer c = new Customer(customerNumberI, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumberI, creditLimitD);
		
		
		actualizado=dao.updateCustomer(c);
		
		DAOCustomer daoCustomer = new DAOCustomerImpl();

		ArrayList<Customer> customerList = (ArrayList<Customer>) daoCustomer.getAllCustomers();

		request.setAttribute("customerList", customerList);
		if(actualizado) {
			logger.info("Edicción exitosa de Customer se añadio");
			request.getRequestDispatcher("/WEB-INF/view/Admin/listaCustomer.jsp").forward(request, response);
		}else {
			logger.info("Edicción no exitosa de Customer se añadio");
			request.getRequestDispatcher("/WEB-INF/view/Admin/listaCustomer.jsp").forward(request, response);
		}
		
	}

}

