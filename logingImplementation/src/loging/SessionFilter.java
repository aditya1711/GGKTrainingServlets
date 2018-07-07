package loging;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
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
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//System.out.println("FILTERING");
		
		HttpServletRequest req = (HttpServletRequest)(request);
		HttpServletResponse res = (HttpServletResponse)(response); 
		
		HttpSession session = req.getSession();
		
		String temp = req.getRequestURI().split("/")[2];
		//System.out.println("temp: " + temp);
		Enumeration<String> attribNames = session.getAttributeNames();
		//System.out.println(temp.equals("login.html"));
		
		Object o = session.getAttribute("loginValidationCheck");
		boolean loginValidationCheck = (boolean)(o);
		
		//System.out.println(loginValidationCheck);
		
		
		
		if (!(temp.equals("login") || temp.equals("LogingValidation") || temp.equals("invalid.html") || temp.equals("UserDisplay") || temp.equals("login.jsp"))) {
			
			//System.out.println("filter first if entered");
			
			/*while(attribNames.hasMoreElements()){
				if(attribNames.nextElement().equals("loginValidationCheck")){
					loginValidationCheck = (boolean)(session.getAttribute("loginValidationCheck"));
					break;
				}
				
			}*/
			
			if (!loginValidationCheck) {
				//System.out.println("filter second if entered");
				res.sendRedirect("login");
			}
			else{
				chain.doFilter(request, response);
			}
		}
		else if(temp.equals("login") && loginValidationCheck){
			res.sendRedirect("dashboard");
		}
		else{
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
