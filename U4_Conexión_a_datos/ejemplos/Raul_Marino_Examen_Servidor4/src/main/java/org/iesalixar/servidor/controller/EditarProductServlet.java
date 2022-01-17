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
 * Servlet implementation class EditarProductServlet
 */
@WebServlet("/EditarProductServlet")
public class EditarProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(EditarProductServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String producto= request.getParameter("pc");
		
		DAOProduct daoProduct = new DAOProductImpl();		
		Product product = daoProduct.getProductByCode(producto);
		
		DAOProductLine daoProductLine = new DAOProductLineImpl();		
		List<ProductLine> listaProductLine = daoProductLine.getAllProductLine();
		
		
		request.setAttribute("listaProductLine", listaProductLine);
		
		request.setAttribute("product", product);
		
		
		response.sendRedirect(request.getContextPath() + "/Admin/Inicio");
		//request.getRequestDispatcher("/WEB-INF/view/Admin/seeProdcut.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode= request.getParameter("productCode");
		String productName= request.getParameter("productName");
		String productLine= request.getParameter("productLine");
		String productScale= request.getParameter("productScale");
		String productVendor= request.getParameter("productVendor");
		String productDescription= request.getParameter("productDescription");
		String quantityInStock= request.getParameter("quantityInStock");
		String buyPrice= request.getParameter("buyPrice");
		String msrp= request.getParameter("msrp");
		
		Integer quantityInStockd = Integer.valueOf(quantityInStock);
		double buyPriced = Double.parseDouble(buyPrice);
		double msrpd = Double.parseDouble(msrp);
		
		boolean actualizado;
		
		
		DAOProduct dao = new DAOProductImpl();
		
		Product p = new Product(productName, productCode, productLine, productScale, productVendor, productDescription, quantityInStockd, buyPriced, msrpd);
		
		
		actualizado=dao.updateProduct(p);
		// Obtengo desde la base de datos y través del DAO todos los Productos
		DAOProduct daoProductImpl = new DAOProductImpl();

		ArrayList<Product> productsList = (ArrayList<Product>) daoProductImpl.getAllProducts();

		request.setAttribute("ProductsList", productsList);
		if(actualizado) {
			logger.info("Edicción exitosa");
			request.getRequestDispatcher("/WEB-INF/view/Admin/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/Admin/index.jsp").forward(request, response);
		}
			
		
		
		
	}

}
