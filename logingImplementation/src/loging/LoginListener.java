package loging;

import java.util.HashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	//HashMap users = (HashMap)(arg0.getSession().getServletContext().getAttribute("users"));
    	arg0.getSession().setAttribute("loginValidationCheck", false);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("session destroyed");
    	HttpSession session = arg0.getSession();
    	HashMap<String, User> users = (HashMap<String, User>)(session.getServletContext().getAttribute("users"));
    	User user = (User)(session.getAttribute("user"));
    	if(user!=null){
    		user.setIsActive(false);
        	users.replace(user.getUsername(), user);
    	}
    	
    	
    }
	
}
