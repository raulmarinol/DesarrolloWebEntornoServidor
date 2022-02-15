package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOffice;
import org.iesalixar.servidor.dao.DAOOfficeImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class Oficinas
 */

public class OficinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		DAOOffice dao = new DAOOfficeImpl();		
		List<Office> oficinas = dao.getAllOffices();
		
		
		request.setAttribute("oficinas", oficinas);
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/listaOficina.jsp").forward(request, response);
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Comprobamos si tenemos los datos de la petición del formulario
		String oficina = request.getParameter("oficinas");

		if(oficina!=null) {
			
			DAOOfficeImpl dao = new DAOOfficeImpl();
			
			Office office = dao.getByNameOffice(oficina) ;
			
			if(office!=null) {
					
				request.setAttribute("officeCode", office.getOfficeCode());
				request.setAttribute("city", office.getCity());
				request.setAttribute("phone",office.getPhone());
				request.setAttribute("addresLine1",office.getAddressLine1());
				request.setAttribute("addresLine2",office.getAddressLine2());
				request.setAttribute("state",office.getState());
				request.setAttribute("country",office.getCountry());
				request.setAttribute("postalCode",office.getPostalCode());
				request.setAttribute("territory", office.getTerritory());
				
				
				
			}
			
			List<Office> oficinas = dao.getAllOffices();
			
			
			request.setAttribute("oficinas", oficinas);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/listaOficina.jsp").forward(request, response);

	}

}
