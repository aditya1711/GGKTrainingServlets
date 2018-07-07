package loging;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDisplay
 */
@WebServlet("/UserDisplay")
public class UserDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, User> users;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
    	users = (HashMap<String, User>)(getServletContext().getAttribute("users"));
    }
    
    public String longTimeToTime(long t){
    	Date date = new Date(t);
    	//Time time = new Time(t);
    	return date.toString();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<String[]> modelActive = new ArrayList<String[]>();
		ArrayList<String[]> modelInActive = new ArrayList<String[]>();
		
		//PrintWriter pw =response.getWriter();
		
		for(Map.Entry<String, User> userEntry : users.entrySet()){
			User user = userEntry.getValue();
			if(user.getIsActive()){
				String temp[] = new String[4];
				temp[0] = user.getUsername();
				temp[1] = longTimeToTime(user.getLastActive());
				temp[2] = user.getRequestCount().toString();
				temp[3] = user.getInvalidRequestCount().toString();
				modelActive.add(temp);
				System.out.println("ACTIVE " +  user.getUsername() + "Active Since " + user.getLastActive());
			}
			else {
				String temp[] = new String[4];
				temp[0] = user.getUsername();
				temp[1] = longTimeToTime(user.getLastActive());
				temp[2] = user.getRequestCount().toString();
				temp[3] = user.getInvalidRequestCount().toString();
				modelInActive.add(temp);
				System.out.println("INACTIVE " +  user.getUsername() + "last Seen " + user.getLastActive());
			}
		}
		request.setAttribute("modelActive", modelActive);
		request.setAttribute("modelInActive", modelInActive);
		
		ArrayList<String[]> active = (ArrayList<String[]>)(request.getAttribute("modelActive"));
		ArrayList<String[]> InActive = (ArrayList<String[]>)(request.getAttribute("modelInActive"));
		System.out.println("ACTIVE SIZE " + active.size() );
		System.out.println("INACTIVE SIZE " + InActive.size() );
		
		request.getRequestDispatcher("UserDetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
