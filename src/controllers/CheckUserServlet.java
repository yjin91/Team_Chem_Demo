package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelpers.UserUpdateQuery;
import model.User;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet(
		description = "this controller is used to validate user's login credentials", 
		urlPatterns = { 
				"/CheckUserServlet", 
				"/login"
		})
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//save the username as a session attribute for shopping cart use.
		
		session.setAttribute("username", username);
		
		//set up user object
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//set up userdbhelper object
		UserUpdateQuery up = new UserUpdateQuery("chemDB", "root", "123456");
		
		user = up.validateUser(username, password);
		
		String url = "";
		
		if (user != null) {
			 url = "viewproduct";
		} else if (user == null) {
			 url = "/loginerror.jsp";
		}
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
