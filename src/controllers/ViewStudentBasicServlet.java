package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelpers.ViewStudentBasicQuery;

/**
 * Servlet implementation class ViewStudentBasicServlet
 */
@WebServlet(
		description = "this controller is used to display student basic information table",
		urlPatterns = { 
				"/ViewStudentBasicServlet", 
				"/viewstudentbasic" 
		})
public class ViewStudentBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ViewStudentBasicQuery vsb = new ViewStudentBasicQuery("chemDB", "root", "123456");
		
		vsb.doRead();
		String div = vsb.getHTMLTable();
		
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		
		request.setAttribute("div", div);
		String url= "/viewstudentbasic.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}
