package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductLineReportServlet
 */
@WebServlet("/ProductLineReportServlet")
public class ProductLineReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductLineReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id= request.getParameter("id");
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/informe.jsp").forward(request, response);
		
	}

}
