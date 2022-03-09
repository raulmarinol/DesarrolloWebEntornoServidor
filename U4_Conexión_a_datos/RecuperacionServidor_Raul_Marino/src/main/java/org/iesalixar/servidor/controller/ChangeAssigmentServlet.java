package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger( ChangeAssigmentServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOProductLine daoProductLineImpl = new DAOProductLineImpl();
    	DAOProduct daoProduct = new DAOProductImpl();

		ArrayList<ProductLine> productLineList = (ArrayList<ProductLine>) daoProductLineImpl.getAllProductLine();
		ArrayList<Product> productList = (ArrayList<Product>) daoProduct.getAllProducts();

		request.setAttribute("productLineList", productLineList);
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher("/WEB-INF/view/Admin/changeProduct.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName= request.getParameter("productName");
		String productLine= request.getParameter("productLine");
			
		
		boolean actualizado;		
		
		DAOProduct dao = new DAOProductImpl();		
				
		actualizado=dao.cambiarProductLine(productLine, productName);
		
		DAOProductLine daoProductLineImpl = new DAOProductLineImpl();

		ArrayList<ProductLine> productLineList = (ArrayList<ProductLine>) daoProductLineImpl.getAllProductLine();
		ArrayList<Product> productList = (ArrayList<Product>) dao.getAllProducts();

		request.setAttribute("productLineList", productLineList);
		request.setAttribute("productList", productList);
			

		
		if(actualizado) {
			logger.info("Modificacion exitosa");
			request.setAttribute("confir", "Modificacion realizada");
			request.getRequestDispatcher("/WEB-INF/view/Admin/changeProduct.jsp").forward(request, response);
		}else {
			logger.info("Modificacion no posible");
			request.getRequestDispatcher("/WEB-INF/view/Admin/changeProduct.jsp").forward(request, response);
		}		
	}

}
