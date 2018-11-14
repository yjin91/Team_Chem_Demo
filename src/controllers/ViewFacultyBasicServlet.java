package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelpers.ViewFacultyBasicQuery;

/**
 * Servlet implementation class ViewFacultyBasicServlet
 */
@WebServlet({ "/ViewFacultyBasicServlet", "/viewfacultybasic" })
public class ViewFacultyBasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFacultyBasicServlet() {
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
		
		ViewFacultyBasicQuery vfb = new ViewFacultyBasicQuery("chemDB", "root", "123456");
		vfb.doRead();
		
		String div = vfb.getHTMLTable();
		
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		
		request.setAttribute("div", div);
		String url= "/viewfacultybasic.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
