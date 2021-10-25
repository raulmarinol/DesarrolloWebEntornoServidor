package org.iesalisar.servidor.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmarServlet
 */
@WebServlet("/ConfirmarServlet")
public class ConfirmarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion!=null && sesion.getAttribute("usuario") == null) {
			response.sendRedirect("LogOut");
		}else {
			request.getRequestDispatcher("confirmarJSP.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("usuario") != null) {
			String finicio = request.getParameter("nombre");
			String ffin = request.getParameter("apellidos");
			String numero = request.getParameter("correo");
			String[] extras = request.getParameterValues("extras");
			
			
			sesion.setAttribute("fechainicio", finicio);
			sesion.setAttribute("apellidos", ffin);
			sesion.setAttribute("numpersonas", numero);
			sesion.setAttribute("extras",Arrays.toString(extras));
		
			response.sendRedirect("ConfirmarServlet");
		}else {
			response.sendRedirect("LogOut");
		}
	}

}
