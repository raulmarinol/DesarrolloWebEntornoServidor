package org.iesalixar.servidor.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroInicio
 */
@WebFilter("/FiltroInicio")
public class FiltroInicio implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroInicio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession();
		String usuario = (String) session.getAttribute("usuario");
		String role = (String) session.getAttribute("role");
		
		if (!session.isNew() && usuario != null) {
			if (role.equals("usuario") || role.equals("admin") ) {
				chain.doFilter(request, response);
			}
			
		
		} else {
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/");//Aqui donde lo direcionamos
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}