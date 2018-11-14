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
 * Servlet implementation class ViewFacultyCredentialServlet
 */
@WebServlet({ "/ViewFacultyCredentialServlet", "/viewcredential" })
public class ViewFacultyCredentialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFacultyCredentialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		request.setAttribute("username", username);
		
		int facultyid = Integer.parseInt(request.getParameter("facultyid"));
		
		ViewFacultyBasicQuery vfb = new ViewFacultyBasicQuery("chemDB", "root", "123456");
		
		vfb.readCredential(facultyid);
		String div = vfb.getCredentialHTMLTable();
		
		request.setAttribute("div", div);
		
		String url = "/viewfacultycredential.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
