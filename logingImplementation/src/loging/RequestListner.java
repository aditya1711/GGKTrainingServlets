package loging;

//import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListner
 *
 */
@WebListener
public class RequestListner implements ServletRequestListener {

    /**
     * Default constructor. 
     */
	//private static HashMap<String, User> users;
	
    public RequestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    	//ServletContext context = arg0.getServletContext();
    	//HashMap<String, User> users = (HashMap<String,User>)(context.getAttribute("users"));
    	HttpServletRequest req = (HttpServletRequest)(arg0.getServletRequest());
    	User u = (User)(req.getSession().getAttribute("user"));
    	if(u!=null)
    		u.oneMoreRequest();
    		if(req.getParameter("error")!=null &&  !req.getParameter("error").equals("0")){
    			u.oneMoreInvalidRequest();
    		}
    	}
}
