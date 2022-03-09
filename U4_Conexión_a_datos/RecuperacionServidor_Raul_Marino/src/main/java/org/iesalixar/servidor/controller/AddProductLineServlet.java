package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProduct;
import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.dao.DAOProductLine;
import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.Product;
import org.iesalixar.servidor.model.ProductLine;


/**
 * Servlet implementation class AddProductLineServlet
 */

public class AddProductLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger( AddProductLineServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		

		request.getRequestDispatcher("/WEB-INF/view/Admin/addProductLine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productLine= request.getParameter("productLine");
		String textDescription= request.getParameter("textDescription");
		
		boolean actualizado;
		
		DAOProductLine dao = new DAOProductLineImpl();
		
		ProductLine p = new ProductLine(productLine,textDescription);		
		
		actualizado=dao.createProductLine(p);
		
		
		if(actualizado) {
			
			logger.info("Edicción exitosa");
			
			request.setAttribute("confir", "ProducLine añadido");
			
			request.getRequestDispatcher("/WEB-INF/view/Admin/addProductLine.jsp").forward(request, response);
			
		}else {			
					
			request.setAttribute("productLine", p);
			request.setAttribute("error", "ProducLine existente");
			
			request.getRequestDispatcher("/WEB-INF/view/Admin/addProductLine.jsp").forward(request, response);
		}
	}

}
