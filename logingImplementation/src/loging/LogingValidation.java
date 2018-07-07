package loging;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class LogingValidation
 */
@WebServlet(urlPatterns = {"/LogingValidation"} , loadOnStartup=0)
public class LogingValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String username = "admin";
	private final String password = "adminHaHa";
	private final String name = "Aadmi";
	//private User user;
	private static HashMap<String, User> users;
	private static ArrayList<String> hardUsersList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogingValidation() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
    	
    	String[] hardUsers = {"admin1", "admin2", "admin3"};
    	hardUsersList = new ArrayList<String>(Arrays.asList(hardUsers));
    	users = (HashMap<String, User>)(getServletContext().getAttribute("users"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request.getSession().setAttribute("loginValidationCheck", false);
		
		if(!(hardUsersList.contains(request.getParameter("username"))) || !request.getParameter("password").equals(password)){
			System.out.println("match not found");
			request.getSession().setAttribute("loginValidationCheck", false);
			response.sendRedirect("invalid.html");
		}
		else{
			System.out.println("match found");
			
			request.getSession().setAttribute("loginValidationCheck", true);
			
			
			User user = users.get(request.getParameter("username"));
			if(user== null) 
				user = new User();
			
			user.setUsername(request.getParameter("username"));
	    	user.setName(name);
	    	user.setPassword(password);
	    	user.setLastActive(request.getSession().getCreationTime());
	    	user.setIsActive(true);
	    	users.put(user.getUsername(), user);

			request.getSession().setAttribute("user", user);
			
			response.sendRedirect("dashboard");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
